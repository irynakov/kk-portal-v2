package com.kk.portal.client.app.ui.view.stage;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.kk.portal.client.app.ui.ApplicationEventBus;
import com.kk.portal.client.app.ui.view.ApplicationPresenter;

@Singleton
public class StagePresenter extends ApplicationPresenter<StageView, StageService> {

	private final ApplicationEventBus appBus;

	@Inject
	public StagePresenter(final StageView view, final ApplicationEventBus appBus) {
		super(view);

		this.appBus = appBus;
	}
	
	

	public void logout() {
		appBus.notifyLogout();
	}
	
}
