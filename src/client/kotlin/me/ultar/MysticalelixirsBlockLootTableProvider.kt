package me.ultar

import me.ultar.block.ModBlocks
import me.ultar.item.ModItems

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider

import net.minecraft.block.Block
import net.minecraft.item.Item
import net.minecraft.loot.LootPool
import net.minecraft.loot.LootTable
import net.minecraft.loot.entry.AlternativeEntry
import net.minecraft.loot.entry.ItemEntry

import net.minecraft.registry.RegistryWrapper.WrapperLookup
import java.util.concurrent.CompletableFuture

class MysticalelixirsBlockLootTableProvider (
    dataOutput: FabricDataOutput?,
    registryLookup: CompletableFuture<WrapperLookup?>
) : FabricBlockLootTableProvider(dataOutput, registryLookup) {

    private fun addOreDrop(block: Block, item: Item) {
        addDrop(block, LootTable.builder()
            .pool(LootPool.builder().with(
                AlternativeEntry.builder()
                    .alternatively(ItemEntry.builder(block).conditionally(createSilkTouchCondition()))
                    .alternatively(applyExplosionDecay(item, ItemEntry.builder(item)))
            ))
        )
    }

    override fun generate() {
        addOreDrop(ModBlocks.AMBER_ORE, ModItems.AMBER)
        addOreDrop(ModBlocks.DEEPSLATE_AMBER_ORE, ModItems.AMBER)
    }
}