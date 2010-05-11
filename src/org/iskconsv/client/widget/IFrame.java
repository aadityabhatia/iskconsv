package org.iskconsv.client.widget;

import com.google.gwt.user.client.ui.Frame;

public class IFrame extends Frame
{
	public static final IFrame instance = new IFrame();
	
	public IFrame()
	{
		this.setStylePrimaryName("iframe");
	}
	
	public IFrame(String url)
	{
		this();
		this.setUrl(url);
	}
}