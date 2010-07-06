package org.iskconsv.client.model;

import com.google.gwt.resources.client.ExternalTextResource;
import com.google.gwt.resources.client.ImageResource;

public class DonationType
{
	private String name;
	private ExternalTextResource info;
	private ImageResource image;
	private String destinationAccount;
	
	public DonationType(String name, ExternalTextResource info, ImageResource image, String destinationAccount)
	{
		this.name = name;
		this.info = info;
		this.image = image;
		this.destinationAccount = destinationAccount;
	}

	public String getName()
	{
		return name;
	}

	public ExternalTextResource getInfo()
	{
		return info;
	}

	public ImageResource getImage()
	{
		return image;
	}

	public String getDestinationAccount()
	{
		return destinationAccount;
	}
}