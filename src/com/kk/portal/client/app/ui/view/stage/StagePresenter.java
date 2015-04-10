package com.kk.portal.client.app.ui.view.stage;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.kk.portal.client.app.ui.ApplicationEventBus;
import com.kk.portal.client.app.ui.view.ApplicationPresenter;
import com.kk.portal.client.app.ui.view.ViewProvider;
import com.kk.portal.client.app.ui.view.header.HeaderView;

@Singleton
public class StagePresenter extends ApplicationPresenter<StageView, StageService> {

	@Inject
	ApplicationEventBus appBus;

	@Inject
	Provider<ViewProvider> views;

	@Override
	protected void initEventSubscriptions() {

	}

	public HeaderView getHeader() {
		return views.get().view(HeaderView.class);
	}
}
