package net.alminoris.aestheticsurfaces.datagen;

import net.alminoris.aestheticsurfaces.AestheticSurfaces;
import net.alminoris.aestheticsurfaces.block.ModBlocks;
import net.alminoris.aestheticsurfaces.item.ModItemGroups;
import net.alminoris.aestheticsurfaces.util.ModTags;
import net.alminoris.aestheticsurfaces.util.helper.BlockSetsHelper;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider
{
    public ModItemTagProvider(DataGenerator p_126530_, BlockTagsProvider p_126531_, @Nullable ExistingFileHelper existingFileHelper)
    {
        super(p_126530_, p_126531_, AestheticSurfaces.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags()
    {
        for(String name : BlockSetsHelper.getWoods())
            for (String typeName : ModItemGroups.PARQUET_TYPES)
                tag(ModTags.Items.PARQUET_CARPETS)
                        .add(ModBlocks.PARQUET_CARPETS.get(name+"_"+typeName).get().asItem());
    }
}