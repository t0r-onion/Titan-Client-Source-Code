package titan.hud.mods;

import java.awt.Color;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import titan.hud.DraggableComponent;

public class HudMod {

	public static Minecraft mc = Minecraft.getMinecraft();
	public FontRenderer fr = mc.fontRendererObj;
	
	public String name;
	public boolean enabled;
	public DraggableComponent drag;
	
	public int x, y;
	
	public HudMod(String name, int x, int y) {
		this.name = name;
		this.x = x;
		this.y = y;
		
		drag = new DraggableComponent(x, y, x + getWidth(), getHeight(), new Color(0, 0, 0, 0).getRGB());
	}
	
	public int getWidth() {
		return 50;

	}
	
	public int getHeight() {
		return 50;

	}
	
	public void draw() {
		
	}
	
	public void RenderDummy(int mouseX, int mouseY) {
		drag.draw(mouseX, mouseY);
	}
	
	public int getX() {
		return drag.getxPosition();
	}
	
	public int getY() {
		return drag.getyPosition();
	}
	
	public boolean setEnabled(boolean enabled) {
		return this.enabled = enabled;
	}
	
	public void toggle() {
		this.setEnabled(!enabled);
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	
}
