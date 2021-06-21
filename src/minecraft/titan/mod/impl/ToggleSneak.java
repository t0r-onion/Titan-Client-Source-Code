package titan.mod.impl;

import titan.event.EventTarget;
import titan.mod.Catagory;
import titan.mod.ModuleMain;

public class ToggleSneak extends ModuleMain {

	public ToggleSneak() {
		super("ToggleSneak", "Toggle your sneaking status!", Catagory.MISC);	
	}
	@EventTarget
	public void onUpdate() {
		if(this.isEnabled() && !mc.thePlayer.isBlocking() && !mc.thePlayer.isSprinting()) {
			mc.thePlayer.setSneaking(true);
		}

	}
	
	@Override
	public void onDisable() {
		super.onDisable();
		
		mc.thePlayer.setSneaking(false);
	}
	
}
