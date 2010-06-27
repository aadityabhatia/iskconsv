package org.iskconsv.client.widget;

import com.google.gwt.user.client.ui.Frame;

public class IFrame
{
	private static final Frame instance = new Frame();
	
	public static Frame getFrame(String url)
	{
		instance.setUrl(url);
		return instance;
	}
	
	public static void setStylePrimaryName(String name)
	{
		instance.setStylePrimaryName(name);
	}
}