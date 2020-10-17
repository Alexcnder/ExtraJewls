package com.github.theonlytails.rubymod.util

import com.github.theonlytails.rubymod.RubyMod
import com.github.theonlytails.rubymod.items.CustomSpawnEggItem
import net.minecraft.entity.EntityType
import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.event.RegistryEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod

@Mod.EventBusSubscriber(modid = RubyMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = [Dist.CLIENT])
class ClientEventBusSubscriber {

	@SubscribeEvent
	fun onRegisterEntities(event: RegistryEvent.Register<EntityType<*>>) {
		CustomSpawnEggItem.initSpawnEggs()
	}
}