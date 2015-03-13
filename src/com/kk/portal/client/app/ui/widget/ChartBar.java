package com.kk.portal.client.app.ui.widget;

import com.google.gwt.dom.client.DivElement;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.user.client.ui.Widget;
import com.kk.portal.client.app.ui.widget.chartbar.IChartBar;

public class ChartBar extends Widget implements IChartBar {

	private final com.kk.portal.client.app.ui.widget.chartbar.ChartBar widget;

	@UiConstructor
	public ChartBar() {
		widget = new com.kk.portal.client.app.ui.widget.chartbar.ChartBar();

		setElement(DivElement.as(widget.getElement()));
	}

	@Override
	public void setBounds(final double min, final double max) {
		widget.setBounds(min, max);
	}

	@Override
	public void setBounds(final double min, final double max, final double capacity) {
		widget.setBounds(min, max, capacity);
	}

	@Override
	public void setMarker(final double marker) {
		widget.setMarker(marker);
	}

	@Override
	public void clearMarker() {
		widget.clearMarker();
	}

	@Override
	public void setValue(final double value) {
		widget.setValue(value);
	}

	@Override
	public double getValue() {
		return widget.getValue();
	}

	@Override
	public void setProgressColor(final String colorHex) {
		widget.setProgressColor(colorHex);
	}

	@Override
	public void setDataFormatter(final NumberFormat formatter) {
		widget.setDataFormatter(formatter);
	}
}
