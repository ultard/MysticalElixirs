package me.ultar.item

import me.ultar.MysticalElixirs
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.item.Item
import net.minecraft.item.ItemGroups
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.util.Identifier

object ModItems {
    val AMBER = register(Item.Settings(), "amber")

    private fun register(itemSettings: Item.Settings, name: String): Item {
        val id: Identifier = Identifier.of(MysticalElixirs.MOD_ID, name)
        val key: RegistryKey<Item> = RegistryKey.of(RegistryKeys.ITEM, id)
        val settings: Item.Settings = itemSettings.registryKey(key)

        return Registry.register(Registries.ITEM, key, Item(settings))
    }

    fun initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SEARCH)
            .register(ItemGroupEvents.ModifyEntries { itemGroup: FabricItemGroupEntries ->
                itemGroup.add(AMBER)
            })

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
            .register(ItemGroupEvents.ModifyEntries { itemGroup: FabricItemGroupEntries ->
                itemGroup.add(AMBER)
            })
    }
}
