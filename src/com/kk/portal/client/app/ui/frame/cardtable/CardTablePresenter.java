package com.kk.portal.client.app.ui.frame.cardtable;

import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.kk.portal.client.app.ui.event.WorkspaceEventBus;
import com.kk.portal.client.app.ui.event.ws.CardTableStateReceivedEvent;
import com.kk.portal.client.app.ui.event.ws.CardTableStateReceivedEvent.CardTableStateReceivedEventHandler;
import com.kk.portal.client.app.ui.event.ws.DeckSelectionEvent;
import com.kk.portal.client.app.ui.event.ws.DeckSelectionEvent.DeckSelectionEventHandler;
import com.kk.portal.client.app.ui.frame.FramePresenter;
import com.kk.portal.client.app.ui.module.ModuleViewFactory;
import com.kk.portal.client.app.ui.module.test_dnd.DNDTestModuleView;
import com.kk.portal.client.app.ui.widgets.ModuleCard;

@Singleton
public class CardTablePresenter extends FramePresenter<CardTableView, CardTableService> implements DeckSelectionEventHandler, CardTableStateReceivedEventHandler {

	@Inject
	WorkspaceEventBus wsBus;
	
	@Inject
	ModuleViewFactory modules;

	@Override
	protected void initEventSubscriptions() {
		
		wsBus.addTabSelectionHandler(this);
		wsBus.addCardTableStateReceivedHandler(this);
	}

	@Override
	public void onSelection(DeckSelectionEvent event) {
		view.clear();
		wsBus.notifyCardTableStateRequest(event.getSelectedTabIndex());
	}

	@Override
	public void onStateReceive(CardTableStateReceivedEvent event) {
		view.deal(event.getState().getText());
	}

	public Widget getCard(String text) {
		return new ModuleCard(modules.view(DNDTestModuleView.class));
	}

}
