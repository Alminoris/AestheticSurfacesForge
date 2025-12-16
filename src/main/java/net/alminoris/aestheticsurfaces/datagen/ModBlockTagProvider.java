package net.alminoris.aestheticsurfaces.datagen;

import net.alminoris.aestheticsurfaces.AestheticSurfaces;
import net.alminoris.aestheticsurfaces.block.ModBlocks;
import net.alminoris.aestheticsurfaces.util.ModTags;
import net.alminoris.aestheticsurfaces.util.helper.BlockSetsHelper;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

import static net.alminoris.aestheticsurfaces.util.helper.BlockSetsHelper.COLORS;

public class ModBlockTagProvider extends BlockTagsProvider
{
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper)
    {
        super(output, lookupProvider, AestheticSurfaces.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider)
    {
        for (String name : COLORS)
        {
            tag(BlockTags.WOOL)
                    .add(ModBlocks.SIMPLE_CARPET_BLOCKS.get(name).get())
                    .add(ModBlocks.SMOOTH_CARPET_BLOCKS.get(name).get())
                    .add(ModBlocks.TRANSITIONAL_CARPET_BLOCKS.get(name).get());

            tag(BlockTags.WOOL_CARPETS)
                    .add(ModBlocks.SIMPLE_CARPETS.get(name).get())
                    .add(ModBlocks.SMOOTH_CARPETS.get(name).get())
                    .add(ModBlocks.TRANSITIONAL_CARPETS.get(name).get());
        }

        for(String name : BlockSetsHelper.getWoods())
            for (String typeName : BlockSetsHelper.PARQUET_TYPES)
                tag(ModTags.Blocks.PARQUET_CARPETS)
                        .add(ModBlocks.PARQUET_CARPETS.get(name+"_"+typeName).get());
    }
}