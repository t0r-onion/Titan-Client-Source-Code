package titan.mod;

import java.util.ArrayList;

import titan.mod.impl.*;

public class ModManager {
	
	public ToggleSprint toggleSprint;
	public ToggleSneak toggleSneak;
	public ArrayList<ModuleMain> mods;
	
	public ModManager() {
		mods = new ArrayList<>();
		
		//MISC
		mods.add(toggleSprint = new ToggleSprint());
		mods.add(toggleSneak = new ToggleSneak());
		}
	
}
