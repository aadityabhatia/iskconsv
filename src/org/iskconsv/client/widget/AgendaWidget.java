package org.iskconsv.client.widget;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;

public class AgendaWidget extends FlowPanel
{
	HTML html = new HTML("agenda");

	public static final String calendarURL = "http://www.google.com/calendar/feeds/programforthefuture.com_ee5r0bm15qmbroe4alo76v5gas@group.calendar.google.com/public/full";

	private static final String GDATA_API_KEY = "ABQIAAAA54d0gTgxqcQZ6EOe7Z9gKRRgYaIneHJ0gJayKvKA7hGFMgFKsBQyuLpmbOmgkDsIX4qTC07yWP-gUA";

	// AgendaServiceAsync calendar = (AgendaServiceAsync)GWT.create(AgendaService.class);

	private static AgendaWidget instance;

	private AgendaWidget()
	{
		this.add(html);
		loadAPIAndUpdate();
	}

	private void loadAPIAndUpdate()
	{
//		if (!GData.isLoaded(GDataSystemPackage.CALENDAR))
//		{
//			html.setText("Loading the GData Calendar package...");
//			GData.loadGDataApi(GDATA_API_KEY, new Runnable()
//			{
//				public void run()
//				{
//					html.setText("GData Calendar package loaded.");
//					update();
//				}
//			}, GDataSystemPackage.CALENDAR);
//		}
//		else
//			update();
	}

	public void update()
	{
//		CalendarService service = CalendarService.newInstance("pftf-colab-3");
//		CalendarEventQuery query = CalendarEventQuery.newInstance(calendarURL);
//		service.getEventsFeed(query, new CalendarEventFeedCallback()
//		{
//			public void onSuccess(CalendarEventFeed result)
//			{
//				StringBuffer buffer = new StringBuffer();
//				EventEntry[] entries = result.getEntries();
//				for (EventEntry entry : entries)
//				{
//					buffer.append(entry.getTitle().getText()).append("<br/>");
//
//					When[] times = entry.getTimes();
//					buffer.append(times[0].getStartTime()).append("<br/>");
//
//					buffer.append(entry.getContent().getText()).append("<br/>");
//				}
//				html.setText(buffer.toString());
//			}
//
//			@Override
//			public void onFailure(CallErrorException caught)
//			{
//				html.setText("Error");
//			}
//		});
	}

	// public void updateServer()
	// {
	// calendar.getEventList(new AsyncCallback<String>()
	// {
	// public void onSuccess(String result)
	// {
	// html.setText(result);
	// }
	//
	// public void onFailure(Throwable caught)
	// {
	// html.setText("Error");
	// }
	// });
	// }

	public static AgendaWidget getInstance()
	{
		if (instance == null) instance = new AgendaWidget();
		return instance;
	}
}