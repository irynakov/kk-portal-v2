package com.kk.portal.client.app.ui.event.ws;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class TabBarSelectionEvent extends GwtEvent<TabBarSelectionEvent.TabSelectionEventHandler> {

	public interface TabSelectionEventHandler extends EventHandler {
		void onSelection(TabBarSelectionEvent event);
	}

	public static Type<TabSelectionEventHandler> TYPE = new Type<TabBarSelectionEvent.TabSelectionEventHandler>();

	private final Integer selectedTabIndex;

	public TabBarSelectionEvent(Integer selectedTabIndex) {
		super();
		this.selectedTabIndex = selectedTabIndex;
	}

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<TabSelectionEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(TabSelectionEventHandler handler) {
		handler.onSelection(this);
	}

	public Integer getSelectedTabIndex() {
		return selectedTabIndex;
	}
}
