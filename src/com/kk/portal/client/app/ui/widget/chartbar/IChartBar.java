package com.kk.portal.client.app.ui.widget.chartbar;

import com.google.gwt.i18n.client.NumberFormat;

public interface IChartBar {

	void setBounds(double min, double max);

	void setBounds(double min, double max, double capacity);

	void setMarker(double marker);

	void clearMarker();

	void setValue(double value);

	double getValue();

	void setProgressColor(String colorHex);

	void setDataFormatter(NumberFormat formatter);

}