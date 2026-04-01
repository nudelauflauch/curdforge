package nudelauflauch.curd_mod.common.item;

import java.util.Random;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import nudelauflauch.curd_mod.common.entities.projectile.PitEntity;

public class PitItem extends Item {
	public PitItem(Properties properties) {
		super(properties);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand handIn) {
		ItemStack itemstack = playerIn.getItemInHand(handIn);
		worldIn.playSound((Player) null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), SoundEvents.EGG_THROW,
				SoundSource.PLAYERS, 0.5F, 0.4F / (new Random().nextFloat() * 0.4F + 0.8F));
		if (!worldIn.isClientSide) {
			PitEntity pit = new PitEntity(playerIn, worldIn);
			pit.setItem(itemstack);
			pit.shootFromRotation(playerIn, playerIn.getXRot(), playerIn.getYRot(), 0.0F, 1.5F, 1.0F);
			worldIn.addFreshEntity(pit);
		}

		if (!playerIn.getAbilities().instabuild)
			itemstack.shrink(1);

		return InteractionResultHolder.sidedSuccess(itemstack, worldIn.isClientSide());

	}

}
