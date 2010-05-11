package org.iskconsv.client.model;

import com.google.gwt.user.client.ui.Widget;

public class Menu extends Item
{
	private static Menu mainMenu;
	
	public Menu(String label)
	{
		super(label);
	}

	public static Menu getMainMenu()
	{
		if(mainMenu == null)
			mainMenu = new Menu("TopMenu");
		return mainMenu;
	}
	
	@Override
	public Widget getWidget()
	{
		return null;
	}
}