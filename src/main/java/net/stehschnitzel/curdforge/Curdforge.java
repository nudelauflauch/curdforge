package net.stehschnitzel.curdforge;

import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.stehschnitzel.curdforge.init.CFItemInit;
import net.stehschnitzel.curdforge.init.CfBlockInit;
import net.stehschnitzel.curdforge.init.CFCreativeTabInit;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;

@Mod(Curdforge.MOD_ID)
public class Curdforge {
	public static final String MOD_ID = "curdforge";
	IEventBus forgeBus = MinecraftForge.EVENT_BUS;

	public Curdforge(FMLJavaModLoadingContext context) {
        IEventBus bus = context.getModEventBus();

		CFItemInit.register(bus);
		CfBlockInit.register(bus);
        CFCreativeTabInit.register(bus);

		MinecraftForge.EVENT_BUS.register(this);
	}
}
