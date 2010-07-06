package org.iskconsv.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.MouseWheelEvent;
import com.google.gwt.event.dom.client.MouseWheelHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.Image;

public class LocationView extends Composite
{
	private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);

	interface MyUiBinder extends UiBinder<DockLayoutPanel, LocationView>
	{
	}

	@UiField
	Image mapImage;

	int mapZoom = 15;

	public LocationView()
	{
		initWidget(uiBinder.createAndBindUi(this));

		mapImage.setUrl("http://maps.google.com/maps/api/staticmap?zoom=" + mapZoom + "&size=640x640&center=951+S+Bascom+Avenue+,+San%20Jose,+CA+95128&maptype=roadmap&markers=icon:http://chart.apis.google.com/chart%3Fchst%3Dd_map_pin_icon%26chld%3Dhome%257CFF7F00|37.3090981,-121.9318911&sensor=false");

		mapImage.addMouseWheelHandler(new MouseWheelHandler()
		{
			@Override
			public void onMouseWheel(MouseWheelEvent event)
			{
				if (event.getDeltaY() > 0 && mapZoom > 0)
					mapZoom--;
				else
					mapZoom++;

				showMap();
			}
		});
	}

	/**
	 * Reset map after 1000 ms to ensure the correct aspect ratio and dimensions
	 */
	@Override
	protected void onLoad()
	{
		(new Timer()
		{
			@Override
			public void run()
			{
				showMap();
			}
		}).schedule(1000);
		super.onLoad();
	}

	private void showMap()
	{
		int width = mapImage.getWidth();
		int height = mapImage.getHeight();

		if (height == 0)
			height = 640;

		if (width == 0)
			width = 640;
		if (width > 640)
		{
			height = height * 640 / width;
			width = 640;
		}
		if (height > 640)
		{
			width = width * 640 / height;
			width = 640;
		}

		String Url = "http://maps.google.com/maps/api/staticmap?zoom="
				+ mapZoom
				+ "&size="
				+ width
				+ "x"
				+ height
				+ "&center=951+S+Bascom+Avenue+,+San%20Jose,+CA+95128&maptype=roadmap&markers=icon:http://chart.apis.google.com/chart%3Fchst%3Dd_map_pin_icon%26chld%3Dhome%257CFF7F00|951+S+Bascom+Avenue+,+San%20Jose,+CA+95128&sensor=false";

		// TODO: Set map marker to
		// http://chart.apis.google.com/chart?chst=d_map_spin&chld=2.0|0|FF7900|17|b|Temple

		mapImage.setUrl(Url);
	}
}