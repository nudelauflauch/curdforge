package nudelauflauch.curd_mod.common.particles;


import net.minecraft.client.particle.IAnimatedSprite;
import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.client.particle.IParticleRenderType;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.SpriteTexturedParticle;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class KefirParticle extends SpriteTexturedParticle {

	protected KefirParticle(ClientWorld worldIn, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeedIn,
			double ySpeedIn, double zSpeedIn) {
		super(worldIn, xCoordIn, yCoordIn, zCoordIn, xSpeedIn, ySpeedIn, zSpeedIn);

		float f = this.rand.nextFloat() * 1.0f;
		this.particleRed = f;
		this.particleGreen = f;
		this.particleBlue = f;

		this.setSize(0.02f, 0.02f);
		this.particleScale *= this.rand.nextFloat() * 1.1F;
		this.motionX *= (double) 0.02f;
		this.motionY *= (double) 0.02f;
		this.motionZ *= (double) 0.02f;
		this.maxAge = (int) (20.0D / (Math.random() * 1.0D));

	}

	@Override
	public IParticleRenderType getRenderType() {
		return IParticleRenderType.PARTICLE_SHEET_OPAQUE;
	}

	@Override
	public void tick() {
		this.prevPosX = this.posX;
		this.prevPosY = this.posY;
		this.prevPosZ = this.posZ;

		if (this.maxAge-- <= 0) {
			this.setExpired();
		} else {
			this.move(this.motionX, this.motionY, this.motionZ);
			this.motionX *= 1.0D;
			this.motionY *= 1.0D;
			this.motionZ *= 1.0D;
		}
	}

	@OnlyIn(Dist.CLIENT)
	public static class Factory implements IParticleFactory<BasicParticleType> {
		private final IAnimatedSprite spriteSet;

		public Factory(IAnimatedSprite sprite) {
			this.spriteSet = sprite;
		}

		public Particle makeParticle(BasicParticleType typeIn, World worldIn, double x, double y, double z,
				double xSpeed, double ySpeed, double zSpeed) {
			KefirParticle orangeParticle = new KefirParticle((ClientWorld) worldIn, x, y, z, xSpeed, ySpeed, zSpeed);
			orangeParticle.setColor(1.0f, 1.0f, 1.0f);
			orangeParticle.selectSpriteRandomly(this.spriteSet);
			return orangeParticle;
		}

		@Override
		public Particle makeParticle(BasicParticleType typeIn, ClientWorld worldIn, double x, double y, double z,
				double xSpeed, double ySpeed, double zSpeed) {
			return null;
		}

	}

}