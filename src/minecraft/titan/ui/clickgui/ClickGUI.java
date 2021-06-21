package titan.ui.clickgui;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import titan.Client;
import titan.ui.clickgui.comp.ModButton;
import titan.Utils.GuiUtil;

public class ClickGUI extends GuiScreen {
	
	ArrayList<ModButton> modButtons = new ArrayList<>();
	
	@Override
	public void initGui() {
		super.initGui();
		this.modButtons.add(new ModButton(210, 60, 70, mc.fontRendererObj.FONT_HEIGHT + 5, Client.INSTANCE.hudManager.MPD));
		this.modButtons.add(new ModButton(285, 60, 70, mc.fontRendererObj.FONT_HEIGHT + 5, Client.INSTANCE.hudManager.fps));
		this.modButtons.add(new ModButton(360, 60, 70, mc.fontRendererObj.FONT_HEIGHT + 5, Client.INSTANCE.hudManager.keystrokes));
		this.modButtons.add(new ModButton(435, 60, 70, mc.fontRendererObj.FONT_HEIGHT + 5, Client.INSTANCE.hudManager.pingHUD));
		this.modButtons.add(new ModButton(515, 60, 70, mc.fontRendererObj.FONT_HEIGHT + 5, Client.INSTANCE.hudManager.cps));
		this.modButtons.add(new ModButton(590, 60, 70, mc.fontRendererObj.FONT_HEIGHT + 5, Client.INSTANCE.hudManager.xyz));
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		ScaledResolution sr = new ScaledResolution(mc);
		super.drawScreen(mouseX, mouseY, partialTicks);
		
		Gui.drawRect(200, 50, sr.getScaledWidth() - 200, sr.getScaledHeight() -50, new Color(0, 0, 0, 170).getRGB());
		
		
		for(ModButton m : modButtons) {
			m.draw();
		}
	}
	
	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		super.mouseClicked(mouseX, mouseY, mouseButton);
		for(ModButton m : modButtons) {
			m.onClick(mouseX, mouseY, mouseButton);
		}
	}
	
}
