package com.kk.portal.client.app.ui.view.tabbar;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.kk.portal.client.app.ui.event.WorkspaceEventBus;
import com.kk.portal.client.app.ui.event.ws.TabBarStateReceivedEvent;
import com.kk.portal.client.app.ui.event.ws.TabBarStateReceivedEvent.TabBarStateReceivedEventHandler;
import com.kk.portal.client.app.ui.view.ApplicationPresenter;

@Singleton
public class TabBarPresenter extends ApplicationPresenter<TabBarView, TabBarService> implements TabBarStateReceivedEventHandler {

	@Inject
	WorkspaceEventBus wsBus;

	@Override
	protected void initEventSubscriptions() {
		
		wsBus.addTabBarStateReceivedHandler(this);
	}

	public void handleTabSelection(Integer selectedItem) {
		wsBus.notifyTabSelection(selectedItem);
	}

	@Override
	public void onStateReceive(TabBarStateReceivedEvent event) {
		view.addTabs(event.getState().getTabs());
		view.selectTab(event.getState().getSelectedIndex());
	}
}
