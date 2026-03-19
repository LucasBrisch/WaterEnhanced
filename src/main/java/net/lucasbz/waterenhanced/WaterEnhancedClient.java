package net.lucasbz.waterenhanced;

import net.fabricmc.api.ClientModInitializer;
import net.lucasbz.waterenhanced.client.render.entity.AbyssGuardianRenderer;
import net.lucasbz.waterenhanced.client.render.entity.CrystalFishEntityRenderer;
import net.lucasbz.waterenhanced.entity.ModEntities;
import net.minecraft.client.render.entity.EntityRendererFactories;

public class WaterEnhancedClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityRendererFactories.register(ModEntities.CRYSTAL_FISH, CrystalFishEntityRenderer::new);
        EntityRendererFactories.register(ModEntities.ABYSS_GUARDIAN, AbyssGuardianRenderer::new);
    }
}
