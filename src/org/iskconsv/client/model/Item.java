package org.iskconsv.client.model;

import java.util.Collection;

import com.google.gwt.user.client.ui.Widget;

public abstract class Item
{
	protected String label;
	protected Collection<Item> children;

	public Item()
	{
	}
	
	public Item(String label)
	{
		this.label = label;
	}
	
	public void setLabel(String label)
	{
		this.label = label;
	}

	public String getLabel()
	{
		return label;
	}
	
	public abstract Widget getWidget();

	public void addChild(Item child)
	{
		children.add(child);
	}
	
	public void addChildren(Collection<Item> children)
	{
		this.children.addAll(children);
	}
	
	public Collection<Item> getChildren()
	{
		return children;
	}
}