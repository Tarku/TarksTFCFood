package tark.stud.tfcfoodaddon;

import net.minecraft.ChatFormatting;
import net.minecraft.client.renderer.EffectInstance;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class ModFood extends Item
{
    private final Boolean poison;

    ModFood(Boolean isPoison)
    {

        super(new Item.Properties());


        poison = isPoison;
    }

    public FoodProperties getModFoodProperties()
    {
        FoodProperties.Builder builder = new FoodProperties.Builder();

        builder.fast();

        if (poison)
        {
            MobEffectInstance meiPoison = new MobEffectInstance(MobEffects.POISON, 600, 0);
            Supplier<MobEffectInstance> supplierPoison = () -> meiPoison;


            builder.effect(supplierPoison, 1f);
        }

        return builder.nutrition(0).saturationMod(0.3f).build();
    }

    public Item.Properties getItemProperties()
    {
        return new Item.Properties().food(getModFoodProperties());
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced)
    {

        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);

        if (poison)
        {
            pTooltipComponents.add(Component.literal("This tastes wrong,").withStyle(ChatFormatting.DARK_GRAY, ChatFormatting.ITALIC));
            pTooltipComponents.add(Component.literal("I should probably cook that.").withStyle(ChatFormatting.DARK_GRAY, ChatFormatting.ITALIC));
        }
        else
        {

            pTooltipComponents.add(Component.literal("Probably fine to eat.").withStyle(ChatFormatting.DARK_GRAY, ChatFormatting.ITALIC));
        }
    }

}
