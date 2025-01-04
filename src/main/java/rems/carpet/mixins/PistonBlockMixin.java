package rems.carpet.mixins;

import rems.carpet.REMSSettings;
import rems.carpet.utils.PistonChunkUtility;
import net.minecraft.block.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Direction;
import net.minecraft.registry.Registries;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Objects;


@Mixin(PistonBlock.class)
public abstract class PistonBlockMixin
{
    @Inject(method = "onSyncedBlockEvent", at = @At("HEAD"))
    private void load(BlockState state, World world, BlockPos pos, int type, int data, CallbackInfoReturnable info)
    {
        if((Objects.equals(REMSSettings.pistonBlockChunkLoader, "ON")) && !world.isClient)
        {
            Direction direction = state.get(FacingBlock.FACING);

            BlockPos nbp = new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ());
            Block block = world.getBlockState(nbp).getBlock();

            if (Registries.BLOCK.getId(block).hashCode() == PistonChunkUtility.DiamondOreHash)
            {
                int x = pos.getX() + direction.getOffsetX();
                int z = pos.getZ() + direction.getOffsetZ();

                ChunkPos cp = new ChunkPos(x >> 4, z >> 4);
                ((ServerWorld) world).getChunkManager().addTicket(PistonChunkUtility.PISTON_BLOCK_TICKET, cp, 1, cp);
            }
            if (Registries.BLOCK.getId(block).hashCode() == PistonChunkUtility.RedStoneOreHash)
            {
                int x = pos.getX() + direction.getOffsetX();
                int z = pos.getZ() + direction.getOffsetZ();

                ChunkPos cp = new ChunkPos(x >> 4, z >> 4);
                ((ServerWorld) world).getChunkManager().addTicket(PistonChunkUtility.PISTON_BLOCK_TICKETS, cp, 3, cp);
            }
            if (Registries.BLOCK.getId(block).hashCode() == PistonChunkUtility.GoldOreHash)
            {
                int x = pos.getX() + direction.getOffsetX();
                int z = pos.getZ() + direction.getOffsetZ();

                ChunkPos cp = new ChunkPos(x >> 4, z >> 4);
                ((ServerWorld) world).getChunkManager().addTicket(PistonChunkUtility.PISTON_BLOCK_TICKETS, cp, 2, cp);
            }
        }
    }
}
