package org.iskconsv.client;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.LazyPanel;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Widget;

public class Controller implements ValueChangeHandler<String>
{
	public static final Controller INSTANCE = new Controller();

	private Map<String, Command> commandMap = new HashMap<String, Command>();

	String state;

	Panel targetPanel;

	public void setTargetPanel(Panel targetPanel)
	{
		this.targetPanel = targetPanel;
	}

	public Controller()
	{
	}

	public Controller(Panel targetPanel)
	{
		this.targetPanel = targetPanel;
	}

	public void addCommandMapItem(String token, Command command)
	{
		commandMap.put(token, command);
	}

	public void addCommandMapItem(Enum<?> token, Command command)
	{
		commandMap.put(token.name(), command);
	}

	@Override
	public void onValueChange(ValueChangeEvent<String> event)
	{
		Command command = commandMap.get(event.getValue());
		if (command != null)
			command.execute();
	}

	public void updateContent(Widget widget, String historyToken)
	{
		targetPanel.clear();
		targetPanel.add(widget);

		if (widget instanceof LazyPanel)
			((LazyPanel) widget).setVisible(true);

		if (historyToken != null)
			History.newItem(historyToken, false);
	}
}