package net.lucasbz.waterenhanced.client.render.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.lucasbz.waterenhanced.WaterEnhanced;
import net.minecraft.client.render.entity.CodEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class CrystalFishEntityRenderer extends CodEntityRenderer {

    private static final Identifier TEXTURE = Identifier.of(WaterEnhanced.MOD_ID, "textures/entity/fish/crystal_fish");

    public CrystalFishEntityRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
    }

    @Override
    public Identifier getTexture(LivingEntityRenderState state) {
        return TEXTURE;
    }
}
