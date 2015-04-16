package com.kk.portal.client.app.ui.view.header;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.kk.portal.client.app.ui.event.ApplicationEventBus;
import com.kk.portal.client.app.ui.view.ApplicationPresenter;

@Singleton
public class HeaderPresenter extends ApplicationPresenter<HeaderView, HeaderService> {

	@Inject
	ApplicationEventBus appBus;

	public void logout() {
		appBus.notifyLogout();
	}

}