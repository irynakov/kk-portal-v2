package com.kk.portal.client.app.ui.view.decksholder.dnd;

import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.user.client.ui.HTMLPanel;

public class DragTarget extends HTMLPanel {

	@UiConstructor
	public DragTarget() {
		super("");
		setStylePrimaryName("drag-target");
		setStyleName("disabled", true);
	}

}
