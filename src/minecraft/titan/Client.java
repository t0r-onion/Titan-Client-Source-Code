package titan;

import titan.mod.impl.quickplay.ModQuickPlay;
import net.minecraft.client.Minecraft;
import titan.Utils.SessionChanger;
import titan.event.EventManager;
import titan.event.EventTarget;
import titan.event.impl.ClientTick;
import titan.hud.HUDConfigScreen;
import titan.hud.mods.HudManager;
import titan.mod.ModManager;
import titan.ui.clickgui.ClickGUI;
import net.arikia.dev.drpc.*;

public class Client {
	
	public String NAME = "Pluto Client", VERSION = "V1.0.0", AUTHOR = "CHRON", NAMEVER = NAME + " Pluto Client " + VERSION + "1.0.0";
	public static Client INSTANCE = new Client();
	public static boolean buttonstyle;
	public Minecraft mc = Minecraft.getMinecraft();
	private ModQuickPlay modQuickPlay;
	private static DiscordRP discordRP = new DiscordRP();
	
	
	public EventManager eventManager;
	public ModManager modManager;
	public HudManager hudManager;
	
	public void startup() {
		discordRP.start();
		eventManager = new EventManager();
		modManager = new ModManager();
		hudManager = new HudManager();
		
		SessionChanger.getInstance().setUserOffline("__BluePvP__");
		
		System.out.println("Starting " + NAMEVER);
		eventManager.register(this);
	}
	
	public static DiscordRP getDiscordRP() {
		return discordRP;
	}
	
	public void shutdown() {
		System.out.println("Shutting down " + NAMEVER);
		
		eventManager.unregister(this);
	}
	
	@EventTarget
	public void onTick(ClientTick event) {
		if(mc.gameSettings.HUD_CONFIG.isPressed()) {
			mc.displayGuiScreen(new HUDConfigScreen());
		}
		if(mc.gameSettings.CLICK_GUI.isPressed()) {
			mc.displayGuiScreen(new ClickGUI());
		}
		if(Minecraft.getMinecraft().gameSettings.GLHF.isPressed()) {
            Minecraft.getMinecraft().thePlayer.sendChatMessage("GLHF");
		}
		if(mc.gameSettings.keyBindSprint.isPressed()) {
			modManager.toggleSprint.toggle();
		}
		if (Minecraft.getMinecraft().gameSettings.CLIENT_QUICKPLAY.isPressed()) {
			Minecraft.getMinecraft().displayGuiScreen(new ModQuickPlay(modQuickPlay));
		}
	}
}