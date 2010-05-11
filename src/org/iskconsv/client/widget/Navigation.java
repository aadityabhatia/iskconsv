package org.iskconsv.client.widget;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;

public class Navigation extends FlowPanel implements ClickHandler, ValueChangeHandler<String>
{
	private static final String STYLE_PRIMARY = "navigationListItem";
	private static final String STYLE_SELECTED = "selected";
	
	Widget currentSelection;
	
	public Navigation()
	{
		this.setStyleName("navigationList");
		
	}
	
	public Anchor addAnchor(String text)
	{
		return addAnchor(text, "#");
	}
	
	public Anchor addAnchor(String label, String anchor)
	{
		Anchor hyperlink = new Anchor(label, anchor);
		this.add(hyperlink);

		hyperlink.addClickHandler(this);
		hyperlink.setStylePrimaryName(STYLE_PRIMARY);
		return hyperlink;
	}

	public void onClick(ClickEvent event)
	{
		Anchor source = (Anchor) event.getSource();
		updateSelection(source);
		source.setFocus(false);
	}

	private void updateSelection(Widget newSelection)
	{
		if(currentSelection == newSelection)
			return;

		if(currentSelection != null)
			currentSelection.removeStyleDependentName(STYLE_SELECTED);
		
		if(newSelection != null)
			newSelection.addStyleDependentName(STYLE_SELECTED);
		
		currentSelection = newSelection;
	}

	public void onValueChange(ValueChangeEvent<String> event)
	{
		String href = event.getValue();
		href = href.replaceAll(".*#", "");

		for (Widget widget : this.getChildren())
		{
			Anchor anchor = (Anchor) widget;
			if (anchor.getHref().replaceAll(".*#", "").equals(href))
			{
				updateSelection(anchor);
				return;
			}
		}
	}
}