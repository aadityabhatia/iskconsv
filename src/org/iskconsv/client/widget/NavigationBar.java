package org.iskconsv.client.widget;

import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HTML;

public class NavigationBar extends Navigation
{
	private static final String SEPARATOR = " | ";

	public Anchor addAnchor(String text, String anchor)
	{
		if (getElement().hasChildNodes())
			add(new HTML(SEPARATOR));

		Anchor hyperlink = new Anchor(text, anchor);
		add(hyperlink);
		
		return hyperlink;
	}

	public void addHTML(String html)
	{
		if (getElement().hasChildNodes())
			add(new HTML(SEPARATOR));

		add(new HTML(html));
	}
}