package org.iskconsv.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockLayoutPanel;

public class Home extends Composite
{
	private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);

	interface MyUiBinder extends UiBinder<DockLayoutPanel, Home>
	{
	}

	public Home()
	{
		initWidget(uiBinder.createAndBindUi(this));
	}
}