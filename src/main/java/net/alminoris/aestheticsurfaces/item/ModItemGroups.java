package net.alminoris.aestheticsurfaces.item;

import net.alminoris.aestheticsurfaces.AestheticSurfaces;
import net.alminoris.aestheticsurfaces.block.ModBlocks;
import net.alminoris.aestheticsurfaces.util.helper.BlockSetsHelper;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static net.alminoris.aestheticsurfaces.util.helper.BlockSetsHelper.*;
import static net.alminoris.aestheticsurfaces.util.helper.BlockSetsHelper.NSS_WOOD_NAMES;

@Mod.EventBusSubscriber(modid = AestheticSurfaces.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModItemGroups
{
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AestheticSurfaces.MOD_ID);

    public static final RegistryObject<CreativeModeTab> ASURF_TAB = CREATIVE_MODE_TABS.register("asurftab", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(ModBlocks.SIMPLE_CARPETS.get("white").get().asItem()::getDefaultInstance)
            .title(Component.translatable("itemgroup.asurftab"))
            .displayItems((parameters, entries) ->
            {
                for(String name : BlockSetsHelper.COLORS)
                    entries.accept(ModBlocks.COFFERED_CEILINGS.get(name).get());

                for(String name : BlockSetsHelper.CEILING_TYPES)
                    entries.accept(ModBlocks.SLIM_CEILINGS.get(name).get());

                for(String name : BlockSetsHelper.BRICKS_NAMES)
                    entries.accept(ModBlocks.BRICKS_VENEERS.get(name).get());

                entries.accept(ModBlocks.SMOOTH_STONE_ROAD.get());

                for(String name : BlockSetsHelper.WOODS)
                    for (String typeName : BlockSetsHelper.PARQUET_TYPES)
                        entries.accept(ModBlocks.PARQUET_CARPETS.get(name+"_"+typeName).get());

                if (ModList.get().isLoaded("arborealnature"))
                {
                    for(String name : BlockSetsHelper.EXTRA_WOODS_AN)
                        for (String typeName : BlockSetsHelper.PARQUET_TYPES)
                            entries.accept(ModBlocks.PARQUET_CARPETS.get(name+"_"+typeName).get());
                }

                if (ModList.get().isLoaded("wildfields"))
                {
                    for(String name : BlockSetsHelper.EXTRA_WOODS_WF)
                        for (String typeName : BlockSetsHelper.PARQUET_TYPES)
                            entries.accept(ModBlocks.PARQUET_CARPETS.get(name+"_"+typeName).get());
                }

                if (ModList.get().isLoaded("whisperleaftrees"))
                {
                    for(String name : BlockSetsHelper.WT_WOOD_NAMES)
                        for (String typeName : BlockSetsHelper.PARQUET_TYPES)
                            entries.accept(ModBlocks.PARQUET_CARPETS.get(name+"_"+typeName).get());
                }

                if (ModList.get().isLoaded("silverwoodtrees"))
                {
                    for(String name : BlockSetsHelper.ST_WOOD_NAMES)
                        for (String typeName : BlockSetsHelper.PARQUET_TYPES)
                            entries.accept(ModBlocks.PARQUET_CARPETS.get(name+"_"+typeName).get());
                }

                if (ModList.get().isLoaded("missingtrees"))
                {
                    for(String name : BlockSetsHelper.MT_WOOD_NAMES)
                        for (String typeName : BlockSetsHelper.PARQUET_TYPES)
                            entries.accept(ModBlocks.PARQUET_CARPETS.get(name+"_"+typeName).get());
                }

                if (ModList.get().isLoaded("natures_spirit"))
                {
                    for(String name : BlockSetsHelper.NSS_WOOD_NAMES)
                        for (String typeName : BlockSetsHelper.PARQUET_TYPES)
                            entries.accept(ModBlocks.PARQUET_CARPETS.get(name+"_"+typeName).get());
                }

                for(String name : BlockSetsHelper.COLORS)
                    entries.accept(ModBlocks.WALLPAPERS.get(name).get());
                for(String name : BlockSetsHelper.COLORS)
                    entries.accept(ModBlocks.SIMPLE_CARPETS.get(name).get());
                for(String name : BlockSetsHelper.COLORS)
                    entries.accept(ModBlocks.SIMPLE_WALLPAPERS.get(name).get());
                for(String name : BlockSetsHelper.COLORS)
                    entries.accept(ModBlocks.SIMPLE_CARPET_BLOCKS.get(name).get());
                for(String name : BlockSetsHelper.COLORS)
                    entries.accept(ModBlocks.SMOOTH_CARPETS.get(name).get());
                for(String name : BlockSetsHelper.COLORS)
                    entries.accept(ModBlocks.SMOOTH_WALLPAPERS.get(name).get());
                for(String name : BlockSetsHelper.COLORS)
                    entries.accept(ModBlocks.SMOOTH_CARPET_BLOCKS.get(name).get());
                for(String name : BlockSetsHelper.COLORS)
                    entries.accept(ModBlocks.TRANSITIONAL_CARPETS.get(name).get());
                for(String name : BlockSetsHelper.COLORS)
                    entries.accept(ModBlocks.TRANSITIONAL_WALLPAPERS.get(name).get());
                for(String name : BlockSetsHelper.COLORS)
                    entries.accept(ModBlocks.TRANSITIONAL_CARPET_BLOCKS.get(name).get());

                for(String name : BlockSetsHelper.WOODS)
                    for (String typeName : BlockSetsHelper.PARQUET_TYPES)
                        entries.accept(ModBlocks.PARQUET_BLOCKS.get(name+"_"+typeName).get());

                if (ModList.get().isLoaded("arborealnature"))
                {
                    for(String name : BlockSetsHelper.EXTRA_WOODS_AN)
                        for (String typeName : BlockSetsHelper.PARQUET_TYPES)
                            entries.accept(ModBlocks.PARQUET_BLOCKS.get(name+"_"+typeName).get());
                }

                if (ModList.get().isLoaded("wildfields"))
                {
                    for(String name : BlockSetsHelper.EXTRA_WOODS_WF)
                        for (String typeName : BlockSetsHelper.PARQUET_TYPES)
                            entries.accept(ModBlocks.PARQUET_BLOCKS.get(name+"_"+typeName).get());
                }

                if (ModList.get().isLoaded("whisperleaftrees"))
                {
                    for(String name : BlockSetsHelper.WT_WOOD_NAMES)
                        for (String typeName : BlockSetsHelper.PARQUET_TYPES)
                            entries.accept(ModBlocks.PARQUET_BLOCKS.get(name+"_"+typeName).get());
                }

                if (ModList.get().isLoaded("silverwoodtrees"))
                {
                    for(String name : BlockSetsHelper.ST_WOOD_NAMES)
                        for (String typeName : BlockSetsHelper.PARQUET_TYPES)
                            entries.accept(ModBlocks.PARQUET_BLOCKS.get(name+"_"+typeName).get());
                }

                if (ModList.get().isLoaded("missingtrees"))
                {
                    for(String name : BlockSetsHelper.MT_WOOD_NAMES)
                        for (String typeName : BlockSetsHelper.PARQUET_TYPES)
                            entries.accept(ModBlocks.PARQUET_BLOCKS.get(name+"_"+typeName).get());
                }

                if (ModList.get().isLoaded("natures_spirit"))
                {
                    for(String name : BlockSetsHelper.NSS_WOOD_NAMES)
                        for (String typeName : BlockSetsHelper.PARQUET_TYPES)
                            entries.accept(ModBlocks.PARQUET_BLOCKS.get(name+"_"+typeName).get());
                }
            }).build());

    public static void register(IEventBus eventBus)
    {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}