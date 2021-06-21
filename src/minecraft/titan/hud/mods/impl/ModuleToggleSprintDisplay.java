package titan.hud.mods.impl;

import java.awt.Color;

import net.minecraft.client.gui.Gui;
import titan.hud.mods.HudMod;

public class ModuleToggleSprintDisplay extends HudMod {

    public ModuleToggleSprintDisplay() {
        super("Sprint Display", 5, 5);
    }
    
    @Override
    public void draw() {
        if (mc.thePlayer.isSprinting()) {
            Gui.drawRect(getX() - 2, getY() - 2, getX() + getWidth(), getY() + getHeight(), new Color(0,0,0, 170).getRGB());
            fr.drawString("Sprinting [Toggled]", getX(), getY(), -1);
        }
        super.draw();
    }
    
    public void renderDummy(int mouseX, int mouseY) {
        Gui.drawRect(getX() - 2, getY() - 2, getX() + getWidth(), getY() + getHeight(), new Color(0,0,0, 170).getRGB());
        fr.drawStringWithShadow("ToggleSprint Display", getX(), getY(), -1);
        super.RenderDummy(mouseX, mouseY);
    }
    
    @Override
    public int getWidth() {
        if (mc.isGuiEnabled()) {
            return fr.getStringWidth("Sprinting") + 1;
        } else {
            return fr.getStringWidth("ToggleSprint Display") + 1;
        }
    }
    @Override
    public int getHeight() {
        return fr.FONT_HEIGHT + 1;
    }

}