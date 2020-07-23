package com.theonlytails.ruby;

import com.theonlytails.ruby.init.ItemsRegistry;
import com.theonlytails.ruby.init.ArmorRegistry;
import com.theonlytails.ruby.init.BlocksRegistry;
import com.theonlytails.ruby.init.ToolsRegistry;
import net.minecraft.block.FallingBlock;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("ruby")
public class TheOnlyTails {
    public static final String MOD_ID = "ruby";

    public static final ItemGroup RUBY = new ItemGroup("rubyTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ItemsRegistry.RUBY.get());
        }
    };

    @SuppressWarnings("unused")
    private static final Logger LOGGER = LogManager.getLogger();

    public TheOnlyTails() {

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        BlocksRegistry.init();
        ItemsRegistry.init();
        ToolsRegistry.init();
        ArmorRegistry.init();

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
    }
}
