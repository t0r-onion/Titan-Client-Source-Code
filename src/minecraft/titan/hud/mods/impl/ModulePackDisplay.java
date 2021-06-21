package titan.hud.mods.impl;

import java.util.List;

import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.resources.IResourcePack;
import net.minecraft.client.resources.ResourcePackRepository.Entry;
import titan.hud.mods.HudMod;

public class ModulePackDisplay extends HudMod {
	
	

    public ModulePackDisplay() {
        super("Pack Display", 250, 200);
    }
    
    @Override
    public void draw() {
        if(mc.getNetHandler() != null && mc.thePlayer != null && mc.getNetHandler().getPlayerInfo(mc.thePlayer.getUniqueID()) != null){
              fr.drawStringWithShadow(this.getCurrentPack().getPackName(), getX(), getY(), 0xffffffff);
            }
        super.draw();
    }
    
    
    public void RenderDummy(int mouseX, int mouseY) {
        fr.drawStringWithShadow(this.getCurrentPack().getPackName(), getX(), getY(), 0xffffffff);
        super.RenderDummy(mouseX, mouseY);
    }
    
    @Override
    public int getWidth() {
        return fr.getStringWidth("[pack: ]");
    }
    
    
    @Override
    public int getHeight() {
        return fr.FONT_HEIGHT;
    }
    
    private IResourcePack getCurrentPack() {
        List list = this.mc.getResourcePackRepository().getRepositoryEntries();
        Object pack = null;

        return (IResourcePack) (list.size() > 0 ? ((Entry) list.get(0)).getResourcePack() : this.mc.mcDefaultResourcePack);
    }
    
}