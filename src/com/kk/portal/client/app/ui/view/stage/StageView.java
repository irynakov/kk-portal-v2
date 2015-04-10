package com.kk.portal.client.app.ui.view.stage;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Singleton;
import com.kk.portal.client.app.ui.view.ApplicationView;

@Singleton
public class StageView extends Composite implements ApplicationView<StagePresenter> {

	private static StageViewUiBinder uiBinder = GWT.create(StageViewUiBinder.class);

	interface StageViewUiBinder extends UiBinder<Widget, StageView> {
	}

	private StagePresenter presenter;

	@UiField
	HTMLPanel headerWrapper;

	@UiField
	HTMLPanel contentWrapper;

	@UiField
	HTMLPanel navigationWrapper;

	@UiField
	HTMLPanel workspaceWrapper;

	public StageView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setPresenter(StagePresenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public void initLayout() {
		headerWrapper.add(presenter.getHeader());
	}
}
