package com.kk.portal.client.app.ui.view.workspace;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.kk.portal.client.app.ui.event.ApplicationEventBus;
import com.kk.portal.client.app.ui.event.WorkspaceEventBus;
import com.kk.portal.client.app.ui.view.ApplicationPresenter;
import com.kk.portal.client.app.ui.view.ApplicationViewFactory;
import com.kk.portal.client.app.ui.view.cardtable.CardTableView;
import com.kk.portal.client.app.ui.view.tabbar.TabBarView;

@Singleton
public class WorkspacePresenter extends ApplicationPresenter<WorkspaceView, WorkspaceService> {

	@Inject
	ApplicationEventBus apBus;

	@Inject
	WorkspaceEventBus wsBus;

	@Inject
	Provider<ApplicationViewFactory> views;

	public TabBarView getTabBar() {
		return views.get().view(TabBarView.class);
	}

	public CardTableView getCardTable() {
		return views.get().view(CardTableView.class);
	}

	public void requestTabBarState() {
		wsBus.notifyTabBarStateRequest();
	}

}
