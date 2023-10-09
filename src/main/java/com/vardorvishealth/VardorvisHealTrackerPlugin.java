package com.vardorvishealth;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.*;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.api.events.HitsplatApplied;
import net.runelite.client.ui.overlay.OverlayManager;

@Slf4j
@PluginDescriptor(
	name = "Vardorvis Health Tracker"
)
public class VardorvisHealTrackerPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private VardorvisHealTrackerOverlay overlay;  // Injecting the overlay class

	@Inject
	private OverlayManager overlayManager;
	private int totalHealing = 0;

	@Override
	protected void startUp() throws Exception {
		overlayManager.add(overlay);  // Registering the overlay when the plugin starts
	}

	@Override
	protected void shutDown() throws Exception {
		overlayManager.remove(overlay);  // Unregistering the overlay when the plugin stops
	}

	public int getTotalHealing() {
		return totalHealing;
	}

	@Subscribe
	public void onHitsplatApplied(HitsplatApplied event) {
		Actor actor = event.getActor();
		if (actor instanceof NPC) {
			NPC npc = (NPC) actor;
			if (npc.getId() == 12223) {
				Hitsplat hitsplat = event.getHitsplat();
				if (hitsplat.getHitsplatType() == HitsplatID.HEAL) {
					totalHealing += hitsplat.getAmount();
				}
			}
		}
	}


	@Inject
	private VardorvisHealthConfig config;

	@Inject
	private ConfigManager configManager;

	@Provides
	VardorvisHealthConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(VardorvisHealthConfig.class);
	}




}
