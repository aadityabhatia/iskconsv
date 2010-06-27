package org.iskconsv.client.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ExternalTextResource;
import com.google.gwt.resources.client.ImageResource;

public interface Resources extends ClientBundle
{
	public static final Resources INSTANCE = GWT.create(Resources.class);
	Style style();

	@Source("welcomeMessage.html")
	ExternalTextResource welcomeMessage();
	
	@Source("logo.png")
	ImageResource logo();
}