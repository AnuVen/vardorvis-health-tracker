package com.vardorvishealth;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

import javax.swing.*;

import static java.awt.AWTEventMulticaster.add;

@ConfigGroup("Vardorvis Heal Tracker")
public interface VardorvisHealthConfig extends Config
{
	@ConfigItem(
			keyName = "showOverlay",
			name = "Show Overlay",
			description = "Configures whether or not the overlay is displayed"
	)
	default boolean showOverlay()
	{
		return true;
	}


}
