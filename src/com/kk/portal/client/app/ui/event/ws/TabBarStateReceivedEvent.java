package com.kk.portal.client.app.ui.event.ws;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.kk.portal.shared.domain.state.TabBarState;

public class TabBarStateReceivedEvent extends GwtEvent<TabBarStateReceivedEvent.TabBarStateReceivedEventHandler> {

	public interface TabBarStateReceivedEventHandler extends EventHandler {
		void onStateReceive(TabBarStateReceivedEvent event);
	}

	public static Type<TabBarStateReceivedEventHandler> TYPE = new Type<TabBarStateReceivedEvent.TabBarStateReceivedEventHandler>();

	private final TabBarState tabBarState;

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<TabBarStateReceivedEventHandler> getAssociatedType() {
		return TYPE;
	}

	public TabBarStateReceivedEvent(TabBarState tabBarState) {
		super();
		this.tabBarState = tabBarState;
	}

	@Override
	protected void dispatch(TabBarStateReceivedEventHandler handler) {
		handler.onStateReceive(this);
	}

	public TabBarState getState() {
		return tabBarState;
	}

}
