package net.stehschnitzel.curdforge.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.stehschnitzel.curdforge.init.CFItemInit;

import java.util.function.Consumer;

public class CFRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public CFRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, CFItemInit.PUMPKIN_TARTAR.get())
                .requires(Items.WHEAT)
                .requires(Items.WHEAT)
                .requires(Items.PUMPKIN)
                .requires(CFItemInit.CURD.get())
                .unlockedBy(getHasName(CFItemInit.CURD.get()), has(CFItemInit.CURD.get()))
                .unlockedBy(getHasName(Items.PUMPKIN), has(Items.PUMPKIN))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CFItemInit.APPLE_STRUDEL.get(), 2)
                .pattern(" # ")
                .pattern("#A#")
                .pattern("#C#")
                .define('#', Items.WHEAT)
                .define('A', Items.APPLE)
                .define('C', CFItemInit.CURD.get())
                .unlockedBy(getHasName(CFItemInit.CURD.get()), has(CFItemInit.CURD.get()))
                .unlockedBy(getHasName(Items.WHEAT), has(Items.WHEAT))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, CFItemInit.MILK_PUDDING.get(), 4)
                .requires(Items.MILK_BUCKET)
                .requires(Items.SUGAR)
                .requires(CFItemInit.CURD.get())
                .unlockedBy(getHasName(CFItemInit.CURD.get()), has(CFItemInit.CURD.get()))
                .unlockedBy(getHasName(Items.PUMPKIN), has(Items.PUMPKIN))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CFItemInit.CURD_CHEESE_POCKET.get())
                .pattern(" # ")
                .pattern("#A#")
                .pattern(" # ")
                .define('#', Items.WHEAT)
                .define('A', CFItemInit.CURD.get())
                .unlockedBy(getHasName(CFItemInit.CURD.get()), has(CFItemInit.CURD.get()))
                .unlockedBy(getHasName(Items.WHEAT), has(Items.WHEAT))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CFItemInit.SWEET_BERRY_ROLE.get())
                .pattern("#S#")
                .pattern(" # ")
                .define('#', Items.WHEAT)
                .define('S', Items.SWEET_BERRIES)
                .unlockedBy(getHasName(Items.SWEET_BERRIES), has(Items.SWEET_BERRIES))
                .unlockedBy(getHasName(Items.WHEAT), has(Items.WHEAT))
                .save(pWriter);

    }
}
