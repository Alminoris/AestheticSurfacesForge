package net.alminoris.aestheticsurfaces.datagen;

import net.alminoris.aestheticsurfaces.block.ModBlocks;
import net.alminoris.aestheticsurfaces.util.helper.BlockSetsHelper;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider
{
    protected ModBlockLootTableProvider(HolderLookup.Provider pRegistries)
    {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), pRegistries);
    }

    @Override
    protected void generate()
    {
        for(String name : BlockSetsHelper.COLORS)
        {
            dropSelf(ModBlocks.SIMPLE_CARPETS.get(name).get());
            dropSelf(ModBlocks.SIMPLE_CARPET_BLOCKS.get(name).get());
            dropSelf(ModBlocks.SMOOTH_CARPETS.get(name).get());
            dropSelf(ModBlocks.SMOOTH_CARPET_BLOCKS.get(name).get());
            dropSelf(ModBlocks.TRANSITIONAL_CARPETS.get(name).get());
            dropSelf(ModBlocks.TRANSITIONAL_CARPET_BLOCKS.get(name).get());
            dropSelf(ModBlocks.SIMPLE_WALLPAPERS.get(name).get());
            dropSelf(ModBlocks.SMOOTH_WALLPAPERS.get(name).get());
            dropSelf(ModBlocks.TRANSITIONAL_WALLPAPERS.get(name).get());
            dropSelf(ModBlocks.WALLPAPERS.get(name).get());
            dropSelf(ModBlocks.COFFERED_CEILINGS.get(name).get());
        }

        for(String name : BlockSetsHelper.CEILING_TYPES)
        {
            dropSelf(ModBlocks.SLIM_CEILINGS.get(name).get());
        }

        for(String name : BlockSetsHelper.BRICKS_NAMES)
        {
            dropSelf(ModBlocks.BRICKS_VENEERS.get(name).get());
        }

        dropSelf(ModBlocks.SMOOTH_STONE_ROAD.get());

        for(String name : BlockSetsHelper.getWoods())
            for (String typeName : BlockSetsHelper.PARQUET_TYPES)
                dropSelf(ModBlocks.PARQUET_CARPETS.get(name+"_"+typeName).get());

        for(String name : BlockSetsHelper.getWoods())
            for (String typeName : BlockSetsHelper.PARQUET_TYPES)
                this.add(ModBlocks.PARQUET_BLOCKS.get(name + "_" + typeName).get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1)).add(LootItem.lootTableItem(ModBlocks.PARQUET_CARPETS.get(name + "_" + typeName).get()))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks()
    {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}