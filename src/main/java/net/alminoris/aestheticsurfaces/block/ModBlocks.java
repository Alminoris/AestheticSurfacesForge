package net.alminoris.aestheticsurfaces.block;

import net.alminoris.aestheticsurfaces.AestheticSurfaces;
import net.alminoris.aestheticsurfaces.block.custom.*;
import net.alminoris.aestheticsurfaces.item.ModItemGroups;
import net.alminoris.aestheticsurfaces.item.ModItems;
import net.alminoris.aestheticsurfaces.util.helper.BlockSetsHelper;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.function.Supplier;

public class ModBlocks
{
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, AestheticSurfaces.MOD_ID);

    public static final RegistryObject<Block> SMOOTH_STONE_ROAD = registerBlock("smooth_stone_road", () -> new PathBlock(BlockBehaviour.Properties.copy(Blocks.SMOOTH_STONE)));

    public static final Dictionary<String, RegistryObject<Block>> PARQUET_CARPETS = new Hashtable<>()
    {{
        for(String name : BlockSetsHelper.getWoods())
        {
            for (String typeName : ModItemGroups.PARQUET_TYPES)
            {
                put(name+"_"+typeName, registerBlock(typeName+"_parquet_"+name, () -> new YAxisRotatedCarpetBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))));
            }
        }
    }};

    public static final Dictionary<String, RegistryObject<Block>> PARQUET_BLOCKS = new Hashtable<>()
    {{
        for(String name : BlockSetsHelper.getWoods())
        {
            for (String typeName : ModItemGroups.PARQUET_TYPES)
            {
                put(name+"_"+typeName, registerBlock(typeName+"_parquet_"+name+"_block", () -> new ParquetBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))));
            }
        }
    }};

    public static final Dictionary<String, RegistryObject<Block>> SLIM_CEILINGS = new Hashtable<>()
    {{
        for(String name : ModItemGroups.CEILING_TYPES)
        {
            put(name, registerBlock("slim_ceiling_"+name, () -> new SlimCeilingBlock(BlockBehaviour.Properties.copy(Blocks.STONE))));
        }
    }};

    public static final Dictionary<String, RegistryObject<Block>> COFFERED_CEILINGS = new Hashtable<>()
    {{
        for(String name : BlockSetsHelper.COLORS)
        {
            put(name, registerBlock("coffered_ceiling_"+name, () -> new CofferedCeilingBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE))));
        }
    }};

    public static final Dictionary<String, RegistryObject<Block>> BRICKS_VENEERS = new Hashtable<>()
    {{
        for(String name : ModItemGroups.BRICKS_NAMES)
        {
            put(name, registerBlock("veneer_"+name, () -> new BricksVeneerBlock(BlockBehaviour.Properties.copy(Blocks.BRICKS))));
        }
    }};

    public static final Dictionary<String, RegistryObject<Block>> SIMPLE_CARPETS = new Hashtable<>()
    {{
        for(String name : BlockSetsHelper.COLORS)
        {
            put(name, registerBlock("simple_carpet_"+name, () -> new YAxisRotatedCarpetBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL))));
        }
    }};

    public static final Dictionary<String, RegistryObject<Block>> SIMPLE_CARPET_BLOCKS = new Hashtable<>()
    {{
        for(String name : BlockSetsHelper.COLORS)
        {
            put(name, registerBlock("simple_carpet_"+name+"_block", () -> new YAxisRotatedBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL))));
        }
    }};

    public static final Dictionary<String, RegistryObject<Block>> SIMPLE_WALLPAPERS = new Hashtable<>()
    {{
        for(String name : BlockSetsHelper.COLORS)
        {
            put(name, registerBlock("simple_wallpaper_"+name, () -> new WallpaperBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL))));
        }
    }};

    public static final Dictionary<String, RegistryObject<Block>> SMOOTH_CARPETS = new Hashtable<>()
    {{
        for(String name : BlockSetsHelper.COLORS)
        {
            put(name, registerBlock("smooth_carpet_"+name, () -> new YAxisRotatedCarpetBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL))));
        }
    }};

    public static final Dictionary<String, RegistryObject<Block>> SMOOTH_WALLPAPERS = new Hashtable<>()
    {{
        for(String name : BlockSetsHelper.COLORS)
        {
            put(name, registerBlock("smooth_wallpaper_"+name, () -> new WallpaperBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL))));
        }
    }};

    public static final Dictionary<String, RegistryObject<Block>> SMOOTH_CARPET_BLOCKS = new Hashtable<>()
    {{
        for(String name : BlockSetsHelper.COLORS)
        {
            put(name, registerBlock("smooth_carpet_"+name+"_block", () -> new YAxisRotatedBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL))));
        }
    }};

    public static final Dictionary<String, RegistryObject<Block>> TRANSITIONAL_CARPETS = new Hashtable<>()
    {{
        for(String name : BlockSetsHelper.COLORS)
        {
            put(name, registerBlock("transitional_carpet_"+name, () -> new YAxisRotatedCarpetBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL))));
        }
    }};

    public static final Dictionary<String, RegistryObject<Block>> TRANSITIONAL_CARPET_BLOCKS = new Hashtable<>()
    {{
        for(String name : BlockSetsHelper.COLORS)
        {
            put(name, registerBlock("transitional_carpet_"+name+"_block", () -> new YAxisRotatedBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL))));
        }
    }};

    public static final Dictionary<String, RegistryObject<Block>> TRANSITIONAL_WALLPAPERS = new Hashtable<>()
    {{
        for(String name : BlockSetsHelper.COLORS)
        {
            put(name, registerBlock("transitional_wallpaper_"+name, () -> new WallpaperBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL))));
        }
    }};

    public static final Dictionary<String, RegistryObject<Block>> WALLPAPERS = new Hashtable<>()
    {{
        for(String name : BlockSetsHelper.COLORS)
        {
            put(name, registerBlock("wallpaper_"+name, () -> new WallpaperBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL))));
        }
    }};

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block)
    {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block)
    {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(ModItemGroups.ASURF_TAB)));
    }

    public static void register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }
}