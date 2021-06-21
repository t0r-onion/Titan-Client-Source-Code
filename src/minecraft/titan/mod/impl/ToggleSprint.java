package titan.mod.impl;

import net.minecraft.potion.Potion;
import titan.event.EventTarget;
import titan.mod.Catagory;
import titan.mod.ModuleMain;

public class ToggleSprint extends ModuleMain {

	public ToggleSprint() {
		super("ToggleSprint", "Toggle your sprinting status!", Catagory.MISC);	
	}
	@EventTarget
	public void onUpdate() {
		if(this.isEnabled() 
				&& !mc.thePlayer.isBlocking() 
				&& !mc.thePlayer.isSneaking() 
				&& (mc.thePlayer.motionX != 0 && mc.thePlayer.motionZ != 0 )
				&& !mc.thePlayer.isCollidedHorizontally
				&& !mc.thePlayer.isPotionActive(Potion.moveSlowdown)
				&& !mc.thePlayer.isPotionActive(Potion.confusion)
				&& !mc.gameSettings.keyBindBack.isKeyDown()) {
			mc.thePlayer.setSprinting(true);
		}

	}
	
	@Override
	public void onDisable() {
		super.onDisable();
		
		mc.thePlayer.setSprinting(false);
	}
	
}
