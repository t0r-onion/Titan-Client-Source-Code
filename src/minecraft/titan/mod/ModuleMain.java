package titan.mod;

import net.minecraft.client.Minecraft;
import titan.Client;

public class ModuleMain {
	
	public Minecraft mc = Minecraft.getMinecraft();
	
	public String name, description;
	public boolean enabled;
	public Catagory catagory;
	
	public ModuleMain(String name, String description, Catagory catagory) {
		this.name = name;
		this.description = description;
		this.catagory = catagory;
		
		this.enabled = true;
	}
	
	public void onEnable() {
		Client.INSTANCE.eventManager.register(this);

	}
	
	public void onDisable() {
		Client.INSTANCE.eventManager.unregister(this);

	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
		if(enabled) {
			onEnable();
		} else {
			onDisable();
		}
	}
	
	public void toggle() {
		setEnabled(this.enabled);

	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public Catagory getCatagory() {
		return catagory;
	}
	
}
