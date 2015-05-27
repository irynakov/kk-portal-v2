package com.kk.portal.client.app.ui.view;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.kk.portal.client.app.ui.ViewFactory;
import com.kk.portal.client.app.ui.view.cardtable.CardTablePresenter;
import com.kk.portal.client.app.ui.view.cardtable.CardTableView;
import com.kk.portal.client.app.ui.view.decksholder.DecksHolderPresenter;
import com.kk.portal.client.app.ui.view.decksholder.DecksHolderView;
import com.kk.portal.client.app.ui.view.header.HeaderPresenter;
import com.kk.portal.client.app.ui.view.header.HeaderView;
import com.kk.portal.client.app.ui.view.login.LoginPresenter;
import com.kk.portal.client.app.ui.view.login.LoginView;
import com.kk.portal.client.app.ui.view.playroom.PlayRoomPresenter;
import com.kk.portal.client.app.ui.view.playroom.PlayRoomView;
import com.kk.portal.client.app.ui.view.stage.StagePresenter;
import com.kk.portal.client.app.ui.view.stage.StageView;

@Singleton
public class ApplicationViewFactory extends ViewFactory {

	@Inject
	LoginPresenter login;

	@Inject
	StagePresenter stage;

	@Inject
	HeaderPresenter header;

	@Inject
	PlayRoomPresenter workspace;

	@Inject
	DecksHolderPresenter tabBar;

	@Inject
	CardTablePresenter cardTable;

	@SuppressWarnings("unchecked")
	public <T extends ApplicationView<?> & IsWidget> T view(Class<T> viewType) {

		if (StageView.class.equals(viewType)) {
			return (T) build(stage).view;
		} else if (LoginView.class.equals(viewType)) {
			return (T) build(login).view;
		} else if (HeaderView.class.equals(viewType)) {
			return (T) build(header).view;
		} else if (PlayRoomView.class.equals(viewType)) {
			return (T) build(workspace).view;
		} else if (DecksHolderView.class.equals(viewType)) {
			return (T) build(tabBar).view;
		} else if (CardTableView.class.equals(viewType)) {
			return (T) build(cardTable).view;
		}

		throw new IllegalArgumentException("Add support of " + viewType.getName() + " in " + ApplicationViewFactory.class.getName() + "#view(..).");
	};
}
