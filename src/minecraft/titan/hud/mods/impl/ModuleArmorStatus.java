package titan.hud.mods.impl;

import java.awt.Color;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import titan.hud.mods.HudMod;
 
public class ModuleArmorStatus extends HudMod{
 
	public int FPS = mc.getDebugFPS();
 
	public ModuleArmorStatus() {
		super("Armour Status", 50, 50);
	}
 
	@Override
	public void draw() {
		for(int i = 0; i < this.mc.thePlayer.inventory.armorInventory.length; ++i) {
	         ItemStack itemStack = this.mc.thePlayer.inventory.armorInventory[i];
	         this.is(i, itemStack);
	      }
 
		super.draw();
	}
 
	 private void is(int i, ItemStack itemStack) {
	      if (itemStack != null) {
	         GL11.glPushMatrix();
	         int yAdd = -16 * i + 48;
	         if (itemStack.getItem().isDamageable()) {
	            double damage = (double)(itemStack.getMaxDamage() - itemStack.getItemDamage()) / (double)itemStack.getMaxDamage() * 100.0D;
	           fr.drawString(String.format("%.2f%%", damage), getX() + 20, getY() + yAdd + 5, Color.GREEN.getRGB());
	         }
 
	         RenderHelper.enableGUIStandardItemLighting();
	         this.mc.getRenderItem().renderItemAndEffectIntoGUI(itemStack, getX(), getY() + yAdd);
	         GL11.glPopMatrix();
	      }
 
	   }
 
	public void RenderDummy(int mouseX, int mouseY) {
 
		is( 3, new ItemStack((Item)Items.diamond_helmet));
	    is( 2, new ItemStack((Item)Items.leather_chestplate));
	    is( 1, new ItemStack((Item)Items.golden_leggings));
	    is( 0, new ItemStack((Item)Items.iron_boots));
		super.RenderDummy(mouseX, mouseY);
	}
 
	 static int DamageToColor(double percentage) {
	      if (percentage > 1.0D) {
	         percentage = 1.0D;
	      } else if (percentage < 0.0D) {
	         percentage = 0.0D;
	      }
 
	      int red = (int)(255.0D * (1.0D - percentage));
	      int green = (int)(255.0D * percentage);
	      int blue = 0;
	      return (new Color(red, green, blue)).getRGB();
	   }
 
	@Override
	public int getWidth() {
		 return 40;
	}
 
	@Override
	public int getHeight() {
		 return 60;
	}
 
}