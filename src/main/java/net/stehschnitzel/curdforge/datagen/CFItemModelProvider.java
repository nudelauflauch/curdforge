package net.stehschnitzel.curdforge.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.stehschnitzel.curdforge.Curdforge;
import net.stehschnitzel.curdforge.init.CFItemInit;

public class CFItemModelProvider extends ItemModelProvider {

    public CFItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Curdforge.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(CFItemInit.OPUNTIA_BLOSSOM);
        simpleItem(CFItemInit.CURD);
        simpleItem(CFItemInit.APPLE_STRUDEL);
        simpleItem(CFItemInit.CURD_CHEESE_POCKET);
        simpleItem(CFItemInit.MILK_PUDDING);
        simpleItem(CFItemInit.PUMPKIN_TARTAR);
        simpleItem(CFItemInit.SWEET_BERRY_ROLE);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(Curdforge.MOD_ID,"item/" + item.getId().getPath()));
    }

}
