package net.lucasbz.waterenhanced;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.lucasbz.waterenhanced.entity.ModEntities;
import net.minecraft.client.render.entity.CodEntityRenderer;

public class WaterEnhancedClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.CRYSTAL_FISH, CodEntityRenderer::new);
    }
}
