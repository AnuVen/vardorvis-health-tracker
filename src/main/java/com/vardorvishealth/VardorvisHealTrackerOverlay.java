package com.vardorvishealth;


import net.runelite.client.ui.overlay.OverlayPanel;
import net.runelite.client.ui.overlay.OverlayUtil;

import javax.inject.Inject;
import java.awt.*;

public class VardorvisHealTrackerOverlay extends OverlayPanel {
    private final VardorvisHealTrackerPlugin plugin;

    @Inject
    public VardorvisHealTrackerOverlay(VardorvisHealTrackerPlugin plugin) {
        this.plugin = plugin;

    }

    @Override
    public Dimension render(Graphics2D graphics) {
        String text = "Total Healing: " + plugin.getTotalHealing();
        net.runelite.api.Point location = new net.runelite.api.Point(10, 10);  // net.runelite.api.Point
        OverlayUtil.renderTextLocation(graphics,
                location,
                text,
                Color.WHITE);
        return null;
    }


}

