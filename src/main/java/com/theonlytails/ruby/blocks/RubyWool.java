package com.theonlytails.ruby.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;

public class RubyWool extends Block {
    public RubyWool() {
        super(Block.Properties
                .create(Material.WOOL, MaterialColor.CRIMSON_HYPHAE)
                .hardnessAndResistance(1f)
                .sound(SoundType.CLOTH));
    }
}