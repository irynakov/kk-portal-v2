package com.kk.portal.client.app.ui.view.stage;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Singleton;
import com.kk.portal.client.app.ui.view.ApplicationView;
import com.kk.portal.client.app.ui.view.workspace.WorkspaceView;

@Singleton
public class StageView extends Composite implements ApplicationView<StagePresenter> {

	interface StageViewUiBinder extends UiBinder<Widget, StageView> {}

	private static StageViewUiBinder uiBinder = GWT.create(StageViewUiBinder.class);

	@UiField
	HTMLPanel headerWrapper;

	@UiField
	HTMLPanel navigationWrapper;

	@UiField(provided=true)
	WorkspaceView workspaceWrapper;

	private StagePresenter presenter;

	@Override
	public void setPresenter(StagePresenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public void initLayout() {
		workspaceWrapper = presenter.getWorkspace();

		initWidget(uiBinder.createAndBindUi(this));

		headerWrapper.add(presenter.getHeader());
		navigationWrapper.add(presenter.getNavigation());
	}

}
