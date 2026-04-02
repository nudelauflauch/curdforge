package net.stehschnitzel.curdforge.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.stehschnitzel.curdforge.Curdforge;
import net.stehschnitzel.curdforge.common.blocks.CuddlyCactus;
import net.stehschnitzel.curdforge.init.CfBlockInit;

import java.util.List;

public class CFBlockStateProvider extends BlockStateProvider {

    public CFBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Curdforge.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        cuddlyCactusBlock(CfBlockInit.CUDDLY_CACTUS);
    }

    public void cuddlyCactusBlock(RegistryObject<Block> registryObject) {
        Block cuddlyCactus = registryObject.get();
        List<ModelFile> files = new java.util.ArrayList<>(List.of());
        String name = name(cuddlyCactus);

        for (int i = 0; i < 9; i++) {
            files.add(models().cross(name + "_" + i,
                    ResourceLocation.fromNamespaceAndPath(Curdforge.MOD_ID,
                            "block/" + name + "_" +i))
                    .renderType("cutout"));
        }

        getVariantBuilder(cuddlyCactus).forAllStates(blockState -> {
            int age = blockState.getValue(CuddlyCactus.AGE);

            return ConfiguredModel.builder()
                    .modelFile(files.get(age))
                    .build();
        });
    }

    public static String name(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block).getPath();
    }
}
