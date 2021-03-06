/*******************************************************************************
 * Copyright (c) 2016 Red Hat Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Red Hat Inc. - initial API and implementation
 *******************************************************************************/
package org.jboss.tools.vscode.java.internal.handlers;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.core.IBuffer;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;

final public class JsonRpcHelpers {
	
	/**
	 * Convert line, column to a document offset.  
	 * @param buffer
	 * @param line
	 * @param column
	 * @return
	 */
	public static int toOffset(IBuffer buffer, int line, int column){
		try {
			return toDocument(buffer).getLineOffset(line) + column;
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	/**
	 * Convert offset to line number and column.
	 * @param buffer
	 * @param line
	 * @param column
	 * @return
	 */
	public static int[] toLine(IBuffer buffer, int offset){
		IDocument document = toDocument(buffer);
		try {
			int line = document.getLineOfOffset(offset);
			int column = offset - document.getLineOffset(line); 
			return new int[] {line, column};
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static Map<String, Object> convertRange(int startLine, int startCol, int endLine, int endCol) {
		Map<String, Object> range = new HashMap<String, Object>();
		Map<String, Object> start = new HashMap<String, Object>();
		Map<String, Object> end = new HashMap<String, Object>();
		if(startLine >-1)
			start.put("line",startLine);
		if(startCol > -1)
			start.put("character", startCol);
		if(endCol >-1)
			end.put("character",endCol);
		if(endLine > -1)
			end.put("line",endLine);
		range.put("start",start);
		range.put("end",end);
		return range;
	}

	/**
	 * Returns an {@link IDocument} for the given buffer.
	 * The implementation tries to avoid copying the buffer unless required.
	 * The returned document may or may not be connected to the buffer.
	 * 
	 * @param buffer a buffer
	 * @return a document with the same contents as the buffer
	 */
	public static IDocument toDocument(IBuffer buffer) {
		if (buffer instanceof IDocument) {
			return (IDocument) buffer;
		} else if (buffer instanceof org.jboss.tools.vscode.java.internal.DocumentAdapter) {
			IDocument document = ((org.jboss.tools.vscode.java.internal.DocumentAdapter) buffer).getDocument();
			if (document != null) {
				return document;
			}
		}
		return new org.eclipse.jdt.internal.core.DocumentAdapter(buffer);
	}
}
