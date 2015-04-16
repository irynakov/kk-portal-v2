package com.kk.portal.client.app.ui.view.stage;

import com.google.gwt.user.client.ui.InlineHTML;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.kk.portal.client.app.ui.event.ApplicationEventBus;
import com.kk.portal.client.app.ui.view.ApplicationPresenter;
import com.kk.portal.client.app.ui.view.ApplicationViewFactory;
import com.kk.portal.client.app.ui.view.header.HeaderView;
import com.kk.portal.client.app.ui.view.workspace.WorkspaceView;

@Singleton
public class StagePresenter extends ApplicationPresenter<StageView, StageService> {

	@Inject
	ApplicationEventBus appBus;

	@Inject
	Provider<ApplicationViewFactory> views;

	public HeaderView getHeader() {
		return views.get().view(HeaderView.class);
	}

	public Widget getNavigation() {
		return new InlineHTML("Will be implemented.");
	}

	public WorkspaceView getWorkspace() {
		return views.get().view(WorkspaceView.class);
	}

}
