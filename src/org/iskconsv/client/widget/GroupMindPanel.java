package org.iskconsv.client.widget;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.LazyPanel;
import com.google.gwt.user.client.ui.Widget;

public class GroupMindPanel extends LazyPanel
{
	public GroupMindPanel()
	{
	}

	@Override
	protected Widget createWidget()
	{
		this.add(new IFrame("http://www.gmind.org/pftf/?da=stream"));
		this.add(new HTML(""));
		return null;
	}
}