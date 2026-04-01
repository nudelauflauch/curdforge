package nudelauflauch.curd_mod.common.item;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

public class KefirItem extends Item {
	public KefirItem(Item.Properties builder) {
		super(builder);
	}

	public ItemStack finishUsingItem(ItemStack stack, Level worldIn, LivingEntity entityLiving) {
		super.finishUsingItem(stack, worldIn, entityLiving);
		if (entityLiving instanceof Player) {
			Player serverplayerentity = (Player) entityLiving;
			CriteriaTriggers.CONSUME_ITEM.trigger((ServerPlayer) serverplayerentity, stack);
		}
		if (!worldIn.isClientSide) {
			entityLiving.removeEffect(MobEffects.POISON);
		}
		if (stack.isEmpty()) {
			return new ItemStack(nudelauflauch.curd_mod.core.init.CFItemInit.KEFIR_TUMBLER.get());
		} else {
			if (entityLiving instanceof Player && !((Player) entityLiving).getAbilities().instabuild) {
				ItemStack itemstack = new ItemStack(nudelauflauch.curd_mod.core.init.CFItemInit.KEFIR_TUMBLER.get());
				Player playerentity = (Player) entityLiving;
				if (!playerentity.getInventory().add(itemstack)) {
					playerentity.drop(itemstack, false);
				}
			}

			return stack;
		}
	}

	public UseAnim getUseAnimation(ItemStack p_42997_) {
		return UseAnim.DRINK;
	}

	public int getUseDuration(ItemStack stack) {
		return 37;
	}

	public SoundEvent getDrinkingSound() {
		return SoundEvents.GENERIC_DRINK;
	}

	public SoundEvent getEatingSound() {
		return SoundEvents.GENERIC_DRINK;
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		return ItemUtils.startUsingInstantly(level, player, hand);
	}
}
