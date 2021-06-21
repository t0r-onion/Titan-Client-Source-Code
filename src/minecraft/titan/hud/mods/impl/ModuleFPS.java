package titan.hud.mods.impl;

import java.awt.Color;

import net.minecraft.client.gui.Gui;
import titan.hud.mods.HudMod;

public class ModuleFPS extends HudMod {

	public ModuleFPS() {
		super("[FPS: " + mc.getDebugFPS(), 100, 100);
	}
	
	@Override
	public void draw() {
		fr.drawString("§0[§7FPS:§0 " + mc.getDebugFPS() + "]§0", getX(), getY(), -1);
		super.draw();
	}
	
	@Override
	public void RenderDummy(int mouseX, int mouseY) {
		fr.drawString("[§8FPS: " + mc.getDebugFPS() + "]§0", getX(), getY(), -1);
		super.RenderDummy(mouseX, mouseY);
	}
	
	@Override
	public int getWidth() {
		return fr.getStringWidth("[§8FPS: " + mc.getDebugFPS() + "]§0"); 
	}
	
	@Override
	public int getHeight() {
		return fr.FONT_HEIGHT;
	}

}
