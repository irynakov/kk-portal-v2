package com.kk.portal.client.app.ui.view.workspace;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.kk.portal.client.app.ui.view.ApplicationView;
import com.kk.portal.client.app.ui.view.cardtable.CardTableView;
import com.kk.portal.client.app.ui.view.tabbar.TabBarView;

public class WorkspaceView extends Composite implements ApplicationView<WorkspacePresenter> {

	interface WorkspaceViewUiBinder extends UiBinder<Widget, WorkspaceView> {}

	private static final WorkspaceViewUiBinder uiBinder = GWT.create(WorkspaceViewUiBinder.class);

	@UiField(provided = true)
	TabBarView tabBar;

	@UiField(provided = true)
	CardTableView cardTable;

	private WorkspacePresenter presenter;

	@Override
	public void setPresenter(WorkspacePresenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public void initLayout() {

		tabBar = presenter.getTabBar();
		cardTable = presenter.getCardTable();

		initWidget(uiBinder.createAndBindUi(this));
		
		presenter.requestTabBarState();
	}
}
