package tark.stud.tfcfoodaddon;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;

import net.dries007.tfc.util.Helpers;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.function.Supplier;

public class ModItems {
    public static DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, TarksTFCFoodAddon.MODID);

    public static Map<ModFood, RegistryObject<Item>> FOODS;

    public static void registerAllFoods() {
        TarksTFCFoodAddon.LOGGER.info("Planning on registering all foods...");
        for (ModFood food : ModFood.AllFoods)
        {
            FOODS.put(food, register(food.id, () -> new Item(food.getItemProperties())));
        }
    }


    private static <T extends Item> RegistryObject<T> register(String name, Supplier<T> item)
    {
        TarksTFCFoodAddon.LOGGER.info("Registering food with id: {}", name);
        return ITEMS.register(name.toLowerCase(Locale.ROOT), item);
    }
}
