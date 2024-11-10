package rems.carpet.utils;

import net.minecraft.server.world.ChunkTicketType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.ChunkPos;

import java.util.Comparator;

public class PistonChunkUtility
{
    public static final ChunkTicketType<ChunkPos> PISTON_BLOCK_TICKET = ChunkTicketType.create("piston_block", Comparator.comparingLong(ChunkPos::toLong), 60);

    public static final int DiamondOreHash = new Identifier("minecraft", "diamond_ore").hashCode();

    public static final int GoldOreHash = new Identifier("minecraft", "gold_ore").hashCode();

    public static final int EmeraldOreHash = new Identifier("minecraft", "emerald_ore").hashCode();
}