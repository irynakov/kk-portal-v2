package com.kk.portal.client.app.ui.widget.chartbar;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.UIObject;

public class ChartBar extends UIObject implements IChartBar {

	private static ChartBarUiBinder uiBinder = GWT.create(ChartBarUiBinder.class);

	interface ChartBarUiBinder extends UiBinder<Element, ChartBar> {
	}

	@UiField
	DivElement labelDiv;
	@UiField
	DivElement progressDiv;
	@UiField
	DivElement markerDiv;

	private double min, max, value, capacity;

	private double size;

	private NumberFormat formatter = NumberFormat.getFormat("#");

	public ChartBar() {

		setElement(uiBinder.createAndBindUi(this));

		markerDiv.getStyle().setDisplay(Display.NONE);

		setBounds(0, 1);
	}

	@Override
	public void setBounds(final double min, final double max) {

		setBounds(min, max, 1);
	}

	@Override
	public void setBounds(final double min, final double max, final double capacity) {

		if (0 < capacity && capacity <= 1) {

			this.capacity = capacity;

		} else {
			throw new IllegalArgumentException("Value of capacity factor must be in range (0, 1].");
		}

		if (min < max) {

			this.min = min;
			this.max = max * capacity;

			this.size = Math.abs(min - max);

		} else {
			throw new IllegalArgumentException("Value of [min] can't be grater then value of [max].");
		}

		setValue(min);
	}

	@Override
	public void setMarker(final double marker) {

		if (min <= marker && marker <= max) {

			markerDiv.getStyle().clearDisplay();
			markerDiv.getStyle().setWidth(calcProgress(marker), Unit.PCT);
		} else {
			throw new IllegalArgumentException("Value of marker must be in range [min: " + min + ", (max * capacity): " + max + "].");
		}
	}

	@Override
	public void clearMarker() {
		markerDiv.getStyle().setDisplay(Display.NONE);
	}

	@Override
	public void setValue(final double value) {

		if (min <= value && value <= max) {

			this.value = value;

			updateProgress();
			updateLabel();
		}
	}

	@Override
	public double getValue() {
		return value;
	}

	@Override
	public void setProgressColor(final String colorHex) {
		progressDiv.getStyle().setBackgroundColor(colorHex);
	}

	public void setDataFormatter(final NumberFormat formatter) {
		this.formatter = formatter;
		updateLabel();
	}

	private void updateProgress() {
		progressDiv.getStyle().setWidth(calcProgress(value), Unit.PCT);
	}

	private int calcProgress(final double value) {
		return (int) (Math.round((Math.abs(min - value) / size) * 100) / capacity);
	}

	private void updateLabel() {
		labelDiv.setInnerText(formatter == null ? String.valueOf(value) : formatter.format(value));
	}
}
