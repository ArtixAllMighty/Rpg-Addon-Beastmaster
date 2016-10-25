package subaraki.beastmaster.item;

import static lib.item.ItemRegistry.*;

import lib.item.shield.ItemCustomShield;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import subaraki.beastmaster.item.armor.ItemBeastmasterArmor;
import subaraki.beastmaster.item.weapon.ItemClaws;
import subaraki.beastmaster.mod.AddonBeastMaster;
import subaraki.rpginventory.enums.JewelTypes;
import subaraki.rpginventory.item.RpgInventoryItem;
import subaraki.rpginventory.item.RpgItems.LocalizeEnum;

public class BeastMasterItems {

	public static final String BEASTMASTER_CLASS="beastmaster";
	public static ItemBeastmasterArmor bm_helm, bm_chest, bm_legs, bm_feet;
	public static ItemClaws claws;
	public static Item beastmasterplate;
	public static ItemCustomShield beastmastershield;

	public static ItemCrystal crystal;

	public static Item fur, claw, whistle, lure, craftLeather;

	final static String modid = AddonBeastMaster.MODID;

	public static final CreativeTabs tab =  new CreativeTabs("addon_beastmaster") {
		@Override
		public Item getTabIconItem() {
			return bm_helm;
		}
	};

	public static void load(){

		bm_helm = (ItemBeastmasterArmor) new ItemBeastmasterArmor(EntityEquipmentSlot.HEAD).setCreativeTab(tab);
		bm_chest = (ItemBeastmasterArmor) new ItemBeastmasterArmor(EntityEquipmentSlot.CHEST).setCreativeTab(tab);
		bm_legs = (ItemBeastmasterArmor) new ItemBeastmasterArmor(EntityEquipmentSlot.LEGS).setCreativeTab(tab);
		bm_feet = (ItemBeastmasterArmor) new ItemBeastmasterArmor(EntityEquipmentSlot.FEET).setCreativeTab(tab);

		claws = (ItemClaws) new ItemClaws().setUnlocalizedName(modid+".claws").setRegistryName(modid+".claws").setCreativeTab(tab);

		beastmasterplate = new Item().setCreativeTab(tab).setUnlocalizedName(modid+".beastmasterplate").setRegistryName("beastmasterplate");
		beastmastershield = (ItemCustomShield) new ItemCustomShield(){
			@Override
			public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
				return super.getIsRepairable(toRepair, repair);
			}
		}.setCreativeTab(tab).setMaxDamage(250).setUnlocalizedName(modid+".beastmastershield").setRegistryName("beastmastershield");

		claw = new Item().setCreativeTab(tab).setUnlocalizedName(modid+".animalclaw").setRegistryName(modid+".animalclaw");
		fur = new Item().setCreativeTab(tab).setUnlocalizedName(modid+".roughfur").setRegistryName(modid+".roughfur");

		crystal = (ItemCrystal) new ItemCrystal(JewelTypes.CRYSTAL, modid+".crystal").setCreativeTab(tab);

		whistle = (ItemWhistle) new ItemWhistle().setCreativeTab(tab).setUnlocalizedName(modid+".whistle").setRegistryName(modid+".whistle");

		lure = new Item().setCreativeTab(tab).setUnlocalizedName(modid+".lure").setRegistryName(modid+".lure");

		craftLeather = new Item().setCreativeTab(tab).setUnlocalizedName(modid+".craftLeather").setRegistryName(modid+".craftLeather");
		register();
		registerRecipes();
	}

	private static void register(){
		registerItem(bm_helm);
		registerItem(bm_chest);
		registerItem(bm_legs);
		registerItem(bm_feet);
		registerItem(claws);
		registerItem(fur);
		registerItem(claw);
		registerItem(crystal);
		registerItem(whistle);
		registerItem(lure);
		registerItem(craftLeather);
	}

	private static void registerRecipes(){
		Item rawMeats[] = new Item[]{Items.BEEF, Items.PORKCHOP, Items.RABBIT, Items.MUTTON, Items.CHICKEN};
		for(Item meat : rawMeats)
			GameRegistry.addShapelessRecipe(new ItemStack(lure, 3), Items.WHEAT, Items.SUGAR, Items.CARROT, meat);
		
		GameRegistry.addShapedRecipe(new ItemStack(claws,1), new Object[]{
				"ccc","fff","fff", 'f', fur, 'c', claw
		});
		
		GameRegistry.addShapelessRecipe(new ItemStack(craftLeather,2), fur, Items.LEATHER, Items.RABBIT_HIDE);
		
		
		addArmorRecipe(bm_helm, craftLeather, EntityEquipmentSlot.HEAD);
		addArmorRecipe(bm_chest, craftLeather, EntityEquipmentSlot.CHEST);
		addArmorRecipe(bm_legs, craftLeather, EntityEquipmentSlot.LEGS);
		addArmorRecipe(bm_feet, craftLeather, EntityEquipmentSlot.FEET);
	}

	public static void registerRenders(){
		registerRender(bm_helm, bm_helm.getModeltextureLocation(), modid);
		registerRender(bm_chest, bm_chest.getModeltextureLocation(), modid);
		registerRender(bm_legs, bm_legs.getModeltextureLocation(), modid);
		registerRender(bm_feet, bm_feet.getModeltextureLocation(), modid);
		
		registerRender(claws, "weapon/claw", modid);
		registerRender(fur, "fur", modid);
		registerRender(claw, "claw", modid);
		for(int i=0;i<5;i++)
			registerRender(crystal, "crystal", modid, i);
		registerRender(whistle, "whistle", modid);
		registerRender(lure, "lure", modid);
		registerVanillaRender(craftLeather, "leather", 0);
		
	}
}
