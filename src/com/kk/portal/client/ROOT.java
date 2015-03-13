package com.kk.portal.client;

import org.fusesource.restygwt.client.Defaults;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.kk.portal.client.app.ui.ApplicationController;
import com.kk.portal.client.inject.ApplicationInjector;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class ROOT implements EntryPoint {

	private final ApplicationInjector applicationInjector = GWT.create(ApplicationInjector.class);

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		
		Defaults.setServiceRoot(GWT.getHostPageBaseURL());

		ApplicationController applicationController = applicationInjector.createApplicationController();

		applicationController.initApplication(RootLayoutPanel.get());
		applicationController.startApplication();
	}
}
