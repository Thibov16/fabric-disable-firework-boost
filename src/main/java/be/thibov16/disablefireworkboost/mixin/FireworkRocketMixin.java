package be.thibov16.disablefireworkboost.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FireworkRocketItem;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FireworkRocketItem.class)
public class FireworkRocketMixin {
	@Inject(at = @At("HEAD"), method = "use", cancellable = true)
	private void inject(World world, PlayerEntity user, Hand hand, CallbackInfoReturnable cbir) {
		cbir.setReturnValue( TypedActionResult.pass(user.getStackInHand(hand)) );
	}
}
