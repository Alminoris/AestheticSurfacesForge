package net.alminoris.aestheticsurfaces.datagen;

import net.alminoris.aestheticsurfaces.block.ModBlocks;
import net.alminoris.aestheticsurfaces.item.ModItemGroups;
import net.alminoris.aestheticsurfaces.util.helper.BlockSetsHelper;
import net.alminoris.aestheticsurfaces.util.helper.ModJsonHelper;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder
{
    public ModRecipeProvider(DataGenerator pOutput)
    {
        super(pOutput);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> recipeExporter)
    {
        for(String name : BlockSetsHelper.WOODS)
        {
            Block block = ForgeRegistries.BLOCKS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", name+"_planks"));

            for (String typeName : ModItemGroups.PARQUET_TYPES)
            {
                stonecutterResultFromBase(recipeExporter, ModBlocks.PARQUET_CARPETS.get(name+"_"+typeName).get(), block, 3);
            }
        }

        stonecutterResultFromBase(recipeExporter, ModBlocks.SLIM_CEILINGS.get("smooth").get(), Blocks.SMOOTH_QUARTZ_SLAB, 2);
        stonecutterResultFromBase(recipeExporter, ModBlocks.SLIM_CEILINGS.get("tiles").get(), ModBlocks.SLIM_CEILINGS.get("smooth").get(), 1);
        stonecutterResultFromBase(recipeExporter, ModBlocks.SLIM_CEILINGS.get("small_tiles").get(), ModBlocks.SLIM_CEILINGS.get("tiles").get(), 1);
        stonecutterResultFromBase(recipeExporter, ModBlocks.SLIM_CEILINGS.get("tiny_tiles").get(), ModBlocks.SLIM_CEILINGS.get("small_tiles").get(), 1);
        stonecutterResultFromBase(recipeExporter, ModBlocks.SLIM_CEILINGS.get("concrete").get(), Blocks.LIGHT_GRAY_CONCRETE, 4);
        ShapelessRecipeBuilder.shapeless(ModBlocks.SLIM_CEILINGS.get("gypsum").get())
                .requires(Items.BONE_MEAL)
                .requires(Blocks.SAND)
                .requires(Items.WATER_BUCKET)
                .unlockedBy(getHasName(Items.BONE_MEAL), has(Items.BONE_MEAL))
                .unlockedBy(getHasName(Blocks.SAND), has(Blocks.SAND))
                .unlockedBy(getHasName(Items.WATER_BUCKET), has(Items.WATER_BUCKET))
                .save(recipeExporter);
        stonecutterResultFromBase(recipeExporter, ModBlocks.SLIM_CEILINGS.get("popcorn").get(), Blocks.DIORITE_SLAB, 2);

        for (String name : ModItemGroups.BRICKS_NAMES)
        {
            Block block = ForgeRegistries.BLOCKS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", name));
            stonecutterResultFromBase(recipeExporter, ModBlocks.BRICKS_VENEERS.get(name).get(), block, 3);
        }

        for (String name : BlockSetsHelper.COLORS)
        {
            stonecutterResultFromBase(recipeExporter, ModBlocks.COFFERED_CEILINGS.get(name).get(),
                    ForgeRegistries.BLOCKS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", name+"_concrete")), 2);
        }

        stonecutterResultFromBase(recipeExporter, ModBlocks.SMOOTH_STONE_ROAD.get(), Blocks.SMOOTH_STONE, 1);

        for(String name : ModItemGroups.AN_WOOD_NAMES)
        {
            for (String typeName : ModItemGroups.PARQUET_TYPES)
            {
                ModJsonHelper.createStonecuttingRecipe("arborealnature:"+name+"_planks",
                        ForgeRegistries.BLOCKS.getKey(ModBlocks.PARQUET_CARPETS.get(name+"_"+typeName).get()).getPath(), "3");
                ModJsonHelper.createStonecuttingRecipe("arborealnature:"+name+"_planks",
                        ForgeRegistries.BLOCKS.getKey(ModBlocks.PARQUET_BLOCKS.get(name+"_"+typeName).get()).getPath(), "1");
            }
        }

        for(String name : ModItemGroups.WF_WOOD_NAMES)
        {
            for (String typeName : ModItemGroups.PARQUET_TYPES)
            {
                ModJsonHelper.createStonecuttingRecipe("wildfields:"+name+"_planks",
                        ForgeRegistries.BLOCKS.getKey(ModBlocks.PARQUET_CARPETS.get(name+"_"+typeName).get()).getPath(), "3");
                ModJsonHelper.createStonecuttingRecipe("wildfields:"+name+"_planks",
                        ForgeRegistries.BLOCKS.getKey(ModBlocks.PARQUET_BLOCKS.get(name+"_"+typeName).get()).getPath(), "1");
            }
        }

        for(String name : ModItemGroups.WT_WOOD_NAMES)
        {
            for (String typeName : ModItemGroups.PARQUET_TYPES)
            {
                ModJsonHelper.createStonecuttingRecipe("whisperleaftrees:"+name+"_planks",
                        ForgeRegistries.BLOCKS.getKey(ModBlocks.PARQUET_CARPETS.get(name+"_"+typeName).get()).getPath(), "3");
                ModJsonHelper.createStonecuttingRecipe("whisperleaftrees:"+name+"_planks",
                        ForgeRegistries.BLOCKS.getKey(ModBlocks.PARQUET_BLOCKS.get(name+"_"+typeName).get()).getPath(), "1");
            }
        }

        for(String name : ModItemGroups.ST_WOOD_NAMES)
        {
            for (String typeName : ModItemGroups.PARQUET_TYPES)
            {
                ModJsonHelper.createStonecuttingRecipe("silverwoodtrees:"+name+"_planks",
                        ForgeRegistries.BLOCKS.getKey(ModBlocks.PARQUET_CARPETS.get(name+"_"+typeName).get()).getPath(), "3");
                ModJsonHelper.createStonecuttingRecipe("silverwoodtrees:"+name+"_planks",
                        ForgeRegistries.BLOCKS.getKey(ModBlocks.PARQUET_BLOCKS.get(name+"_"+typeName).get()).getPath(), "1");
            }
        }

        for(String name : ModItemGroups.MT_WOOD_NAMES)
        {
            for (String typeName : ModItemGroups.PARQUET_TYPES)
            {
                ModJsonHelper.createStonecuttingRecipe("missingtrees:"+name+"_planks",
                        ForgeRegistries.BLOCKS.getKey(ModBlocks.PARQUET_CARPETS.get(name+"_"+typeName).get()).getPath(), "3");
                ModJsonHelper.createStonecuttingRecipe("missingtrees:"+name+"_planks",
                        ForgeRegistries.BLOCKS.getKey(ModBlocks.PARQUET_BLOCKS.get(name+"_"+typeName).get()).getPath(), "1");
            }
        }

        for(String name : ModItemGroups.NSS_WOOD_NAMES)
        {
            for (String typeName : ModItemGroups.PARQUET_TYPES)
            {
                ModJsonHelper.createStonecuttingRecipe("natures_spirit:"+name.replace("_nss", "")+"_planks",
                        ForgeRegistries.BLOCKS.getKey(ModBlocks.PARQUET_CARPETS.get(name+"_"+typeName).get()).getPath(), "3");
                ModJsonHelper.createStonecuttingRecipe("natures_spirit:"+name.replace("_nss", "")+"_planks",
                        ForgeRegistries.BLOCKS.getKey(ModBlocks.PARQUET_BLOCKS.get(name+"_"+typeName).get()).getPath(), "1");
            }
        }

        ShapedRecipeBuilder.shaped(ModBlocks.TRANSITIONAL_CARPET_BLOCKS.get("black").get(), 4)
                .pattern("##")
                .pattern("**")
                .define('#', Blocks.WHITE_WOOL)
                .define('*', Blocks.BLACK_WOOL)
                .unlockedBy(getHasName(Blocks.WHITE_WOOL), has(Blocks.WHITE_WOOL))
                .unlockedBy(getHasName(Blocks.BLACK_WOOL), has(Blocks.BLACK_WOOL))
                .save(recipeExporter);

        ShapedRecipeBuilder.shaped(ModBlocks.TRANSITIONAL_CARPET_BLOCKS.get("blue").get(), 4)
                .pattern("##")
                .pattern("**")
                .define('#', Blocks.LIME_WOOL)
                .define('*', Blocks.BLUE_WOOL)
                .unlockedBy(getHasName(Blocks.LIME_WOOL), has(Blocks.LIME_WOOL))
                .unlockedBy(getHasName(Blocks.BLUE_WOOL), has(Blocks.BLUE_WOOL))
                .save(recipeExporter);

        ShapedRecipeBuilder.shaped(ModBlocks.TRANSITIONAL_CARPET_BLOCKS.get("brown").get(), 4)
                .pattern("##")
                .pattern("**")
                .define('#', Blocks.BLACK_WOOL)
                .define('*', Blocks.BROWN_WOOL)
                .unlockedBy(getHasName(Blocks.BLACK_WOOL), has(Blocks.BLACK_WOOL))
                .unlockedBy(getHasName(Blocks.BROWN_WOOL), has(Blocks.BROWN_WOOL))
                .save(recipeExporter);

        ShapedRecipeBuilder.shaped(ModBlocks.TRANSITIONAL_CARPET_BLOCKS.get("cyan").get(), 4)
                .pattern("##")
                .pattern("**")
                .define('#', Blocks.PURPLE_WOOL)
                .define('*', Blocks.CYAN_WOOL)
                .unlockedBy(getHasName(Blocks.PURPLE_WOOL), has(Blocks.PURPLE_WOOL))
                .unlockedBy(getHasName(Blocks.CYAN_WOOL), has(Blocks.CYAN_WOOL))
                .save(recipeExporter);

        ShapedRecipeBuilder.shaped(ModBlocks.TRANSITIONAL_CARPET_BLOCKS.get("gray").get(), 4)
                .pattern("##")
                .pattern("**")
                .define('#', Blocks.GREEN_WOOL)
                .define('*', Blocks.GRAY_WOOL)
                .unlockedBy(getHasName(Blocks.GREEN_WOOL), has(Blocks.GREEN_WOOL))
                .unlockedBy(getHasName(Blocks.GRAY_WOOL), has(Blocks.GRAY_WOOL))
                .save(recipeExporter);

        ShapedRecipeBuilder.shaped(ModBlocks.TRANSITIONAL_CARPET_BLOCKS.get("green").get(), 4)
                .pattern("##")
                .pattern("**")
                .define('#', Blocks.BROWN_WOOL)
                .define('*', Blocks.GREEN_WOOL)
                .unlockedBy(getHasName(Blocks.BROWN_WOOL), has(Blocks.BROWN_WOOL))
                .unlockedBy(getHasName(Blocks.GREEN_WOOL), has(Blocks.GREEN_WOOL))
                .save(recipeExporter);

        ShapedRecipeBuilder.shaped(ModBlocks.TRANSITIONAL_CARPET_BLOCKS.get("light_blue").get(), 4)
                .pattern("##")
                .pattern("**")
                .define('#', Blocks.CYAN_WOOL)
                .define('*', Blocks.LIGHT_BLUE_WOOL)
                .unlockedBy(getHasName(Blocks.CYAN_WOOL), has(Blocks.CYAN_WOOL))
                .unlockedBy(getHasName(Blocks.LIGHT_BLUE_WOOL), has(Blocks.LIGHT_BLUE_WOOL))
                .save(recipeExporter);

        ShapedRecipeBuilder.shaped(ModBlocks.TRANSITIONAL_CARPET_BLOCKS.get("light_gray").get(), 4)
                .pattern("##")
                .pattern("**")
                .define('#', Blocks.GRAY_WOOL)
                .define('*', Blocks.LIGHT_GRAY_WOOL)
                .unlockedBy(getHasName(Blocks.GRAY_WOOL), has(Blocks.GRAY_WOOL))
                .unlockedBy(getHasName(Blocks.LIGHT_GRAY_WOOL), has(Blocks.LIGHT_GRAY_WOOL))
                .save(recipeExporter);

        ShapedRecipeBuilder.shaped(ModBlocks.TRANSITIONAL_CARPET_BLOCKS.get("lime").get(), 4)
                .pattern("##")
                .pattern("**")
                .define('#', Blocks.LIGHT_BLUE_WOOL)
                .define('*', Blocks.LIME_WOOL)
                .unlockedBy(getHasName(Blocks.LIGHT_BLUE_WOOL), has(Blocks.LIGHT_BLUE_WOOL))
                .unlockedBy(getHasName(Blocks.LIME_WOOL), has(Blocks.LIME_WOOL))
                .save(recipeExporter);

        ShapedRecipeBuilder.shaped(ModBlocks.TRANSITIONAL_CARPET_BLOCKS.get("magenta").get(), 4)
                .pattern("##")
                .pattern("**")
                .define('#', Blocks.RED_WOOL)
                .define('*', Blocks.MAGENTA_WOOL)
                .unlockedBy(getHasName(Blocks.RED_WOOL), has(Blocks.RED_WOOL))
                .unlockedBy(getHasName(Blocks.MAGENTA_WOOL), has(Blocks.MAGENTA_WOOL))
                .save(recipeExporter);

        ShapedRecipeBuilder.shaped(ModBlocks.TRANSITIONAL_CARPET_BLOCKS.get("orange").get(), 4)
                .pattern("##")
                .pattern("**")
                .define('#', Blocks.YELLOW_WOOL)
                .define('*', Blocks.ORANGE_WOOL)
                .unlockedBy(getHasName(Blocks.YELLOW_WOOL), has(Blocks.YELLOW_WOOL))
                .unlockedBy(getHasName(Blocks.ORANGE_WOOL), has(Blocks.ORANGE_WOOL))
                .save(recipeExporter);

        ShapedRecipeBuilder.shaped(ModBlocks.TRANSITIONAL_CARPET_BLOCKS.get("pink").get(), 4)
                .pattern("##")
                .pattern("**")
                .define('#', Blocks.MAGENTA_WOOL)
                .define('*', Blocks.PINK_WOOL)
                .unlockedBy(getHasName(Blocks.MAGENTA_WOOL), has(Blocks.MAGENTA_WOOL))
                .unlockedBy(getHasName(Blocks.PINK_WOOL), has(Blocks.PINK_WOOL))
                .save(recipeExporter);

        ShapedRecipeBuilder.shaped(ModBlocks.TRANSITIONAL_CARPET_BLOCKS.get("purple").get(), 4)
                .pattern("##")
                .pattern("**")
                .define('#', Blocks.PINK_WOOL)
                .define('*', Blocks.PURPLE_WOOL)
                .unlockedBy(getHasName(Blocks.PINK_WOOL), has(Blocks.PINK_WOOL))
                .unlockedBy(getHasName(Blocks.PURPLE_WOOL), has(Blocks.PURPLE_WOOL))
                .save(recipeExporter);

        ShapedRecipeBuilder.shaped(ModBlocks.TRANSITIONAL_CARPET_BLOCKS.get("red").get(), 4)
                .pattern("##")
                .pattern("**")
                .define('#', Blocks.ORANGE_WOOL)
                .define('*', Blocks.RED_WOOL)
                .unlockedBy(getHasName(Blocks.ORANGE_WOOL), has(Blocks.ORANGE_WOOL))
                .unlockedBy(getHasName(Blocks.RED_WOOL), has(Blocks.RED_WOOL))
                .save(recipeExporter);

        ShapedRecipeBuilder.shaped(ModBlocks.TRANSITIONAL_CARPET_BLOCKS.get("white").get(), 4)
                .pattern("##")
                .pattern("**")
                .define('#', Blocks.LIGHT_GRAY_WOOL)
                .define('*', Blocks.WHITE_WOOL)
                .unlockedBy(getHasName(Blocks.LIGHT_GRAY_WOOL), has(Blocks.LIGHT_GRAY_WOOL))
                .unlockedBy(getHasName(Blocks.WHITE_WOOL), has(Blocks.WHITE_WOOL))
                .save(recipeExporter);

        ShapedRecipeBuilder.shaped(ModBlocks.TRANSITIONAL_CARPET_BLOCKS.get("yellow").get(), 4)
                .pattern("##")
                .pattern("**")
                .define('#', Blocks.BLUE_WOOL)
                .define('*', Blocks.YELLOW_WOOL)
                .unlockedBy(getHasName(Blocks.BLUE_WOOL), has(Blocks.BLUE_WOOL))
                .unlockedBy(getHasName(Blocks.YELLOW_WOOL), has(Blocks.YELLOW_WOOL))
                .save(recipeExporter);

        for(String name : BlockSetsHelper.COLORS)
        {
            ShapedRecipeBuilder.shaped(ModBlocks.SIMPLE_CARPETS.get(name).get(), 4)
                    .pattern("##")
                    .define('#', ModBlocks.SIMPLE_CARPET_BLOCKS.get(name).get())
                    .unlockedBy(getHasName(ModBlocks.SIMPLE_CARPET_BLOCKS.get(name).get()), has(ModBlocks.SIMPLE_CARPET_BLOCKS.get(name).get()))
                    .save(recipeExporter);

            ShapedRecipeBuilder.shaped(ModBlocks.SMOOTH_CARPETS.get(name).get(), 4)
                    .pattern("##")
                    .define('#', ModBlocks.SMOOTH_CARPET_BLOCKS.get(name).get())
                    .unlockedBy(getHasName(ModBlocks.SMOOTH_CARPET_BLOCKS.get(name).get()), has(ModBlocks.SMOOTH_CARPET_BLOCKS.get(name).get()))
                    .save(recipeExporter);

            ShapedRecipeBuilder.shaped(ModBlocks.SMOOTH_CARPET_BLOCKS.get(name).get(), 4)
                    .pattern("##")
                    .pattern("##")
                    .define('#', ForgeRegistries.BLOCKS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", name+"_wool")))
                    .unlockedBy(getHasName(ForgeRegistries.BLOCKS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", name+"_wool"))),
                            has(ForgeRegistries.BLOCKS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", name+"_wool"))))
                    .save(recipeExporter);

            ShapedRecipeBuilder.shaped(ModBlocks.SIMPLE_CARPET_BLOCKS.get(name).get(), 1)
                    .pattern("RGB")
                    .pattern(" # ")
                    .define('R', Items.RED_DYE)
                    .define('G', Items.GREEN_DYE)
                    .define('B', Items.BLUE_DYE)
                    .define('#', ForgeRegistries.BLOCKS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", name+"_wool")))
                    .unlockedBy(getHasName(ForgeRegistries.BLOCKS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", name+"_wool"))),
                            has(ForgeRegistries.BLOCKS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", name+"_wool"))))
                    .save(recipeExporter);

            ShapedRecipeBuilder.shaped(ModBlocks.TRANSITIONAL_CARPETS.get(name).get(), 4)
                    .pattern("##")
                    .define('#', ModBlocks.TRANSITIONAL_CARPET_BLOCKS.get(name).get())
                    .unlockedBy(getHasName(ModBlocks.TRANSITIONAL_CARPET_BLOCKS.get(name).get()), has(ModBlocks.TRANSITIONAL_CARPET_BLOCKS.get(name).get()))
                    .save(recipeExporter);

            ShapedRecipeBuilder.shaped(ModBlocks.SIMPLE_WALLPAPERS.get(name).get(), 4)
                    .pattern("#")
                    .pattern("#")
                    .define('#', ModBlocks.SIMPLE_CARPET_BLOCKS.get(name).get())
                    .unlockedBy(getHasName(ModBlocks.SIMPLE_CARPET_BLOCKS.get(name).get()), has(ModBlocks.SIMPLE_CARPET_BLOCKS.get(name).get()))
                    .save(recipeExporter);

            ShapedRecipeBuilder.shaped(ModBlocks.SMOOTH_WALLPAPERS.get(name).get(), 4)
                    .pattern("#")
                    .pattern("#")
                    .define('#', ModBlocks.SMOOTH_CARPET_BLOCKS.get(name).get())
                    .unlockedBy(getHasName(ModBlocks.SMOOTH_CARPET_BLOCKS.get(name).get()), has(ModBlocks.SMOOTH_CARPET_BLOCKS.get(name).get()))
                    .save(recipeExporter);

            ShapedRecipeBuilder.shaped(ModBlocks.TRANSITIONAL_WALLPAPERS.get(name).get(), 4)
                    .pattern("#")
                    .pattern("#")
                    .define('#', ModBlocks.TRANSITIONAL_CARPET_BLOCKS.get(name).get())
                    .unlockedBy(getHasName(ModBlocks.TRANSITIONAL_CARPET_BLOCKS.get(name).get()), has(ModBlocks.TRANSITIONAL_CARPET_BLOCKS.get(name).get()))
                    .save(recipeExporter);

            ShapedRecipeBuilder.shaped(ModBlocks.WALLPAPERS.get(name).get(), 4)
                    .pattern("#")
                    .pattern("#")
                    .define('#', ForgeRegistries.BLOCKS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", name+"_wool")))
                    .unlockedBy(getHasName(ForgeRegistries.BLOCKS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", name+"_wool"))),
                            has(ForgeRegistries.BLOCKS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", name+"_wool"))))
                    .save(recipeExporter);
        }
    }
}