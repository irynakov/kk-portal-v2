package com.kk.portal.client.app.ui.view.playroom;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.kk.portal.client.app.ui.event.ApplicationEventBus;
import com.kk.portal.client.app.ui.event.WorkspaceEventBus;
import com.kk.portal.client.app.ui.view.ApplicationPresenter;
import com.kk.portal.client.app.ui.view.ApplicationViewFactory;
import com.kk.portal.client.app.ui.view.cardtable.CardTableView;
import com.kk.portal.client.app.ui.view.decksholder.DecksHolderView;

@Singleton
public class PlayRoomPresenter extends ApplicationPresenter<PlayRoomView, PlayRoomService> {

	@Inject
	ApplicationEventBus apBus;

	@Inject
	WorkspaceEventBus wsBus;

	@Inject
	Provider<ApplicationViewFactory> views;

	public DecksHolderView getDeckManager() {
		return views.get().view(DecksHolderView.class);
	}

	public CardTableView getCardTable() {
		return views.get().view(CardTableView.class);
	}

	public void requestDeckManagerState() {
		wsBus.notifyDeckManagerStateRequest();
	}

}
