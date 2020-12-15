package moriyashiine.bewitchment.common.registry;

import com.terraformersmc.terraform.boat.TerraformBoatItem;
import com.terraformersmc.terraform.leaves.block.TerraformLeavesBlock;
import com.terraformersmc.terraform.sign.block.TerraformSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformWallSignBlock;
import com.terraformersmc.terraform.wood.block.*;
import moriyashiine.bewitchment.common.Bewitchment;
import moriyashiine.bewitchment.common.block.BWChestBlock;
import moriyashiine.bewitchment.common.block.DragonsBloodLogBlock;
import moriyashiine.bewitchment.common.block.SaltLineBlock;
import moriyashiine.bewitchment.common.block.util.BWCarpetBlock;
import moriyashiine.bewitchment.common.block.util.BWCropBlock;
import moriyashiine.bewitchment.common.block.util.BWOreBlock;
import moriyashiine.bewitchment.common.block.util.BWSaplingBlock;
import moriyashiine.bewitchment.common.item.tool.AthameItem;
import moriyashiine.bewitchment.common.item.tool.SilverArrowItem;
import moriyashiine.bewitchment.common.item.tool.util.BWAxeItem;
import moriyashiine.bewitchment.common.item.tool.util.BWHoeItem;
import moriyashiine.bewitchment.common.item.tool.util.BWPickaxeItem;
import moriyashiine.bewitchment.common.world.generator.tree.generator.CypressSaplingGenerator;
import moriyashiine.bewitchment.common.world.generator.tree.generator.DragonsBloodSaplingGenerator;
import moriyashiine.bewitchment.common.world.generator.tree.generator.ElderSaplingGenerator;
import moriyashiine.bewitchment.common.world.generator.tree.generator.JuniperSaplingGenerator;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.*;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.LinkedHashMap;
import java.util.Map;

import static net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings.copyOf;

public class BWObjects {
	private static final Map<Block, Identifier> BLOCKS = new LinkedHashMap<>();
	private static final Map<Item, Identifier> ITEMS = new LinkedHashMap<>();
	
	//misc_no_item
	public static final Block SALT_LINE = create("salt_line", new SaltLineBlock(copyOf(Blocks.REDSTONE_WIRE)), false);
	//crop
	public static final Block ACONITE_CROP = create("aconite", new BWCropBlock(copyOf(Blocks.WHEAT)), false);
	public static final Block BELLADONNA_CROP = create("belladonna", new BWCropBlock(copyOf(ACONITE_CROP)), false);
	public static final Block GARLIC_CROP = create("garlic", new BWCropBlock(copyOf(ACONITE_CROP)), false);
	public static final Block MANDRAKE_CROP = create("mandrake", new BWCropBlock(copyOf(ACONITE_CROP)), false);
	//juniper
	public static final Block STRIPPED_JUNIPER_LOG = create("stripped_juniper_log", new PillarBlock(copyOf(Blocks.OAK_LOG)), true);
	public static final Block STRIPPED_JUNIPER_WOOD = create("stripped_juniper_wood", new PillarBlock(copyOf(STRIPPED_JUNIPER_LOG)), true);
	public static final Block JUNIPER_LOG = create("juniper_log", new StrippableLogBlock(() -> STRIPPED_JUNIPER_LOG, MaterialColor.BROWN, copyOf(STRIPPED_JUNIPER_LOG)), true);
	public static final Block JUNIPER_WOOD = create("juniper_wood", new StrippableLogBlock(() -> STRIPPED_JUNIPER_WOOD, MaterialColor.BROWN, copyOf(STRIPPED_JUNIPER_LOG)), true);
	public static final Block JUNIPER_LEAVES = create("juniper_leaves", new TerraformLeavesBlock(), true);
	//todo: juniper tree
	public static final Block JUNIPER_SAPLING = create("juniper_sapling", new BWSaplingBlock(new JuniperSaplingGenerator(), copyOf(Blocks.OAK_SAPLING)), true);
	public static final Block POTTED_JUNIPER_SAPLING = create("potted_juniper_sapling", new FlowerPotBlock(JUNIPER_SAPLING, copyOf(Blocks.POTTED_OAK_SAPLING)), false);
	public static final Block JUNIPER_PLANKS = create("juniper_planks", new Block(copyOf(Blocks.OAK_PLANKS)), true);
	public static final Block JUNIPER_STAIRS = create("juniper_stairs", new TerraformStairsBlock(JUNIPER_PLANKS, copyOf(Blocks.OAK_STAIRS)), true);
	public static final Block JUNIPER_SLAB = create("juniper_slab", new SlabBlock(copyOf(Blocks.OAK_SLAB)), true);
	public static final Block JUNIPER_FENCE = create("juniper_fence", new FenceBlock(copyOf(Blocks.OAK_FENCE)), true);
	public static final Block JUNIPER_FENCE_GATE = create("juniper_fence_gate", new FenceGateBlock(copyOf(Blocks.OAK_FENCE_GATE)), true);
	public static final Block JUNIPER_PRESSURE_PLATE = create("juniper_pressure_plate", new TerraformPressurePlateBlock(copyOf(Blocks.OAK_PRESSURE_PLATE)), true);
	public static final Block JUNIPER_BUTTON = create("juniper_button", new TerraformButtonBlock(copyOf(Blocks.OAK_BUTTON)), true);
	public static final Block JUNIPER_TRAPDOOR = create("juniper_trapdoor", new TerraformTrapdoorBlock(copyOf(Blocks.OAK_TRAPDOOR)), true);
	public static final Block JUNIPER_DOOR = create("juniper_door", new TerraformDoorBlock(copyOf(Blocks.OAK_DOOR)), false);
	public static final Item JUNIPER_DOOR_ITEM = create("juniper_door", new TallBlockItem(JUNIPER_DOOR, gen()));
	public static final Block JUNIPER_CHEST = create("juniper_chest", new BWChestBlock(copyOf(Blocks.CHEST), () -> BWBlockEntityTypes.BW_CHEST, false), true);
	public static final Block TRAPPED_JUNIPER_CHEST = create("trapped_juniper_chest", new BWChestBlock(copyOf(Blocks.CHEST), () -> BWBlockEntityTypes.BW_CHEST, true), true);
	private static final Identifier JUNIPER_SIGN_TEXTURE = new Identifier(Bewitchment.MODID, "entity/sign/juniper");
	public static final TerraformSignBlock JUNIPER_SIGN = create("juniper_sign", new TerraformSignBlock(JUNIPER_SIGN_TEXTURE, copyOf(Blocks.OAK_SIGN)), false);
	public static final Block JUNIPER_WALL_SIGN = create("juniper_wall_sign", new TerraformWallSignBlock(JUNIPER_SIGN_TEXTURE, copyOf(Blocks.OAK_WALL_SIGN)), false);
	public static final Item JUNIPER_SIGN_ITEM = create("juniper_sign", new SignItem(gen().maxCount(16), JUNIPER_SIGN, JUNIPER_WALL_SIGN));
	public static final TerraformBoatItem JUNIPER_BOAT = create("juniper_boat", new TerraformBoatItem(() -> BWEntityTypes.JUNIPER_BOAT, gen().maxCount(1)));
	//cypress
	public static final Block STRIPPED_CYPRESS_LOG = create("stripped_cypress_log", new PillarBlock(copyOf(JUNIPER_LOG)), true);
	public static final Block STRIPPED_CYPRESS_WOOD = create("stripped_cypress_wood", new PillarBlock(copyOf(STRIPPED_CYPRESS_LOG)), true);
	public static final Block CYPRESS_LOG = create("cypress_log", new StrippableLogBlock(() -> STRIPPED_CYPRESS_LOG, MaterialColor.BROWN, copyOf(STRIPPED_CYPRESS_LOG)), true);
	public static final Block CYPRESS_WOOD = create("cypress_wood", new StrippableLogBlock(() -> STRIPPED_CYPRESS_WOOD, MaterialColor.BROWN, copyOf(STRIPPED_CYPRESS_LOG)), true);
	public static final Block CYPRESS_LEAVES = create("cypress_leaves", new TerraformLeavesBlock(), true);
	//todo: cypress tree
	public static final Block CYPRESS_SAPLING = create("cypress_sapling", new BWSaplingBlock(new CypressSaplingGenerator(), copyOf(JUNIPER_SAPLING)), true);
	public static final Block POTTED_CYPRESS_SAPLING = create("potted_cypress_sapling", new FlowerPotBlock(CYPRESS_SAPLING, copyOf(POTTED_JUNIPER_SAPLING)), false);
	public static final Block CYPRESS_PLANKS = create("cypress_planks", new Block(copyOf(JUNIPER_PLANKS)), true);
	public static final Block CYPRESS_STAIRS = create("cypress_stairs", new TerraformStairsBlock(CYPRESS_PLANKS, copyOf(JUNIPER_STAIRS)), true);
	public static final Block CYPRESS_SLAB = create("cypress_slab", new SlabBlock(copyOf(JUNIPER_SLAB)), true);
	public static final Block CYPRESS_FENCE = create("cypress_fence", new FenceBlock(copyOf(JUNIPER_FENCE)), true);
	public static final Block CYPRESS_FENCE_GATE = create("cypress_fence_gate", new FenceGateBlock(copyOf(JUNIPER_FENCE_GATE)), true);
	public static final Block CYPRESS_PRESSURE_PLATE = create("cypress_pressure_plate", new TerraformPressurePlateBlock(copyOf(JUNIPER_PRESSURE_PLATE)), true);
	public static final Block CYPRESS_BUTTON = create("cypress_button", new TerraformButtonBlock(copyOf(JUNIPER_BUTTON)), true);
	public static final Block CYPRESS_TRAPDOOR = create("cypress_trapdoor", new TerraformTrapdoorBlock(copyOf(JUNIPER_TRAPDOOR)), true);
	public static final Block CYPRESS_DOOR = create("cypress_door", new TerraformDoorBlock(copyOf(JUNIPER_DOOR)), false);
	public static final Item CYPRESS_DOOR_ITEM = create("cypress_door", new TallBlockItem(CYPRESS_DOOR, gen()));
	public static final Block CYPRESS_CHEST = create("cypress_chest", new BWChestBlock(copyOf(JUNIPER_CHEST), () -> BWBlockEntityTypes.BW_CHEST, false), true);
	public static final Block TRAPPED_CYPRESS_CHEST = create("trapped_cypress_chest", new BWChestBlock(copyOf(JUNIPER_CHEST), () -> BWBlockEntityTypes.BW_CHEST, true), true);
	private static final Identifier CYPRESS_SIGN_TEXTURE = new Identifier(Bewitchment.MODID, "entity/sign/cypress");
	public static final TerraformSignBlock CYPRESS_SIGN = create("cypress_sign", new TerraformSignBlock(CYPRESS_SIGN_TEXTURE, copyOf(JUNIPER_SIGN)), false);
	public static final Block CYPRESS_WALL_SIGN = create("cypress_wall_sign", new TerraformWallSignBlock(CYPRESS_SIGN_TEXTURE, copyOf(JUNIPER_WALL_SIGN)), false);
	public static final Item CYPRESS_SIGN_ITEM = create("cypress_sign", new SignItem(gen().maxCount(16), CYPRESS_SIGN, CYPRESS_WALL_SIGN));
	public static final TerraformBoatItem CYPRESS_BOAT = create("cypress_boat", new TerraformBoatItem(() -> BWEntityTypes.CYPRESS_BOAT, gen().maxCount(1)));
	//elder
	public static final Block STRIPPED_ELDER_LOG = create("stripped_elder_log", new PillarBlock(copyOf(JUNIPER_LOG)), true);
	public static final Block STRIPPED_ELDER_WOOD = create("stripped_elder_wood", new PillarBlock(copyOf(STRIPPED_ELDER_LOG)), true);
	public static final Block ELDER_LOG = create("elder_log", new StrippableLogBlock(() -> STRIPPED_ELDER_LOG, MaterialColor.BROWN, copyOf(STRIPPED_ELDER_LOG)), true);
	public static final Block ELDER_WOOD = create("elder_wood", new StrippableLogBlock(() -> STRIPPED_ELDER_WOOD, MaterialColor.BROWN, copyOf(STRIPPED_ELDER_LOG)), true);
	public static final Block ELDER_LEAVES = create("elder_leaves", new TerraformLeavesBlock(), true);
	//todo: elder tree
	public static final Block ELDER_SAPLING = create("elder_sapling", new BWSaplingBlock(new ElderSaplingGenerator(), copyOf(JUNIPER_SAPLING)), true);
	public static final Block POTTED_ELDER_SAPLING = create("potted_elder_sapling", new FlowerPotBlock(ELDER_SAPLING, copyOf(POTTED_JUNIPER_SAPLING)), false);
	public static final Block ELDER_PLANKS = create("elder_planks", new Block(copyOf(JUNIPER_PLANKS)), true);
	public static final Block ELDER_STAIRS = create("elder_stairs", new TerraformStairsBlock(ELDER_PLANKS, copyOf(JUNIPER_STAIRS)), true);
	public static final Block ELDER_SLAB = create("elder_slab", new SlabBlock(copyOf(JUNIPER_SLAB)), true);
	public static final Block ELDER_FENCE = create("elder_fence", new FenceBlock(copyOf(JUNIPER_FENCE)), true);
	public static final Block ELDER_FENCE_GATE = create("elder_fence_gate", new FenceGateBlock(copyOf(JUNIPER_FENCE_GATE)), true);
	public static final Block ELDER_PRESSURE_PLATE = create("elder_pressure_plate", new TerraformPressurePlateBlock(copyOf(JUNIPER_PRESSURE_PLATE)), true);
	public static final Block ELDER_BUTTON = create("elder_button", new TerraformButtonBlock(copyOf(JUNIPER_BUTTON)), true);
	public static final Block ELDER_TRAPDOOR = create("elder_trapdoor", new TerraformTrapdoorBlock(copyOf(JUNIPER_TRAPDOOR)), true);
	public static final Block ELDER_DOOR = create("elder_door", new TerraformDoorBlock(copyOf(JUNIPER_DOOR)), false);
	public static final Item ELDER_DOOR_ITEM = create("elder_door", new TallBlockItem(ELDER_DOOR, gen()));
	public static final Block ELDER_CHEST = create("elder_chest", new BWChestBlock(copyOf(JUNIPER_CHEST), () -> BWBlockEntityTypes.BW_CHEST, false), true);
	public static final Block TRAPPED_ELDER_CHEST = create("trapped_elder_chest", new BWChestBlock(copyOf(JUNIPER_CHEST), () -> BWBlockEntityTypes.BW_CHEST, true), true);
	private static final Identifier ELDER_SIGN_TEXTURE = new Identifier(Bewitchment.MODID, "entity/sign/elder");
	public static final TerraformSignBlock ELDER_SIGN = create("elder_sign", new TerraformSignBlock(ELDER_SIGN_TEXTURE, copyOf(JUNIPER_SIGN)), false);
	public static final Block ELDER_WALL_SIGN = create("elder_wall_sign", new TerraformWallSignBlock(ELDER_SIGN_TEXTURE, copyOf(JUNIPER_WALL_SIGN)), false);
	public static final Item ELDER_SIGN_ITEM = create("elder_sign", new SignItem(gen().maxCount(16), ELDER_SIGN, ELDER_WALL_SIGN));
	public static final TerraformBoatItem ELDER_BOAT = create("elder_boat", new TerraformBoatItem(() -> BWEntityTypes.ELDER_BOAT, gen().maxCount(1)));
	//dragons_blood
	public static final Block STRIPPED_DRAGONS_BLOOD_LOG = create("stripped_dragons_blood_log", new PillarBlock(copyOf(JUNIPER_LOG)), true);
	public static final Block STRIPPED_DRAGONS_BLOOD_WOOD = create("stripped_dragons_blood_wood", new PillarBlock(copyOf(STRIPPED_DRAGONS_BLOOD_LOG)), true);
	public static final Block DRAGONS_BLOOD_LOG = create("dragons_blood_log", new DragonsBloodLogBlock(() -> STRIPPED_DRAGONS_BLOOD_LOG, MaterialColor.BROWN, copyOf(STRIPPED_DRAGONS_BLOOD_LOG).ticksRandomly()), true);
	public static final Block DRAGONS_BLOOD_WOOD = create("dragons_blood_wood", new StrippableLogBlock(() -> STRIPPED_DRAGONS_BLOOD_WOOD, MaterialColor.BROWN, copyOf(STRIPPED_DRAGONS_BLOOD_LOG)), true);
	public static final Block DRAGONS_BLOOD_LEAVES = create("dragons_blood_leaves", new TerraformLeavesBlock(), true);
	//todo: dragons_blood tree
	public static final Block DRAGONS_BLOOD_SAPLING = create("dragons_blood_sapling", new BWSaplingBlock(new DragonsBloodSaplingGenerator(), copyOf(JUNIPER_SAPLING)), true);
	public static final Block POTTED_DRAGONS_BLOOD_SAPLING = create("potted_dragons_blood_sapling", new FlowerPotBlock(DRAGONS_BLOOD_SAPLING, copyOf(POTTED_JUNIPER_SAPLING)), false);
	public static final Block DRAGONS_BLOOD_PLANKS = create("dragons_blood_planks", new Block(copyOf(JUNIPER_PLANKS)), true);
	public static final Block DRAGONS_BLOOD_STAIRS = create("dragons_blood_stairs", new TerraformStairsBlock(DRAGONS_BLOOD_PLANKS, copyOf(JUNIPER_STAIRS)), true);
	public static final Block DRAGONS_BLOOD_SLAB = create("dragons_blood_slab", new SlabBlock(copyOf(JUNIPER_SLAB)), true);
	public static final Block DRAGONS_BLOOD_FENCE = create("dragons_blood_fence", new FenceBlock(copyOf(JUNIPER_FENCE)), true);
	public static final Block DRAGONS_BLOOD_FENCE_GATE = create("dragons_blood_fence_gate", new FenceGateBlock(copyOf(JUNIPER_FENCE_GATE)), true);
	public static final Block DRAGONS_BLOOD_PRESSURE_PLATE = create("dragons_blood_pressure_plate", new TerraformPressurePlateBlock(copyOf(JUNIPER_PRESSURE_PLATE)), true);
	public static final Block DRAGONS_BLOOD_BUTTON = create("dragons_blood_button", new TerraformButtonBlock(copyOf(JUNIPER_BUTTON)), true);
	public static final Block DRAGONS_BLOOD_TRAPDOOR = create("dragons_blood_trapdoor", new TerraformTrapdoorBlock(copyOf(JUNIPER_TRAPDOOR)), true);
	public static final Block DRAGONS_BLOOD_DOOR = create("dragons_blood_door", new TerraformDoorBlock(copyOf(JUNIPER_DOOR)), false);
	public static final Block DRAGONS_BLOOD_CHEST = create("dragons_blood_chest", new BWChestBlock(copyOf(JUNIPER_CHEST), () -> BWBlockEntityTypes.BW_CHEST, false), true);
	public static final Block TRAPPED_DRAGONS_BLOOD_CHEST = create("trapped_dragons_blood_chest", new BWChestBlock(copyOf(JUNIPER_CHEST), () -> BWBlockEntityTypes.BW_CHEST, true), true);
	private static final Identifier DRAGONS_BLOOD_SIGN_TEXTURE = new Identifier(Bewitchment.MODID, "entity/sign/dragons_blood");
	public static final TerraformSignBlock DRAGONS_BLOOD_SIGN = create("dragons_blood_sign", new TerraformSignBlock(DRAGONS_BLOOD_SIGN_TEXTURE, copyOf(JUNIPER_SIGN)), false);
	public static final Block DRAGONS_BLOOD_WALL_SIGN = create("dragons_blood_wall_sign", new TerraformWallSignBlock(DRAGONS_BLOOD_SIGN_TEXTURE, copyOf(JUNIPER_WALL_SIGN)), false);
	public static final Item DRAGONS_BLOOD_DOOR_ITEM = create("dragons_blood_door", new TallBlockItem(DRAGONS_BLOOD_DOOR, gen()));
	public static final Item DRAGONS_BLOOD_SIGN_ITEM = create("dragons_blood_sign", new SignItem(gen().maxCount(16), DRAGONS_BLOOD_SIGN, DRAGONS_BLOOD_WALL_SIGN));
	public static final TerraformBoatItem DRAGONS_BLOOD_BOAT = create("dragons_blood_boat", new TerraformBoatItem(() -> BWEntityTypes.DRAGONS_BLOOD_BOAT, gen().maxCount(1)));
	//misc_block
	public static final Block SPANISH_MOSS = create("spanish_moss", new VineBlock(copyOf(Blocks.VINE)), true);
	public static final Block HEDGEWITCH_WOOL = create("hedgewitch_wool", new Block(copyOf(Blocks.WHITE_WOOL)), true);
	public static final Block ALCHEMIST_WOOL = create("alchemist_wool", new Block(copyOf(HEDGEWITCH_WOOL)), true);
	public static final Block BESMIRCHED_WOOL = create("besmirched_wool", new Block(copyOf(HEDGEWITCH_WOOL)), true);
	public static final Block HEDGEWITCH_CARPET = create("hedgewitch_carpet", new BWCarpetBlock(DyeColor.GREEN, copyOf(Blocks.WHITE_CARPET)), true);
	public static final Block ALCHEMIST_CARPET = create("alchemist_carpet", new BWCarpetBlock(DyeColor.LIGHT_GRAY, copyOf(HEDGEWITCH_CARPET)), true);
	public static final Block BESMIRCHED_CARPET = create("besmirched_carpet", new BWCarpetBlock(DyeColor.BLACK, copyOf(HEDGEWITCH_CARPET)), true);
	//material_block
	public static final Block SILVER_BLOCK = create("silver_block", new Block(copyOf(Blocks.GOLD_BLOCK)), true);
	public static final Block SALT_BLOCK = create("salt_block", new Block(copyOf(Blocks.COAL_BLOCK)), true);
	public static final Block DRAGONS_BLOOD_RESIN_BLOCK = create("dragons_blood_resin_block", new Block(copyOf(Blocks.NETHER_WART_BLOCK)), true);
	public static final Block SILVER_ORE = create("silver_ore", new Block(copyOf(Blocks.GOLD_ORE)), true);
	public static final Block SALT_ORE = create("salt_ore", new BWOreBlock(copyOf(Blocks.COAL_ORE)), true);
	//armor
	public static final Item SILVER_HELMET = create("silver_helmet", new ArmorItem(BWMaterials.SILVER_ARMOR, EquipmentSlot.HEAD, gen()));
	public static final Item SILVER_CHESTPLATE = create("silver_chestplate", new ArmorItem(BWMaterials.SILVER_ARMOR, EquipmentSlot.CHEST, gen()));
	public static final Item SILVER_LEGGINGS = create("silver_leggings", new ArmorItem(BWMaterials.SILVER_ARMOR, EquipmentSlot.LEGS, gen()));
	public static final Item SILVER_BOOTS = create("silver_boots", new ArmorItem(BWMaterials.SILVER_ARMOR, EquipmentSlot.FEET, gen()));
	//tool
	public static final Item SILVER_SWORD = create("silver_sword", new SwordItem(BWMaterials.SILVER_TOOL, 3, -2.4f, gen()));
	public static final Item SILVER_PICKAXE = create("silver_pickaxe", new BWPickaxeItem(BWMaterials.SILVER_TOOL, 1, -2.8f, gen()));
	public static final Item SILVER_AXE = create("silver_axe", new BWAxeItem(BWMaterials.SILVER_TOOL, 6, -3, gen()));
	public static final Item SILVER_SHOVEL = create("silver_shovel", new ShovelItem(BWMaterials.SILVER_TOOL, 1.5f, -2.8f, gen()));
	public static final Item SILVER_HOE = create("silver_hoe", new BWHoeItem(BWMaterials.SILVER_TOOL, -2, -3, gen()));
	public static final Item ATHAME = create("athame", new AthameItem(BWMaterials.SILVER_TOOL, 1, -2, gen()));
	public static final Item SILVER_ARROW = create("silver_arrow", new SilverArrowItem(gen()));
	//material_item
	public static final Item SILVER_INGOT = create("silver_ingot", new Item(gen()));
	public static final Item SILVER_NUGGET = create("silver_nugget", new Item(gen()));
	public static final Item SALT = create("salt", new AliasedBlockItem(SALT_LINE, gen()));
	public static final Item ACONITE = create("aconite", new Item(gen()));
	public static final Item ACONITE_SEEDS = create("aconite_seeds", new AliasedBlockItem(ACONITE_CROP, gen()));
	public static final Item BELLADONNA = create("belladonna", new Item(gen()));
	public static final Item BELLADONNA_SEEDS = create("belladonna_seeds", new AliasedBlockItem(BELLADONNA_CROP, gen()));
	public static final Item GARLIC = create("garlic", new AliasedBlockItem(GARLIC_CROP, gen().food(FoodComponents.CARROT)));
	public static final Item MANDRAKE_ROOT = create("mandrake_root", new Item(gen()));
	public static final Item MANDRAKE_SEEDS = create("mandrake_seeds", new AliasedBlockItem(MANDRAKE_CROP, gen()));
	public static final Item OAK_BARK = create("oak_bark", new Item(gen()));
	public static final Item SPRUCE_BARK = create("spruce_bark", new Item(gen()));
	public static final Item BIRCH_BARK = create("birch_bark", new Item(gen()));
	public static final Item JUNIPER_BARK = create("juniper_bark", new Item(gen()));
	public static final Item CYPRESS_BARK = create("cypress_bark", new Item(gen()));
	public static final Item ELDER_BARK = create("elder_bark", new Item(gen()));
	public static final Item WOOD_ASH = create("wood_ash", new Item(gen()));
	public static final Item DRAGONS_BLOOD_RESIN = create("dragons_blood_resin", new Item(gen()));
	public static final Item GRILLED_GARLIC = create("grilled_garlic", new Item(gen().food(FoodComponents.BAKED_POTATO)));
	public static final Item GARLIC_BREAD = create("garlic_bread", new Item(gen().food(FoodComponents.PUMPKIN_PIE)));
	
	private static <T extends Block> T create(String name, T block, boolean createItem) {
		BLOCKS.put(block, new Identifier(Bewitchment.MODID, name));
		if (createItem) {
			ITEMS.put(new BlockItem(block, gen()), BLOCKS.get(block));
		}
		return block;
	}
	
	private static <T extends Item> T create(String name, T item) {
		ITEMS.put(item, new Identifier(Bewitchment.MODID, name));
		return item;
	}
	
	private static Item.Settings gen() {
		return new Item.Settings().group(Bewitchment.BEWITCHMENT_GROUP);
	}
	
	public static void init() {
		BLOCKS.keySet().forEach(block -> Registry.register(Registry.BLOCK, BLOCKS.get(block), block));
		ITEMS.keySet().forEach(item -> Registry.register(Registry.ITEM, ITEMS.get(item), item));
		FuelRegistry fuelRegistry = FuelRegistry.INSTANCE;
		fuelRegistry.add(JUNIPER_FENCE, 300);
		fuelRegistry.add(JUNIPER_FENCE_GATE, 300);
		fuelRegistry.add(CYPRESS_FENCE, 300);
		fuelRegistry.add(CYPRESS_FENCE_GATE, 300);
		fuelRegistry.add(ELDER_FENCE, 300);
		fuelRegistry.add(ELDER_FENCE_GATE, 300);
		fuelRegistry.add(DRAGONS_BLOOD_FENCE, 300);
		fuelRegistry.add(DRAGONS_BLOOD_FENCE_GATE, 300);
		fuelRegistry.add(BWTags.BARKS, 100);
		FlammableBlockRegistry flammableRegistry = FlammableBlockRegistry.getDefaultInstance();
		flammableRegistry.add(STRIPPED_JUNIPER_LOG, 5, 5);
		flammableRegistry.add(STRIPPED_JUNIPER_WOOD, 5, 5);
		flammableRegistry.add(JUNIPER_LOG, 5, 5);
		flammableRegistry.add(JUNIPER_WOOD, 5, 5);
		flammableRegistry.add(JUNIPER_LEAVES, 30, 60);
		flammableRegistry.add(JUNIPER_PLANKS, 5, 20);
		flammableRegistry.add(JUNIPER_STAIRS, 5, 20);
		flammableRegistry.add(JUNIPER_SLAB, 5, 20);
		flammableRegistry.add(JUNIPER_FENCE, 5, 20);
		flammableRegistry.add(JUNIPER_FENCE_GATE, 5, 20);
		flammableRegistry.add(STRIPPED_CYPRESS_LOG, 5, 5);
		flammableRegistry.add(STRIPPED_CYPRESS_WOOD, 5, 5);
		flammableRegistry.add(CYPRESS_LOG, 5, 5);
		flammableRegistry.add(CYPRESS_WOOD, 5, 5);
		flammableRegistry.add(CYPRESS_LEAVES, 30, 60);
		flammableRegistry.add(CYPRESS_PLANKS, 5, 20);
		flammableRegistry.add(CYPRESS_STAIRS, 5, 20);
		flammableRegistry.add(CYPRESS_SLAB, 5, 20);
		flammableRegistry.add(CYPRESS_FENCE, 5, 20);
		flammableRegistry.add(CYPRESS_FENCE_GATE, 5, 20);
		flammableRegistry.add(STRIPPED_ELDER_LOG, 5, 5);
		flammableRegistry.add(STRIPPED_ELDER_WOOD, 5, 5);
		flammableRegistry.add(ELDER_LOG, 5, 5);
		flammableRegistry.add(ELDER_WOOD, 5, 5);
		flammableRegistry.add(ELDER_LEAVES, 30, 60);
		flammableRegistry.add(ELDER_PLANKS, 5, 20);
		flammableRegistry.add(ELDER_STAIRS, 5, 20);
		flammableRegistry.add(ELDER_SLAB, 5, 20);
		flammableRegistry.add(ELDER_FENCE, 5, 20);
		flammableRegistry.add(ELDER_FENCE_GATE, 5, 20);
		flammableRegistry.add(STRIPPED_DRAGONS_BLOOD_LOG, 5, 5);
		flammableRegistry.add(STRIPPED_DRAGONS_BLOOD_WOOD, 5, 5);
		flammableRegistry.add(DRAGONS_BLOOD_LOG, 5, 5);
		flammableRegistry.add(DRAGONS_BLOOD_WOOD, 5, 5);
		flammableRegistry.add(DRAGONS_BLOOD_LEAVES, 30, 60);
		flammableRegistry.add(DRAGONS_BLOOD_PLANKS, 5, 20);
		flammableRegistry.add(DRAGONS_BLOOD_STAIRS, 5, 20);
		flammableRegistry.add(DRAGONS_BLOOD_SLAB, 5, 20);
		flammableRegistry.add(DRAGONS_BLOOD_FENCE, 5, 20);
		flammableRegistry.add(DRAGONS_BLOOD_FENCE_GATE, 5, 20);
		flammableRegistry.add(SPANISH_MOSS, 15, 100);
		flammableRegistry.add(HEDGEWITCH_WOOL, 30, 60);
		flammableRegistry.add(ALCHEMIST_WOOL, 30, 60);
		flammableRegistry.add(BESMIRCHED_WOOL, 30, 60);
		flammableRegistry.add(HEDGEWITCH_CARPET, 60, 20);
		flammableRegistry.add(ALCHEMIST_CARPET, 60, 20);
		flammableRegistry.add(BESMIRCHED_CARPET, 60, 20);
		CompostingChanceRegistry compostRegistry = CompostingChanceRegistry.INSTANCE;
		compostRegistry.add(JUNIPER_LEAVES, 0.3f);
		compostRegistry.add(JUNIPER_SAPLING, 0.3f);
		compostRegistry.add(CYPRESS_LEAVES, 0.3f);
		compostRegistry.add(CYPRESS_SAPLING, 0.3f);
		compostRegistry.add(ELDER_LEAVES, 0.3f);
		compostRegistry.add(ELDER_SAPLING, 0.3f);
		compostRegistry.add(DRAGONS_BLOOD_LEAVES, 0.3f);
		compostRegistry.add(DRAGONS_BLOOD_SAPLING, 0.3f);
		compostRegistry.add(SPANISH_MOSS, 0.5f);
	}
}