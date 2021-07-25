package fr.lmf.itempredicatetutorial;

import fr.lmf.itempredicatetutorial.init.ItemInit;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


@Mod(Main.MODID)
public class Main {

    public static final String MODID = "item_predicate_tutorial";

    public Main() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        ItemInit.ITEMS.register(bus);
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        ItemProperties.register(ItemInit.TEST_PREDICATE.get(), new ResourceLocation("test"), (tag, p_174631_, p_174632_, p_174633_) -> {
            return tag.getTag() != null && tag.getTag().getBoolean("isBest") ? 1.0F : 0.0F;
        });
    }
}
