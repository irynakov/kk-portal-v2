package com.kk.portal.client.app.ui.view.tabbar;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.kk.portal.client.app.comm.WebServiceCommunicationInterface;
import com.kk.portal.client.app.ui.event.WorkspaceEventBus;
import com.kk.portal.client.app.ui.event.ws.TabBarStateRequestEvent;
import com.kk.portal.client.app.ui.event.ws.TabBarStateRequestEvent.TabBarStateRequestEventHandler;
import com.kk.portal.client.app.ui.view.ApplicationService;
import com.kk.portal.shared.domain.comm.resp.UIStateResp;
import com.kk.portal.shared.domain.state.TabBarState;

@Singleton
public class TabBarService implements ApplicationService, TabBarStateRequestEventHandler {

	private static final Logger LOG = Logger.getLogger(TabBarService.class.getName());

	@Inject
	WebServiceCommunicationInterface comm;

	@Inject
	WorkspaceEventBus wsBus;

	@Override
	public void initEventSubscriptions() {
		wsBus.addTabBarStateRequestHandler(this);
	}

	@Override
	public void onStateRequest(TabBarStateRequestEvent event) {
		LOG.info("Requesting tab bar state.");

		comm.getTabBarState(new MethodCallback<UIStateResp<TabBarState>>() {

			@Override
			public void onSuccess(Method method, UIStateResp<TabBarState> response) {
				wsBus.notifyTabBarStateReceived(response.getState());
			}

			@Override
			public void onFailure(Method method, Throwable exception) {
				LOG.log(Level.SEVERE, method.getResponse().getHeadersAsString(), exception);
			}
		});
	}

}
