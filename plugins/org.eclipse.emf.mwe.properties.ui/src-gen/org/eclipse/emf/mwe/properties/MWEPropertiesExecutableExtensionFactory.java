
/*
 * generated by Xtext
 */
 
package org.eclipse.emf.mwe.properties;

import org.eclipse.xtext.ui.core.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

import com.google.inject.Injector;

/**
 *@generated
 */
public class MWEPropertiesExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return org.eclipse.emf.mwe.properties.internal.MWEPropertiesActivator.getInstance().getBundle();
	}
	
	@Override
	protected Injector getInjector() {
		return org.eclipse.emf.mwe.properties.internal.MWEPropertiesActivator.getInstance().getInjector("org.eclipse.emf.mwe.properties.MWEProperties");
	}
	
}