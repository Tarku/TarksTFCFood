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

    public static final RegistryObject<Item> CHESTNUT_= register(
            "chestnut",
            () -> new Item(
                    new ModFood(true).getItemProperties()
            ));


    public static final RegistryObject<Item> ROASTED_CHESTNUT = register(
            "roasted_chestnut",
            () -> new Item(
                    new ModFood(false).getItemProperties()
            ));

    public static final RegistryObject<Item> ACORN = register(
            "acorn",
            () -> new Item(
                    new ModFood(true).getItemProperties()
            ));

    public static final RegistryObject<Item> ROASTED_ACORN = register(
            "roasted_acorn",
            () -> new Item(
                    new ModFood(false).getItemProperties()
            ));

    public static final RegistryObject<Item> HICKORY_NUT = register(
            "hickory_nut",
            () -> new Item(
                        new ModFood(false).getItemProperties()
                    )
    );

    public static final RegistryObject<Item> PINE_NUT = register(
            "pine_nut",
            () -> new Item(
                    new ModFood(false).getItemProperties()
            ));

    public static <T extends Item> RegistryObject<T> register(String name, Supplier<T> item)
    {
        TarksTFCFoodAddon.LOGGER.info("Registering food with id: {}", name);
        return ITEMS.register(name.toLowerCase(Locale.ROOT), item);
    }
}
