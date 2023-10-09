package com.vardorvishealth;

import net.runelite.api.Player;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.OverlayPanel;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;
import net.runelite.client.util.QuantityFormatter;

import javax.inject.Inject;
import java.awt.*;
import java.util.Map;
public class VardorvisHealTrackerOverlay extends OverlayPanel {
    private final VardorvisHealTrackerPlugin plugin;

    @Inject
    public VardorvisHealTrackerOverlay(VardorvisHealTrackerPlugin plugin) {
        this.plugin = plugin;

    }

    @Override
    public Dimension render(Graphics2D graphics) {
        String text = "Total Healing: " + plugin.getTotalHealing();
        Point location = new Point(10, 10);
        OverlayUtil.renderTextLocation(graphics,
                location,
                text,
                Color.WHITE);
        return null;
    }

    @Inject
    private VardorvisHealTrackerOverlay overlay;

    @Inject
    private OverlayManager overlayManager;

    @Override
    protected void startUp() throws Exception {
        overlayManager.add(overlay);
    }

    @Override
    protected void shutDown() throws Exception {
        overlayManager.remove(overlay);
    }

}

