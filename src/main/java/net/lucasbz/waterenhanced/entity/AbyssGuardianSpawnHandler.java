package net.lucasbz.waterenhanced.entity;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.lucasbz.waterenhanced.WaterEnhanced;
import net.minecraft.entity.Entity;
import net.minecraft.entity.mob.ElderGuardianEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;

public class AbyssGuardianSpawnHandler {

    private static final double CHECK_RADIUS = 64.0D;

    public static void register() {
        ServerEntityEvents.ENTITY_LOAD.register(AbyssGuardianSpawnHandler::onEntityLoad);
    }

    private static void onEntityLoad(Entity entity, ServerWorld world) {
        if (!(entity instanceof ElderGuardianEntity elderGuardian) || entity instanceof AbyssGuardianEntity) {
            return;
        }

        BlockPos pos = elderGuardian.getBlockPos();
        Box searchBox = new Box(pos).expand(CHECK_RADIUS);

        boolean hasAbyssGuardian = !world.getEntitiesByClass(
                AbyssGuardianEntity.class,
                searchBox,
                e -> true
        ).isEmpty();

        if (hasAbyssGuardian) {
            return;
        }

        AbyssGuardianEntity abyssGuardian = ModEntities.ABYSS_GUARDIAN.create(world, null);
        if (abyssGuardian == null) {
            WaterEnhanced.LOGGER.warn("Failed to create AbyssGuardianEntity to replace ElderGuardianEntity.");
            return;
        }

        abyssGuardian.refreshPositionAndAngles(
                elderGuardian.getX(),
                elderGuardian.getY(),
                elderGuardian.getZ(),
                elderGuardian.getYaw(),
                elderGuardian.getPitch()
        );

        abyssGuardian.setPersistent();

        world.spawnEntity(abyssGuardian);
        elderGuardian.discard();
    }
}

