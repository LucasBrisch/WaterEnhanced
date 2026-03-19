package net.lucasbz.waterenhanced.client.render.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.lucasbz.waterenhanced.WaterEnhanced;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.GuardianEntityRenderer;
import net.minecraft.client.render.entity.state.GuardianEntityRenderState;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class AbyssGuardianRenderer extends GuardianEntityRenderer {

    private static final Identifier TEXTURE = Identifier.of(WaterEnhanced.MOD_ID, "textures/entity/abyss_guardian.png");
    private static final float MODEL_SCALE = 1.75f; // Visual size multiplier

    public AbyssGuardianRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
    }

    @Override
    protected void scale(GuardianEntityRenderState state, MatrixStack matrices) {
        super.scale(state, matrices);
        matrices.scale(MODEL_SCALE, MODEL_SCALE, MODEL_SCALE);
    }

    @Override
    public Identifier getTexture(GuardianEntityRenderState state) {
        return TEXTURE;
    }
}

