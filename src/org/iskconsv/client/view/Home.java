package org.iskconsv.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;

public class Home extends Composite
{
	private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);

	interface MyUiBinder extends UiBinder<HTMLPanel, Home>
	{
	}

	interface Style extends CssResource
	{
	}

	@UiField
	Style style;

	public Home()
	{
		initWidget(uiBinder.createAndBindUi(this));
	}
}