package me.ultar
import me.ultar.block.ModBlocks
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider
import net.minecraft.registry.RegistryWrapper.WrapperLookup
import java.util.concurrent.CompletableFuture

class MysticalelixirsBlockLootTableProvider (
    dataOutput: FabricDataOutput?,
    registryLookup: CompletableFuture<WrapperLookup?>
) :
    FabricBlockLootTableProvider(dataOutput, registryLookup) {

    override fun generate() {
        addDrop(ModBlocks.AMBER_ORE)
        addDrop(ModBlocks.DEEPSLATE_AMBER_ORE)
    }
}