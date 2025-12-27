package net.alminoris.aestheticsurfaces.datagen.loot;

import net.alminoris.aestheticsurfaces.block.ModBlocks;
import net.alminoris.aestheticsurfaces.item.ModItemGroups;
import net.alminoris.aestheticsurfaces.util.helper.BlockSetsHelper;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockLootTables extends BlockLoot
{
    @Override
    protected void addTables()
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

        for(String name : ModItemGroups.CEILING_TYPES)
        {
            dropSelf(ModBlocks.SLIM_CEILINGS.get(name).get());
        }

        for(String name : ModItemGroups.BRICKS_NAMES)
        {
            dropSelf(ModBlocks.BRICKS_VENEERS.get(name).get());
        }

        dropSelf(ModBlocks.SMOOTH_STONE_ROAD.get());

        for(String name : BlockSetsHelper.getWoods())
            for (String typeName : ModItemGroups.PARQUET_TYPES)
                dropSelf(ModBlocks.PARQUET_CARPETS.get(name+"_"+typeName).get());

        for(String name : BlockSetsHelper.getWoods())
            for (String typeName : ModItemGroups.PARQUET_TYPES)
                this.add(ModBlocks.PARQUET_BLOCKS.get(name + "_" + typeName).get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1)).add(LootItem.lootTableItem(ModBlocks.PARQUET_CARPETS.get(name + "_" + typeName).get()))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks()
    {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
