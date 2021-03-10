package com.theonlytails.rubymod.items

import com.theonlytails.rubymod.entities.RubySheepEntity
import com.theonlytails.rubymod.registries.EntityTypeRegistry
import com.theonlytails.rubymod.rubyTabProperty
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.SpawnReason
import net.minecraft.entity.passive.SheepEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.util.ActionResultType
import net.minecraft.util.Hand
import net.minecraft.world.IServerWorld

/**
 * Holds the custom functionality of rubies.
 *
 * @author TheOnlyTails
 */
class Ruby : Item(rubyTabProperty) {
	override fun interactLivingEntity(
		stack: ItemStack,
		playerIn: PlayerEntity,
		target: LivingEntity,
		hand: Hand,
	): ActionResultType {

		if (target is SheepEntity) {
			if (target.isAlive && !target.isSheared && target !is RubySheepEntity) {
				if (!playerIn.level.isClientSide) {
					val rubySheepEntity = EntityTypeRegistry.rubySheep.create(playerIn.level)
					if (rubySheepEntity != null) {
						rubySheepEntity.moveTo(
							target.x,
							target.y,
							target.z,
							target.yRot,
							target.xRot
						)
						rubySheepEntity.finalizeSpawn(
							playerIn.level as IServerWorld,
							playerIn.level.getCurrentDifficultyAt(rubySheepEntity.blockPosition()),
							SpawnReason.CONVERSION,
							null,
							null
						)
						playerIn.level.addFreshEntity(rubySheepEntity)
						target.remove()

						stack.shrink(1)
					}
				}

				return ActionResultType.sidedSuccess(playerIn.level.isClientSide)
			}
		}
		return ActionResultType.PASS
	}
}
