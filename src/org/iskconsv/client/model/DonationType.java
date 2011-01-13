package org.iskconsv.client.model;

import com.google.gwt.resources.client.ExternalTextResource;
import com.google.gwt.resources.client.ImageResource;

public class DonationType
{
	private String name;
	private ExternalTextResource info;
	private ImageResource image;
	private String destinationAccountOneTime;
	private String destinationAccountMonthly;
	
    public DonationType(String name, ExternalTextResource info, ImageResource image, String destinationAccountOneTime, String destinationAccountMonthly)
	{
		this.name = name;
		this.info = info;
		this.image = image;
		this.destinationAccountOneTime = destinationAccountOneTime;
		this.destinationAccountMonthly = destinationAccountMonthly;
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

	public String getDestinationAccountOneTime()
	{
		return destinationAccountOneTime;
	}
	public String getDestinationAccountMonthly()
	{
		return destinationAccountMonthly;
	}
}
