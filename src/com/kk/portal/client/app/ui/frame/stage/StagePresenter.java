package com.kk.portal.client.app.ui.frame.stage;

import com.google.gwt.user.client.ui.InlineHTML;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.kk.portal.client.app.ui.event.ApplicationEventBus;
import com.kk.portal.client.app.ui.frame.FramePresenter;
import com.kk.portal.client.app.ui.frame.FrameViewFactory;
import com.kk.portal.client.app.ui.frame.header.HeaderView;
import com.kk.portal.client.app.ui.frame.playroom.PlayRoomView;

@Singleton
public class StagePresenter extends FramePresenter<StageView, StageService> {

	@Inject
	ApplicationEventBus appBus;

	@Inject
	Provider<FrameViewFactory> views;

	public HeaderView getHeader() {
		return views.get().view(HeaderView.class);
	}

	public Widget getNavigation() {
		return new InlineHTML("Will be implemented.");
	}

	public PlayRoomView getWorkspace() {
		return views.get().view(PlayRoomView.class);
	}

}
