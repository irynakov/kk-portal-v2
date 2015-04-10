package com.kk.portal.client.app.ui.view.workspace;

import java.util.logging.Logger;

import com.google.gwt.event.shared.SimpleEventBus;

public class WorkspaceEventBus extends SimpleEventBus {

	private static final Logger LOG = Logger.getLogger(WorkspaceEventBus.class.getName());

	public WorkspaceEventBus() {
		super();
		LOG.info("Workspace EventBus for application created.");
	}
}
