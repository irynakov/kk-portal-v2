package com.kk.portal.client.app.ui.module;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.inject.Inject;
import com.kk.portal.client.app.ui.ViewFactory;
import com.kk.portal.client.app.ui.module.parkoverview.EmptyModulePresenter;
import com.kk.portal.client.app.ui.module.parkoverview.EmptyModuleView;
import com.kk.portal.client.app.ui.view.ApplicationView;
import com.kk.portal.client.app.ui.view.ApplicationViewFactory;

public class ModuleViewFactory extends ViewFactory {

	@Inject
	EmptyModulePresenter empty;
	
	@Override
	@SuppressWarnings("unchecked")
	public <T extends ApplicationView<?> & IsWidget> T view(Class<T> viewType) {

		if (EmptyModuleView.class.equals(viewType)) {
			return (T) build(empty).view();
		}

		throw new IllegalArgumentException("Add support of " + viewType.getName() + " in " + ApplicationViewFactory.class.getName() + "#view(..).");
	}

}
