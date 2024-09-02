package rems.carpet.utils;

import net.minecraft.server.world.ChunkTicketType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.ChunkPos;

import java.util.Comparator;

public class PistonChunkUtility
{
    public static final ChunkTicketType<ChunkPos> PISTON_BLOCK_TICKET = ChunkTicketType.create("piston_block", Comparator.comparingLong(ChunkPos::toLong), 30);

    public static final int obsidianHash = new Identifier("minecraft", "diamond_ore").hashCode();
}