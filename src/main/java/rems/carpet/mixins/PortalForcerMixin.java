package rems.carpet.mixins;

import rems.carpet.REMSSettings;
import net.minecraft.block.BlockState;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockLocating;
import net.minecraft.world.PortalForcer;
import net.minecraft.world.poi.PointOfInterest;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.function.Predicate;
import java.util.stream.Stream;

@Mixin(PortalForcer.class)
public class PortalForcerMixin
{
    @Shadow
    @Final
    private ServerWorld world;

    @Redirect(
            method = "getPortalRect",
            at = @At(
                    value = "INVOKE",
                    target = "Ljava/util/stream/Stream;filter(Ljava/util/function/Predicate;)Ljava/util/stream/Stream;"
            )
    )
    private Stream<PointOfInterest> dummyFilter(Stream<PointOfInterest> pointOfInterestStream,
                                                Predicate<PointOfInterest> pointOfInterestPredicate) {
        return REMSSettings.teleportToPoiWithoutPortals ?
                pointOfInterestStream :
                pointOfInterestStream.filter(pointOfInterestPredicate);
    }

    @Redirect(
            method = "method_30479", // This is a lambda
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/block/BlockState;get(Lnet/minecraft/state/property/Property;)Ljava/lang/Comparable;"
            )
    )
    private Comparable<?> dummyGet(BlockState blockState, Property<Direction.Axis> property) {
        if (REMSSettings.teleportToPoiWithoutPortals && !blockState.contains(Properties.HORIZONTAL_AXIS))
            return Direction.Axis.Z;
        return blockState.get(property);
    }

    @Redirect(
            method = "method_30479", // This is a lambda
            at = @At(
                    value = "INVOKE",
                    target = "net/minecraft/world/BlockLocating.getLargestRectangle(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/util/math/Direction$Axis;ILnet/minecraft/util/math/Direction$Axis;ILjava/util/function/Predicate;)Lnet/minecraft/world/BlockLocating$Rectangle;"
            )
    )
    private BlockLocating.Rectangle dummyReturn(BlockPos blockPos, Direction.Axis axis1, int i,
                                                Direction.Axis axis2, int j, Predicate<BlockPos> predicate) {
        if (REMSSettings.teleportToPoiWithoutPortals
                && !this.world.getBlockState(blockPos).contains(Properties.HORIZONTAL_AXIS))
            return new BlockLocating.Rectangle(blockPos, 1, 1);
        return BlockLocating.getLargestRectangle(blockPos, axis1, i, axis2, j, predicate);
    }
}
