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

public class InitializeResult {

	/**
	 * Defines the capabilities provided by a language
	 *
	 * server.
	 * (Required)
	 *
	 */
	@SerializedName("capabilities")
	@Expose
	private ServerCapabilities capabilities;

	/**
	 * Defines the capabilities provided by a language
	 *
	 * server.
	 * (Required)
	 *
	 * @return
	 *     The capabilities
	 */
	public ServerCapabilities getCapabilities() {
		return capabilities;
	}

	/**
	 * Defines the capabilities provided by a language
	 *
	 * server.
	 * (Required)
	 *
	 * @param capabilities
	 *     The capabilities
	 */
	public void setCapabilities(ServerCapabilities capabilities) {
		this.capabilities = capabilities;
	}

	public InitializeResult withCapabilities(ServerCapabilities capabilities) {
		this.capabilities = capabilities;
		return this;
	}

}
