package me.ultar

import me.ultar.block.ModBlocks
import me.ultar.item.ModItems
import net.fabricmc.api.ModInitializer
import org.slf4j.LoggerFactory

object MysticalElixirs : ModInitializer {
	const val MOD_ID = "mysticalelixirs"
	val logger = LoggerFactory.getLogger(MOD_ID)

	override fun onInitialize() {
		ModItems.initialize()
		ModBlocks.initialize()
	}
}