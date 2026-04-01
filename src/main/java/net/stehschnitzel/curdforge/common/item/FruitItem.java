package nudelauflauch.curd_mod.common.item;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

public class FruitItem extends Item {
	public FruitItem(Item.Properties builder) {
		super(builder);
	}

	public ItemStack finishUsingItem(ItemStack stack, Level worldIn, LivingEntity entityLiving) {
		super.finishUsingItem(stack, worldIn, entityLiving);
		if (entityLiving instanceof ServerPlayer) {
			ServerPlayer serverplayerentity = (ServerPlayer) entityLiving;
			CriteriaTriggers.CONSUME_ITEM.trigger(serverplayerentity, stack);
		}
		if (stack.isEmpty()) {
			return new ItemStack(nudelauflauch.curd_mod.core.init.CFItemInit.PIT.get());
		} else {
			if (entityLiving instanceof Player && !((Player) entityLiving).getAbilities().instabuild) {
				ItemStack itemstack = new ItemStack(nudelauflauch.curd_mod.core.init.CFItemInit.PIT.get());
				Player playerentity = (Player) entityLiving;
				if (!playerentity.getInventory().add(itemstack)) {
					playerentity.drop(itemstack, false);
				}
			}

			return stack;
		}
	}

	public int getUseDuration(ItemStack stack) {
		return 40;
	}

	public UseAnim getUseAnimation(ItemStack p_42997_) {
		return UseAnim.EAT;
	}

	public SoundEvent getEatingSound() {
		return SoundEvents.GENERIC_EAT;
	}

	public SoundEvent getDrinkingSound() {
		return SoundEvents.GENERIC_EAT;
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level p_41432_, Player p_41433_, InteractionHand p_41434_) {
		return ItemUtils.startUsingInstantly(p_41432_, p_41433_, p_41434_);
	}
}
