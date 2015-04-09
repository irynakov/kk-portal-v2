package com.kk.portal.client.app.ui.module.parkoverview;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class ParkOverviewModule extends Composite {

	private static ParkOverviewModuleUiBinder uiBinder = GWT.create(ParkOverviewModuleUiBinder.class);

	interface ParkOverviewModuleUiBinder extends UiBinder<Widget, ParkOverviewModule> {
	}

	public ParkOverviewModule() {
		initWidget(uiBinder.createAndBindUi(this));

	}

}
