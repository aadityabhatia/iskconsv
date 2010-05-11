package org.iskconsv.client.model.item;

import org.iskconsv.client.model.Item;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;

public class StaticPage extends Item
{
	@Override
	public Widget getWidget()
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append("I'm an HTML widget").append("<br>");

		buffer.append("Following are my children: ").append("<br>");
		buffer.append("<ul>");
		for (Item child : children)
		{
			buffer.append("<li>" + child.getLabel() + "</li>");
		}
		buffer.append("</ul>");
		
		return new HTML(buffer.toString());
	}

}
