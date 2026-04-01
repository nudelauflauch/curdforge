package net.stehschnitzel.curdforge;

import net.stehschnitzel.curdforge.init.CFItemInit;
import net.stehschnitzel.curdforge.init.CfBlockInit;
import net.stehschnitzel.curdforge.init.CFCreativeTabInit;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;

@Mod(Curdforge.MOD_ID)
public class Curdforge {
	public static final String MOD_ID = "curd_mod";
	IEventBus forgeBus = MinecraftForge.EVENT_BUS;

	public Curdforge(IEventBus bus) {

		CFItemInit.register(bus);
		CfBlockInit.register(bus);
        CFCreativeTabInit.register(bus);

		MinecraftForge.EVENT_BUS.register(this);
	}
}
