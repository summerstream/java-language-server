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
package org.jboss.tools.langs;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DocumentHighlight {

	/**
	 *
	 * (Required)
	 *
	 */
	@SerializedName("range")
	@Expose
	private Range range;
	/**
	 * The highlight kind, default is [text](#DocumentHighlightKind.Text).
	 *
	 */
	@SerializedName("kind")
	@Expose
	private Integer kind;

	/**
	 *
	 * (Required)
	 *
	 * @return
	 *     The range
	 */
	public Range getRange() {
		return range;
	}

	/**
	 *
	 * (Required)
	 *
	 * @param range
	 *     The range
	 */
	public void setRange(Range range) {
		this.range = range;
	}

	public DocumentHighlight withRange(Range range) {
		this.range = range;
		return this;
	}

	/**
	 * The highlight kind, default is [text](#DocumentHighlightKind.Text).
	 *
	 * @return
	 *     The kind
	 */
	public Integer getKind() {
		return kind;
	}

	/**
	 * The highlight kind, default is [text](#DocumentHighlightKind.Text).
	 *
	 * @param kind
	 *     The kind
	 */
	public void setKind(Integer kind) {
		this.kind = kind;
	}

	public DocumentHighlight withKind(Integer kind) {
		this.kind = kind;
		return this;
	}

}
