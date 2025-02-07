package me.ultar

import me.ultar.block.ModBlocks
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.minecraft.block.Block
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.RegistryWrapper.WrapperLookup
import net.minecraft.registry.tag.TagKey
import net.minecraft.util.Identifier
import java.util.concurrent.CompletableFuture


class MysticalelixirsBlockTagProvider(
    output: FabricDataOutput?,
    registriesFuture: CompletableFuture<WrapperLookup?>?
) : FabricTagProvider<Block?>(output, RegistryKeys.BLOCK, registriesFuture) {
    val PICKAXE: TagKey<Block?> = TagKey.of(RegistryKeys.BLOCK, Identifier.of("minecraft", "mineable/pickaxe"))

    val NEEDS_STONE_TOOL: TagKey<Block?> = TagKey.of(RegistryKeys.BLOCK, Identifier.of("minecraft", "needs_stone_tool"))
    val NEEDS_IRON_TOOL: TagKey<Block?> = TagKey.of(RegistryKeys.BLOCK, Identifier.of("minecraft", "needs_iron_tool"))
    val NEEDS_DIAMOND_TOOL: TagKey<Block?> = TagKey.of(RegistryKeys.BLOCK, Identifier.of("minecraft", "needs_diamond_tool"))

    override fun configure(wrapperLookup: WrapperLookup) {
        getOrCreateTagBuilder(PICKAXE)
            .add(ModBlocks.AMBER_ORE)
            .add(ModBlocks.DEEPSLATE_AMBER_ORE)

        getOrCreateTagBuilder(NEEDS_STONE_TOOL)
            .add(ModBlocks.AMBER_ORE)

        getOrCreateTagBuilder(NEEDS_IRON_TOOL)
            .add(ModBlocks.DEEPSLATE_AMBER_ORE)
    }
}