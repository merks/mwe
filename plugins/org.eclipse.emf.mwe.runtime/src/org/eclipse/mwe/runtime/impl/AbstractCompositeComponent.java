package org.eclipse.mwe.runtime.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.mwe.runtime.IWorkflowComponent;
import org.eclipse.mwe.runtime.IWorkflowContext;
import org.eclipse.mwe.runtime.callbacks.IPostExecutionCallback;
import org.eclipse.mwe.runtime.callbacks.IPreExecutionCallback;
import org.eclipse.mwe.runtime.status.Status;
import org.eclipse.mwe.runtime.status.StatusType;

public abstract class AbstractCompositeComponent implements IWorkflowComponent, IPreExecutionCallback,
		IPostExecutionCallback {
	private List<IWorkflowComponent> children = new ArrayList<IWorkflowComponent>();

	public void addComponent(IWorkflowComponent component) {
		this.children.add(component);
	}

	public Status preExecute() {
		for (IWorkflowComponent comp : children) {
			if (comp instanceof IPreExecutionCallback) {
				Status status = ((IPreExecutionCallback) comp).preExecute();
				if (status.getType() == StatusType.FAILURE) {
					return status;
				}
			}
		}
		return Status.success();
	}

	public Status postExecute() {
		for (IWorkflowComponent comp : children) {
			if (comp instanceof IPostExecutionCallback) {
				Status status = ((IPostExecutionCallback) comp).postExecute();
				if (status.getType() == StatusType.FAILURE) {
					return status;
				}
			}
		}
		return Status.success();
	}

	public Status execute(IWorkflowContext ctx) {
		for (IWorkflowComponent comp : children) {
			Status status = comp.execute(ctx);
			if (status.getType() == StatusType.FAILURE) {
				return status;
			}
		}
		return Status.success();
	}

}