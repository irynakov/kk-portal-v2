package com.kk.portal.client.app.ui.event.ws;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class TabBarStateRequestEvent extends GwtEvent<TabBarStateRequestEvent.TabBarStateRequestEventHandler> {

	public interface TabBarStateRequestEventHandler extends EventHandler {
		void onStateRequest(TabBarStateRequestEvent event);
	}

	public static Type<TabBarStateRequestEventHandler> TYPE = new Type<TabBarStateRequestEvent.TabBarStateRequestEventHandler>();

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<TabBarStateRequestEventHandler> getAssociatedType() {
		return TYPE;
	}

	public TabBarStateRequestEvent() {
		super();
	}

	@Override
	protected void dispatch(final TabBarStateRequestEventHandler handler) {
		handler.onStateRequest(this);
	}
}
