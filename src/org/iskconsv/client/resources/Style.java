package org.iskconsv.client.resources;

import com.google.gwt.resources.client.CssResource;

public interface Style extends CssResource
{
	String menuItemHyperlink();

	String navigationList();

	String navigationBar();

	String contentWrapperPanel();

	String iframe();

	String buttonBar();

	String rootPanel();

	@ClassName("navigationBar-Top")
	String navigationBarTop();

	@ClassName("navigationListItem-selected")
	String navigationListItemSelected();

	String navigationListItem();
}