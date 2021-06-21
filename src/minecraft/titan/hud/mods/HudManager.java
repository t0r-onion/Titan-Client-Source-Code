package titan.hud.mods;

import java.util.ArrayList;

import titan.hud.mods.impl.ModuleArmorStatus;
import titan.hud.mods.impl.ModuleCPS;
import titan.hud.mods.impl.ModuleFPS;
import titan.hud.mods.impl.ModuleKeystrokes;
import titan.hud.mods.impl.ModulePackDisplay;
import titan.hud.mods.impl.ModulePingHud;
import titan.hud.mods.impl.ModuleToggleSprintDisplay;
import titan.hud.mods.impl.ModuleXYZ;

public class HudManager {
	
	public ArrayList<HudMod> hudMods = new ArrayList<>();

	
	public ModuleFPS fps;
	public ModuleKeystrokes keystrokes;
	public ModulePingHud pingHUD;
	public ModuleToggleSprintDisplay TSD;
	public ModulePackDisplay MPD;
	public ModuleXYZ xyz;
	public ModuleCPS cps;
	public ModuleArmorStatus MAS;
	
	public HudManager() {
		hudMods.add(fps = new ModuleFPS());
		hudMods.add(keystrokes = new ModuleKeystrokes());
		hudMods.add(pingHUD = new ModulePingHud());
		hudMods.add(TSD = new ModuleToggleSprintDisplay());
		hudMods.add(MPD = new ModulePackDisplay());
		hudMods.add(MAS = new ModuleArmorStatus());
		hudMods.add(cps = new ModuleCPS());
		hudMods.add(xyz = new ModuleXYZ());
	}

		
	    
	
	public void renderMods() {
		for(HudMod m : hudMods)
			if(m.isEnabled()) 
				m.draw();
				}
			}