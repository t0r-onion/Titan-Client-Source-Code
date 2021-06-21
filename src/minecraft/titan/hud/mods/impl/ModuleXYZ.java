package titan.hud.mods.impl;

import java.awt.Color;

import titan.hud.mods.HudMod;
 
public class ModuleXYZ extends HudMod {
 
    public ModuleXYZ() {
        super("XYZ", 3, 13);
    }
 
    @Override
    public void draw() {
 
        
        fr.drawStringWithShadow("XYZ: " + Math.round(mc.thePlayer.posX) + " " + Math.round(mc.thePlayer.posY) + " " + Math.round(mc.thePlayer.posZ), getX(), getY(), -1);
        super.draw();
    }
    
    public void RenderDummy(int mouseX, int mouseY) {
        fr.drawStringWithShadow("XYZ: " + Math.round(mc.thePlayer.posX) + " " + Math.round(mc.thePlayer.posY) + " " + Math.round(mc.thePlayer.posZ), getX(), getY(), -1);
        super.RenderDummy(mouseX, mouseY);
    }
    
    @Override
    public int getWidth() {
        return fr.getStringWidth("XYZ:                  ");
    }
    
    @Override
    public int getHeight() {
        return fr.FONT_HEIGHT;
    }
    
}