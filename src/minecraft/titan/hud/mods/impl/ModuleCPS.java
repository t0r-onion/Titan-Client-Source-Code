package titan.hud.mods.impl;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Mouse;

import titan.hud.mods.HudMod;

public class ModuleCPS extends HudMod{

    public ModuleCPS() {
        super("CPS", 3, 33);
    }
    
    List<Long> clicks = new ArrayList<Long>();
    private boolean wasPressed;
    private long lastPressed;
    
    public void draw() {
        final boolean pressed = Mouse.isButtonDown(0);
        
        if(pressed != this.wasPressed) {
            this.lastPressed = System.currentTimeMillis();
            this.wasPressed = pressed;
            if(pressed) {
                this.clicks.add(this.lastPressed);
            }
        }
        
        fr.drawStringWithShadow("[CPS: " + getCPS() + "]", getX(), getY(), -1);
        
        //super.renderDummy(mouseX, mouseY);
    }
    
    @Override
    public int getWidth() {
        return fr.getStringWidth("[CPS: 00]");
    }
    
    @Override
    public int getHeight() {
        return fr.FONT_HEIGHT;
    }
    
    public void RenderDummy(int mouseX, int mouseY) {
        fr.drawStringWithShadow("[CPS: 00]", getX(), getY(), -1);
        super.RenderDummy(mouseX, mouseY);
    }

    private int getCPS() {
        final long time = System.currentTimeMillis();
        this.clicks.removeIf(aLong -> aLong + 1000 < time);
        return this.clicks.size();
    }
    
    
    
}