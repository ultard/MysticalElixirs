package me.ultar.block

import me.ultar.MysticalElixirs
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents.ModifyEntries
import net.minecraft.block.AbstractBlock
import net.minecraft.block.Block
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.item.ItemGroups
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.sound.BlockSoundGroup
import net.minecraft.util.Identifier


object ModBlocks {
    val AMBER_ORE: Block = register(
        AbstractBlock.Settings.create().strength(0.2f)
            .requiresTool().sounds(BlockSoundGroup.STONE),
        "amber_ore",
        true
    )

    val DEEPSLATE_AMBER_ORE: Block = register(
        AbstractBlock.Settings.create().strength(0.5f)
            .requiresTool().sounds(BlockSoundGroup.DEEPSLATE),
        "deepslate_amber_ore",
        true
    )

    private fun register(blockSettings: AbstractBlock.Settings, name: String, shouldRegisterItem: Boolean): Block {
        val id = Identifier.of(MysticalElixirs.MOD_ID, name)
        val block = Block(blockSettings.registryKey(RegistryKey.of(RegistryKeys.BLOCK, id)))

        if (shouldRegisterItem) {
            val settings = Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, id))
            val blockItem = BlockItem(block, settings)
            Registry.register(Registries.ITEM, id, blockItem)
        }

        return Registry.register(Registries.BLOCK, id, block)
    }

    fun initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SEARCH)
            .register(ModifyEntries { itemGroup: FabricItemGroupEntries ->
                itemGroup.add(AMBER_ORE.asItem())
                itemGroup.add(DEEPSLATE_AMBER_ORE.asItem())
            })

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL)
            .register(ModifyEntries { itemGroup: FabricItemGroupEntries ->
                itemGroup.add(AMBER_ORE.asItem())
                itemGroup.add(DEEPSLATE_AMBER_ORE.asItem())
            })
    }
}