package org.iskconsv.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;

public class Contact extends Composite
{
	private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);
	
	interface MyUiBinder extends UiBinder<HTMLPanel, Contact>
	{
	}
	
	public Contact()
	{
		initWidget(uiBinder.createAndBindUi(this));
	}
}