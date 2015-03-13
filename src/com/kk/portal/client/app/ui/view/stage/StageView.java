package com.kk.portal.client.app.ui.view.stage;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Singleton;
import com.kk.portal.client.app.ui.module.parkoverview.ParkOverviewModule;
import com.kk.portal.client.app.ui.view.ApplicationView;
import com.kk.portal.client.app.ui.widget.ChartBar;

@Singleton
public class StageView extends Composite implements ApplicationView<StagePresenter> {

	private static StageViewUiBinder uiBinder = GWT.create(StageViewUiBinder.class);

	interface StageViewUiBinder extends UiBinder<Widget, StageView> {
	}

	@UiField
	Button logout;

	@UiField
	Button update;

	@UiField
	Button reset;

	@UiField
	ChartBar chartBar1;
	@UiField
	ChartBar chartBar2;
	@UiField
	ChartBar chartBar3;
	@UiField
	ChartBar chartBar4;
	
	@UiField
	HTMLPanel tableWrapper;

	private StagePresenter presenter;

	public StageView() {
		initWidget(uiBinder.createAndBindUi(this));
		chartBar1.setBounds(0, 100, 0.5);
		chartBar1.setMarker(22);
		chartBar1.setProgressColor("#6dd709");
		chartBar1.setDataFormatter(NumberFormat.getFormat("#'%'"));

		chartBar2.setBounds(-15, 7);
		chartBar2.setMarker(4);
		chartBar2.setProgressColor("#FF55AA");
		chartBar2.setDataFormatter(NumberFormat.getFormat("#' mWa'"));

		chartBar3.setBounds(0, 25);
		chartBar3.setMarker(14);
		chartBar3.setProgressColor("#AAAAFF");
		chartBar3.setDataFormatter(NumberFormat.getFormat("#' mWa'"));

		chartBar4.setBounds(0, 1);
		chartBar4.setMarker(0.7);
		chartBar4.setProgressColor("#FFFF7F");
		chartBar4.setDataFormatter(NumberFormat.getFormat("#.#' mWa'"));
		
		tableWrapper.add(new ParkOverviewModule());
	}

	@UiHandler("logout")
	void logout(ClickEvent e) {
		presenter.logout();
	}

	@UiHandler("update")
	void update(ClickEvent e) {
		chartBar1.setValue(chartBar1.getValue() + 10);
		chartBar2.setValue(chartBar2.getValue() + 1);
		chartBar3.setValue(chartBar3.getValue() + 1);
		chartBar4.setValue(chartBar4.getValue() + .1);
	}

	@UiHandler("reset")
	void reset(ClickEvent e) {
		chartBar1.setValue(chartBar1.getValue() - 10);
		chartBar2.setValue(chartBar2.getValue() - 1);
		chartBar3.setValue(chartBar3.getValue() - 1);
		chartBar4.setValue(chartBar4.getValue() - .1);
	}

	@Override
	public void setPresenter(StagePresenter presenter) {
		this.presenter = presenter;
	}
}
