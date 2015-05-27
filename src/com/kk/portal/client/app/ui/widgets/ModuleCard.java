package com.kk.portal.client.app.ui.widgets;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.kk.portal.client.app.ui.module.ModuleView;

public class ModuleCard extends Composite {

	private static ModuleCardUiBinder uiBinder = GWT.create(ModuleCardUiBinder.class);

	interface ModuleCardUiBinder extends UiBinder<HTMLPanel, ModuleCard> {}

	public ModuleCard(ModuleView<?> content) {
		HTMLPanel wrapper = uiBinder.createAndBindUi(this);
		wrapper.add(content);

		initWidget(wrapper);
	}
}
