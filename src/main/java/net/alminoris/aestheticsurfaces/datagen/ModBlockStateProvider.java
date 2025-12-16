package net.alminoris.aestheticsurfaces.datagen;

import net.alminoris.aestheticsurfaces.AestheticSurfaces;
import net.alminoris.aestheticsurfaces.block.ModBlocks;
import net.alminoris.aestheticsurfaces.util.helper.BlockSetsHelper;
import net.alminoris.aestheticsurfaces.util.helper.ModJsonHelper;
import net.alminoris.aestheticsurfaces.util.helper.ModJsonTemplates;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Dictionary;
import java.util.Hashtable;

public class ModBlockStateProvider extends BlockStateProvider
{
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper)
    {
        super(output, AestheticSurfaces.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels()
    {
        for(String name : BlockSetsHelper.COLORS)
        {
            registerWallpaper(ModBlocks.WALLPAPERS.get(name), name);
            registerWoolCarpetAndWallpaper(ModBlocks.SIMPLE_CARPET_BLOCKS.get(name), ModBlocks.SIMPLE_CARPETS.get(name), ModBlocks.SIMPLE_WALLPAPERS.get(name));
            registerWoolCarpetAndWallpaper(ModBlocks.SMOOTH_CARPET_BLOCKS.get(name), ModBlocks.SMOOTH_CARPETS.get(name), ModBlocks.SMOOTH_WALLPAPERS.get(name));
            registerWoolCarpetAndWallpaper(ModBlocks.TRANSITIONAL_CARPET_BLOCKS.get(name), ModBlocks.TRANSITIONAL_CARPETS.get(name), ModBlocks.TRANSITIONAL_WALLPAPERS.get(name));
            registerCofferedCeilingBlock(ModBlocks.COFFERED_CEILINGS.get(name), name);
        }

        for(String name : BlockSetsHelper.CEILING_TYPES)
        {
            registerSlimCeilingBlock(ModBlocks.SLIM_CEILINGS.get(name), name);
        }

        for(String name : BlockSetsHelper.BRICKS_NAMES)
        {
            registerBricksVeneerBlock(ModBlocks.BRICKS_VENEERS.get(name), name);
        }

        for(String name : BlockSetsHelper.getWoods())
            for (String typeName : BlockSetsHelper.PARQUET_TYPES)
                registerCarpetAndParquetBlock(ModBlocks.PARQUET_BLOCKS.get(name+"_"+typeName), ModBlocks.PARQUET_CARPETS.get(name+"_"+typeName));

        registerPathBlock(ModBlocks.SMOOTH_STONE_ROAD, "minecraft:block/smooth_stone");
    }

    public final void registerPathBlock(RegistryObject<Block> block, String texture)
    {
        ModJsonHelper.createBlockModel(ModJsonTemplates.PATH_BLOCK_MODEL_TEMPLATE, ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), texture);
        ModJsonHelper.createSimpleBlockState(ForgeRegistries.BLOCKS.getKey(block.get()).getPath());
        blockItem(block, "block/"+ForgeRegistries.BLOCKS.getKey(block.get()).getPath());
    }

    public final void registerCofferedCeilingBlock(RegistryObject<Block> block, String color)
    {
        ModJsonHelper.createBlockModel(ModJsonTemplates.COFFERED_CEILING, ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), "minecraft:block/"+color+"_concrete");
        ModJsonHelper.createSimpleBlockState(ForgeRegistries.BLOCKS.getKey(block.get()).getPath());
        blockItem(block, "block/"+ForgeRegistries.BLOCKS.getKey(block.get()).getPath());
    }

    public final void registerSlimCeilingBlock(RegistryObject<Block> block, String type)
    {
        ModJsonHelper.createBlockModel(ModJsonTemplates.SLIM_CEILING, ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), type);
        ModJsonHelper.createSimpleBlockState(ForgeRegistries.BLOCKS.getKey(block.get()).getPath());
        blockItem(block, "block/"+ForgeRegistries.BLOCKS.getKey(block.get()).getPath());
    }

    public final void registerCarpetAndParquetBlock(RegistryObject<Block> block, RegistryObject<Block> carpet)
    {
        ModJsonHelper.createBlockModel(ModJsonTemplates.PARQUET_BLOCK_MODEL_TEMPLATE, ForgeRegistries.BLOCKS.getKey(block.get()).getPath());
        ModJsonHelper.createYAxisRotatedBlockState(ForgeRegistries.BLOCKS.getKey(block.get()).getPath());
        blockItem(block, "block/"+ForgeRegistries.BLOCKS.getKey(block.get()).getPath());

        ModJsonHelper.createBlockModel(ModJsonTemplates.CARPET_MODEL_TEMPLATE, ForgeRegistries.BLOCKS.getKey(carpet.get()).getPath());
        ModJsonHelper.createYAxisRotatedBlockState(ForgeRegistries.BLOCKS.getKey(carpet.get()).getPath());
        blockItem(carpet, "block/"+ForgeRegistries.BLOCKS.getKey(carpet.get()).getPath());
    }

    public final void registerCarpetAndBlock(RegistryObject<Block> block, RegistryObject<Block> carpet)
    {
        ModJsonHelper.createBlockModel(ModJsonTemplates.CARPET_BLOCK_MODEL_TEMPLATE, ForgeRegistries.BLOCKS.getKey(block.get()).getPath());
        ModJsonHelper.createYAxisRotatedBlockState(ForgeRegistries.BLOCKS.getKey(block.get()).getPath());
        blockItem(block, "block/"+ForgeRegistries.BLOCKS.getKey(block.get()).getPath());

        ModJsonHelper.createBlockModel(ModJsonTemplates.CARPET_MODEL_TEMPLATE, ForgeRegistries.BLOCKS.getKey(carpet.get()).getPath());
        ModJsonHelper.createYAxisRotatedBlockState(ForgeRegistries.BLOCKS.getKey(carpet.get()).getPath());
        blockItem(carpet, "block/"+ForgeRegistries.BLOCKS.getKey(carpet.get()).getPath());
    }

    public final void registerWoolCarpetAndWallpaper(RegistryObject<Block> wool, RegistryObject<Block> carpet, RegistryObject<Block>... wallpaper)
    {
        registerCarpetAndBlock(wool, carpet);

        if (wallpaper.length > 0)
        {
            ModJsonHelper.createBlockModel(ModJsonTemplates.WALLPAPER_MODEL_TEMPLATE, ForgeRegistries.BLOCKS.getKey(wallpaper[0].get()).getPath());
            ModJsonHelper.createYAxisRotatedBlockState(ForgeRegistries.BLOCKS.getKey(wallpaper[0].get()).getPath());
            blockItem(wallpaper[0], "block/"+ForgeRegistries.BLOCKS.getKey(wallpaper[0].get()).getPath());
        }
    }

    public final void registerWallpaper(RegistryObject<Block> wallpaper, String colorName)
    {
        ModJsonHelper.createWallpaperBlockModel(ModJsonTemplates.WALLPAPER_MODEL_TEMPLATE, ForgeRegistries.BLOCKS.getKey(wallpaper.get()).getPath(), colorName);
        ModJsonHelper.createYAxisRotatedBlockState(ForgeRegistries.BLOCKS.getKey(wallpaper.get()).getPath());
        blockItem(wallpaper, "block/"+ForgeRegistries.BLOCKS.getKey(wallpaper.get()).getPath());
    }

    public final void registerBricksVeneerBlock(RegistryObject<Block> block, String name)
    {
        String jsonTemplate = switch(name)
        {
            case "bricks" -> ModJsonTemplates.BRICKS_VENEER;
            case "quartz_bricks" -> ModJsonTemplates.QUARTZ_BRICKS_VENEER;
            case "mud_bricks" -> ModJsonTemplates.MUD_BRICKS_VENEER;
            case "prismarine_bricks" -> ModJsonTemplates.PRISMARINE_BRICKS_VENEER;
            case "end_stone_bricks" -> ModJsonTemplates.END_STONE_BRICKS_VENEER;
            case "nether_bricks", "red_nether_bricks" -> ModJsonTemplates.NETHER_BRICKS_VENEER;
            default -> ModJsonTemplates.STONE_BRICKS_VENEER;
        };

        ModJsonHelper.createBlockModel(jsonTemplate, ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), "minecraft:block/" + name);
        ModJsonHelper.createYAxisRotatedBlockState(ForgeRegistries.BLOCKS.getKey(block.get()).getPath());
        blockItem(block, "block/"+ForgeRegistries.BLOCKS.getKey(block.get()).getPath());
    }

    private void blockItem(RegistryObject<? extends Block> blockRegistryObject, String name)
    {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("aestheticsurfaces:" + name));
    }
}