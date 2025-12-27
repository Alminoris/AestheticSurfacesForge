package net.alminoris.aestheticsurfaces.item;

import net.alminoris.aestheticsurfaces.AestheticSurfaces;
import net.alminoris.aestheticsurfaces.block.ModBlocks;
import net.alminoris.aestheticsurfaces.util.helper.BlockSetsHelper;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static net.alminoris.aestheticsurfaces.util.helper.BlockSetsHelper.*;
import static net.alminoris.aestheticsurfaces.util.helper.BlockSetsHelper.NSS_WOOD_NAMES;

@Mod.EventBusSubscriber(modid = AestheticSurfaces.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModItemGroups
{
    public static CreativeModeTab ASURF_TAB;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event)
    {
        ASURF_TAB = event.registerCreativeModeTab(ResourceLocation.fromNamespaceAndPath(AestheticSurfaces.MOD_ID, "asurftab"),
                builder -> builder.icon(() -> new ItemStack(ModBlocks.SIMPLE_CARPETS.get("white").get().asItem()))
                        .title(Component.translatable("itemgroup.asurftab")));
    }
}