package org.iskconsv.client;

import org.iskconsv.client.command.FrameCommand;
import org.iskconsv.client.command.PopupCommand;
import org.iskconsv.client.command.WidgetCommand;
import org.iskconsv.client.widget.LoginPopup;
import org.iskconsv.client.widget.NavigationBar;
import org.iskconsv.client.widget.SubscribePopup;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.ui.CaptionPanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.StackLayoutPanel;
import com.google.gwt.user.client.ui.Widget;

public class Index extends Composite implements EntryPoint
{
	private static IndexUiBinder uiBinder = GWT.create(IndexUiBinder.class);

	interface IndexUiBinder extends UiBinder<Widget, Index>
	{
	}

	@UiField
	DockLayoutPanel layoutPanel;

	@UiField
	NavigationBar topNavigationBar;

	@UiField
	MenuItem agendaMenuItem, homeMenuItem, signInMenuItem, liveVideoMenuItem, subscribeMenuItem;

	@UiField
	MenuBar menuBar;

	@UiField
	CaptionPanel contentPanel;

	@UiField
	StackLayoutPanel stackPanel;

	private static Index self;

	private static final String calendarEmbedURL = "http://www.google.com/calendar/embed?showTitle=0&showNav=0&showTabs=0&showCalendars=0&mode=AGENDA&height=600&wkst=2&bgcolor=%23FFFFFF&src=iskconsv.org_rbojmj93jcrbo0d4t6m17h54c0%40group.calendar.google.com&color=%23BE6D00&ctz=America%2FLos_Angeles";
	private static final String videoEmbedURL = "http://www.justin.tv/widgets/live_embed_player.swf?channel=iskconsv";

	public Index()
	{
		self = this;
		initWidget(uiBinder.createAndBindUi(this));
	}

	public static Index getInstance()
	{
		return self;
	}

	@Override
	public void onModuleLoad()
	{
		RootLayoutPanel.get().addStyleName("rootPanel");
		RootLayoutPanel.get().add(this);

		contentPanel.setContentWidget(getWelcomeHTML());

		agendaMenuItem.setCommand(new FrameCommand(calendarEmbedURL, contentPanel));
		
		liveVideoMenuItem.setCommand(new FrameCommand(videoEmbedURL, contentPanel));

		homeMenuItem.setCommand(new WidgetCommand(getWelcomeHTML(), contentPanel));
		
		
		
		if (Cookies.getCookie("username") == null)
		{
			signInMenuItem.setCommand(new PopupCommand(new LoginPopup()));
			signInMenuItem.setText("Sign In");
		}
		else
		{
			signInMenuItem.setCommand(null);
			signInMenuItem.setHTML("<a href='/auth/logout/'>Sign out</a>");
		}
		
		subscribeMenuItem.setCommand(new PopupCommand(new SubscribePopup()));
	}


	private static HTML getWelcomeHTML()
	{
		return new HTML("<h3>Welcome to ISKCON of Silicon Valley</h3><h4>Here's what's you can do:<ol><li>View Events</li><li>View Live Content: Video, Tweets, photos and more...</li><li>Donate</li></ol></h4>");
	}
}