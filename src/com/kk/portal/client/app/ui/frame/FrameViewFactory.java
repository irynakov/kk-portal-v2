package com.kk.portal.client.app.ui.frame;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.kk.portal.client.app.ui.ApplicationView;
import com.kk.portal.client.app.ui.ApplicationViewFactory;
import com.kk.portal.client.app.ui.frame.cardtable.CardTablePresenter;
import com.kk.portal.client.app.ui.frame.cardtable.CardTableView;
import com.kk.portal.client.app.ui.frame.decksholder.DecksHolderPresenter;
import com.kk.portal.client.app.ui.frame.decksholder.DecksHolderView;
import com.kk.portal.client.app.ui.frame.header.HeaderPresenter;
import com.kk.portal.client.app.ui.frame.header.HeaderView;
import com.kk.portal.client.app.ui.frame.login.LoginPresenter;
import com.kk.portal.client.app.ui.frame.login.LoginView;
import com.kk.portal.client.app.ui.frame.playroom.PlayRoomPresenter;
import com.kk.portal.client.app.ui.frame.playroom.PlayRoomView;
import com.kk.portal.client.app.ui.frame.stage.StagePresenter;
import com.kk.portal.client.app.ui.frame.stage.StageView;

@Singleton
public class FrameViewFactory extends ApplicationViewFactory {

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
			return (T) build(stage).view();
		} else if (LoginView.class.equals(viewType)) {
			return (T) build(login).view();
		} else if (HeaderView.class.equals(viewType)) {
			return (T) build(header).view();
		} else if (PlayRoomView.class.equals(viewType)) {
			return (T) build(workspace).view();
		} else if (DecksHolderView.class.equals(viewType)) {
			return (T) build(tabBar).view();
		} else if (CardTableView.class.equals(viewType)) {
			return (T) build(cardTable).view();
		}

		throw new IllegalArgumentException("Add support of " + viewType.getName() + " in " + FrameViewFactory.class.getName() + "#view(..).");
	};
}
