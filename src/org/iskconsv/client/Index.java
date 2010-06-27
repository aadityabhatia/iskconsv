package org.iskconsv.client;

import org.iskconsv.client.command.FrameCommand;
import org.iskconsv.client.command.HistoryCommand;
import org.iskconsv.client.command.PopupCommand;
import org.iskconsv.client.command.TextCommand;
import org.iskconsv.client.command.WidgetCommand;
import org.iskconsv.client.resources.Resources;
import org.iskconsv.client.view.Donate;
import org.iskconsv.client.view.LoginPopup;
import org.iskconsv.client.view.SubscribePopup;
import org.iskconsv.client.widget.IFrame;
import org.iskconsv.client.widget.NavigationBar;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.RootLayoutPanel;

public class Index implements EntryPoint
{
	private static IndexUiBinder uiBinder = GWT.create(IndexUiBinder.class);

	interface IndexUiBinder extends UiBinder<DockLayoutPanel, Index>
	{
	}

	@UiField
	DockLayoutPanel layoutPanel;

	@UiField
	NavigationBar topNavigationBar;

	@UiField
	MenuBar menuBar;

	@UiField
	FlowPanel contentPanel;

	@UiField
	Resources resources;

	private static final String calendarURL = "http://www.google.com/calendar/embed?showTitle=0&showNav=0&showTabs=0&showCalendars=0&mode=AGENDA&height=600&wkst=2&bgcolor=%23FFFFFF&src=iskconsv.org_rbojmj93jcrbo0d4t6m17h54c0%40group.calendar.google.com&color=%23BE6D00&ctz=America%2FLos_Angeles";

	private static final String videoURL = "http://www.justin.tv/widgets/live_embed_player.swf?channel=iskconsv";

	private static final String spyURL = "http://spy.appspot.com/find/iskcon?full=1&latest=25";

	enum Token
	{
		calendar, video, spy, donate
	}

	@Override
	public void onModuleLoad()
	{
		Controller controller = Controller.INSTANCE;
		
		RootLayoutPanel.get().add(uiBinder.createAndBindUi(this));
		resources.style().ensureInjected();

		Window.enableScrolling(false);
		Window.setMargin("0px");
		IFrame.setStylePrimaryName(resources.style().iframe());

		controller.setTargetPanel(contentPanel);
		History.addValueChangeHandler(controller);

		controller.addCommandMapItem("", new TextCommand(resources.welcomeMessage(), ""));
		menuBar.addItem("Home", new HistoryCommand(""));

		controller.addCommandMapItem(Token.calendar, new FrameCommand(calendarURL));
		menuBar.addItem("Calendar", new HistoryCommand(Token.calendar));

		controller.addCommandMapItem(Token.video, new FrameCommand(videoURL));
		menuBar.addItem("Live Video", new HistoryCommand(Token.video));

		controller.addCommandMapItem(Token.spy, new FrameCommand(spyURL));
		menuBar.addItem("Live Stream", new HistoryCommand(Token.spy));

		controller.addCommandMapItem(Token.donate, new WidgetCommand(Donate.class, null));
		menuBar.addItem("Donate", new HistoryCommand(Token.donate));

		if (Cookies.getCookie("username") == null)
			menuBar.addItem("Sign In", new PopupCommand(LoginPopup.class));
		else
			menuBar.addItem("<a href='/auth/logout/'>Sign out</a>", true, new HistoryCommand(""));

		menuBar.addItem("Subscribe", new PopupCommand(SubscribePopup.class));

		History.fireCurrentHistoryState();
	}
}