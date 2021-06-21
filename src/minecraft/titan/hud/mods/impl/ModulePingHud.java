package titan.hud.mods.impl;

import titan.hud.mods.HudMod;

public class ModulePingHud extends HudMod {

    public ModulePingHud() {
        super("PingHud", 200, 200);
    }
    
    @Override
    public void draw() {
        if(mc.getNetHandler() != null && mc.thePlayer != null && mc.getNetHandler().getPlayerInfo(mc.thePlayer.getUniqueID()) != null){
              fr.drawString("[Ping: " + mc.getNetHandler().getPlayerInfo(mc.thePlayer.getUniqueID()).getResponseTime() + "]", getX(), getY(), 0xffffffff);
            }
        super.draw();
    }
    
    
    public void renderDummy(int mouseX, int mouseY) {
        fr.drawString("[Ping: 69]", getX(), getY(), 0xffffffff);
        super.RenderDummy(mouseX, mouseY);
    }
    
    @Override
    public int getWidth() {
        return fr.getStringWidth("[Ping: 69]");
    }
    
    
    @Override
    public int getHeight() {
        return fr.FONT_HEIGHT;
    }

}