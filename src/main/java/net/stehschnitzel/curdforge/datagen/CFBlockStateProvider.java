package net.stehschnitzel.curdforge.datagen;

import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.stehschnitzel.curdforge.Curdforge;

public class CFBlockStateProvider extends BlockStateProvider {

    public CFBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Curdforge.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

    }
}
