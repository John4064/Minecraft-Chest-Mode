//package dev.rcslabs.gigachests.item;
//
//import dev.rcslabs.gigachests.GigaChests;
//import dev.rcslabs.gigachests.block.ModBlocks;
//import net.minecraft.core.registries.Registries;
//import net.minecraft.network.chat.Component;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.world.item.CreativeModeTab;
//import net.minecraft.world.item.ItemStack;
//import net.neoforged.bus.api.IEventBus;
//import net.neoforged.neoforge.registries.DeferredRegister;
//
//import java.util.function.Supplier;
//
//public class ModCreativeModeTabs {
//
//    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
//            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, GigaChests.MOD_ID);
//
//    public static final Supplier<CreativeModeTab> GIGA_ITEMS_TAB = CREATIVE_MODE_TAB.register("giga_items_tab",
//            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.UPGRADE_ROCK.get()))
//                    .title(Component.translatable("creativetab.gigachests.giga_items"))
//                    .displayItems((itemDisplayParameters, output) -> {
//                        output.accept(ModItems.UPGRADE_ROCK);
//                    }).build());
//
//    public static final Supplier<CreativeModeTab> GIGA_BLOCK_TAB = CREATIVE_MODE_TAB.register("giga_blocks_tab",
//            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.OMEGA_CHEST))
//                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(GigaChests.MOD_ID, "giga_items_tab"))
//                    .title(Component.translatable("creativetab.gigachests.giga_blocks"))
//                    .displayItems((itemDisplayParameters, output) -> {
//                        output.accept(ModBlocks.OMEGA_CHEST);
//
//                    }).build());
//
//
//    public static void register(IEventBus eventBus) {
//        CREATIVE_MODE_TAB.register(eventBus);
//    }
//}
