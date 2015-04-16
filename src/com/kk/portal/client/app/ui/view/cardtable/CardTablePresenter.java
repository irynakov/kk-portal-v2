package com.kk.portal.client.app.ui.view.cardtable;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.kk.portal.client.app.ui.event.WorkspaceEventBus;
import com.kk.portal.client.app.ui.event.ws.CardTableStateReceivedEvent;
import com.kk.portal.client.app.ui.event.ws.TabBarSelectionEvent;
import com.kk.portal.client.app.ui.event.ws.CardTableStateReceivedEvent.CardTableStateReceivedEventHandler;
import com.kk.portal.client.app.ui.event.ws.TabBarSelectionEvent.TabSelectionEventHandler;
import com.kk.portal.client.app.ui.view.ApplicationPresenter;

@Singleton
public class CardTablePresenter extends ApplicationPresenter<CardTableView, CardTableService> implements TabSelectionEventHandler, CardTableStateReceivedEventHandler {

	@Inject
	WorkspaceEventBus wsBus;

	@Override
	protected void initEventSubscriptions() {
		
		wsBus.addTabSelectionHandler(this);
		wsBus.addCardTableStateReceivedHandler(this);
	}

	@Override
	public void onSelection(TabBarSelectionEvent event) {
		view.clean();
		wsBus.notifyCardTableStateRequest(event.getSelectedTabIndex());
	}

	@Override
	public void onStateReceive(CardTableStateReceivedEvent event) {
		view.deal(event.getState().getText());
		
	}

}
