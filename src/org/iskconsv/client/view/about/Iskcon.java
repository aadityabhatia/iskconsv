package org.iskconsv.client.view.about;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;

public class Iskcon extends Composite
{
	private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);

	interface MyUiBinder extends UiBinder<HTMLPanel, Iskcon>
	{
	}

	interface Style extends CssResource
	{
	}

	@UiField
	Style style;

	public Iskcon()
	{
		initWidget(uiBinder.createAndBindUi(this));
	}
}