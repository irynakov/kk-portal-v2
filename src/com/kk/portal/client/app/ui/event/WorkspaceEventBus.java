package com.kk.portal.client.app.ui.event;

import java.util.logging.Logger;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.inject.Singleton;
import com.kk.portal.client.app.ui.event.ws.CardTableStateReceivedEvent;
import com.kk.portal.client.app.ui.event.ws.CardTableStateReceivedEvent.CardTableStateReceivedEventHandler;
import com.kk.portal.client.app.ui.event.ws.CardTableStateRequestEvent;
import com.kk.portal.client.app.ui.event.ws.CardTableStateRequestEvent.CardTableStateRequestEventHandler;
import com.kk.portal.client.app.ui.event.ws.TabBarSelectionEvent;
import com.kk.portal.client.app.ui.event.ws.TabBarSelectionEvent.TabSelectionEventHandler;
import com.kk.portal.client.app.ui.event.ws.TabBarStateReceivedEvent;
import com.kk.portal.client.app.ui.event.ws.TabBarStateReceivedEvent.TabBarStateReceivedEventHandler;
import com.kk.portal.client.app.ui.event.ws.TabBarStateRequestEvent;
import com.kk.portal.client.app.ui.event.ws.TabBarStateRequestEvent.TabBarStateRequestEventHandler;
import com.kk.portal.shared.domain.state.CardTableState;
import com.kk.portal.shared.domain.state.TabBarState;

@Singleton
public class WorkspaceEventBus extends SimpleEventBus {

	private static final Logger LOG = Logger.getLogger(WorkspaceEventBus.class.getName());

	public WorkspaceEventBus() {
		super();
		LOG.info(WorkspaceEventBus.class.getName() + " for application created.");
	}

	public HandlerRegistration addTabSelectionHandler(final TabSelectionEventHandler handler) {
		return addHandler(TabBarSelectionEvent.TYPE, handler);
	}

	public void notifyTabSelection(Integer selectedTabIndex) {
		fireEvent(new TabBarSelectionEvent(selectedTabIndex));
	}

	public HandlerRegistration addTabBarStateRequestHandler(final TabBarStateRequestEventHandler handler) {
		LOG.info("Add handler: [" + handler.getClass().getName() + "]");
		return addHandler(TabBarStateRequestEvent.TYPE, handler);
	}

	public void notifyTabBarStateRequest() {
		fireEvent(new TabBarStateRequestEvent());
	}

	public HandlerRegistration addTabBarStateReceivedHandler(final TabBarStateReceivedEventHandler handler) {
		LOG.info("Add handler: [" + handler.getClass().getName() + "]");
		return addHandler(TabBarStateReceivedEvent.TYPE, handler);
	}

	public void notifyTabBarStateReceived(TabBarState tabBarState) {
		fireEvent(new TabBarStateReceivedEvent(tabBarState));
	}

	public HandlerRegistration addCardTableStateRequestHandler(final CardTableStateRequestEventHandler handler) {
		LOG.info("Add handler: [" + handler.getClass().getName() + "]");
		return addHandler(CardTableStateRequestEvent.TYPE, handler);
	}

	public void notifyCardTableStateRequest(int stateIndex) {
		fireEvent(new CardTableStateRequestEvent(stateIndex));
	}

	public HandlerRegistration addCardTableStateReceivedHandler(final CardTableStateReceivedEventHandler handler) {
		LOG.info("Add handler: [" + handler.getClass().getName() + "]");
		return addHandler(CardTableStateReceivedEvent.TYPE, handler);
	}

	public void notifyCardTableStateReceived(CardTableState cardTableState) {
		fireEvent(new CardTableStateReceivedEvent(cardTableState));
	}
}
