package titan.hud;

import net.minecraft.client.gui.GuiScreen;
import titan.Client;
import titan.hud.mods.HudMod;

public class HUDConfigScreen extends GuiScreen{
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawDefaultBackground();
		
		for(HudMod m : Client.INSTANCE.hudManager.hudMods) {
			if(m.isEnabled()) 
			m.RenderDummy(mouseX, mouseY);
		}
		
		super.drawScreen(mouseX, mouseY, partialTicks);
	}

}
