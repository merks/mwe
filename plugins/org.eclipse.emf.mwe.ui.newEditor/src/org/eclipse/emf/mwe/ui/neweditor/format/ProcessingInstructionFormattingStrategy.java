/*
 * Copyright (c) 2008 committers of openArchitectureWare and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    committers of openArchitectureWare - initial API and implementation
 */

package org.eclipse.emf.mwe.ui.neweditor.format;

/**
 * @author Patrick Schoenbach
 * @version $Revision: 1.2 $
 */
public class ProcessingInstructionFormattingStrategy extends
        DefaultFormattingStrategy {
    @Override
    public String format(final String content, final boolean isLineStart,
            final String indentation, final int[] positions) {
        return content;
    }

}