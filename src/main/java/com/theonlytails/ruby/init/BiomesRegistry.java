package com.theonlytails.ruby.init;

import com.theonlytails.ruby.TheOnlyTails;
import com.theonlytails.ruby.world.biomes.RubyHills;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BiomesRegistry {
    public static final DeferredRegister<Biome> BIOMES =
            DeferredRegister.create(ForgeRegistries.BIOMES, TheOnlyTails.MOD_ID);

    public static final RegistryObject<Biome> RUBY_HILLS =
            BIOMES.register("ruby_hills", RubyHills::new);

    public static void registerBiomes() {
        registerBiome(RUBY_HILLS.get(), BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.OVERWORLD);
    }

    public static void registerBiome(Biome biome, BiomeDictionary.Type... types) {
        BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(biome, 100));
        BiomeDictionary.addTypes(biome, types);
        BiomeManager.addSpawnBiome(biome);
    }

    public static void init() {
        BIOMES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
