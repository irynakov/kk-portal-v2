package com.kk.portal.client.app.ui.view.stage;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Singleton;
import com.kk.portal.client.app.ui.module.parkoverview.ParkOverviewModule;
import com.kk.portal.client.app.ui.view.ApplicationView;

@Singleton
public class StageView extends Composite implements ApplicationView<StagePresenter> {

	private static StageViewUiBinder uiBinder = GWT.create(StageViewUiBinder.class);

	interface StageViewUiBinder extends UiBinder<Widget, StageView> {
	}

	@UiField
	Button logout;

	@UiField
	HTMLPanel tableWrapper;

	private StagePresenter presenter;

	public StageView() {
		initWidget(uiBinder.createAndBindUi(this));

		tableWrapper.add(new ParkOverviewModule());
	}

	@UiHandler("logout")
	void logout(ClickEvent e) {
		presenter.logout();
	}

	@Override
	public void setPresenter(StagePresenter presenter) {
		this.presenter = presenter;
	}
}
