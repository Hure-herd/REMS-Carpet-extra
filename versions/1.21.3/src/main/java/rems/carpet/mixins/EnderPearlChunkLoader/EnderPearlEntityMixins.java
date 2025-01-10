/*
 * This file is part of the Carpet REMS Addition project, licensed under the
 * GNU Lesser General Public License v3.0
 *
 * Copyright (C) 2025 A Minecraft Server and contributors
 *
 * Carpet REMS Addition is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Carpet REMS Addition is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Carpet REMS Addition. If not, see <https://www.gnu.org/licenses/>.
 */

package rems.carpet.mixins.EnderPearlChunkLoader;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.thrown.EnderPearlEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import rems.carpet.REMSSettings;
import top.byteeeee.annotationtoolbox.annotation.GameVersion;

import java.util.Objects;

@GameVersion(version = "Minecraft >= 1.21.2")
@Mixin(EnderPearlEntity.class)
public class EnderPearlEntityMixins extends ThrownItemEntity {


    protected Item getDefaultItem() {
        return Items.ENDER_PEARL;
    }

    public EnderPearlEntityMixins(EntityType<? extends EnderPearlEntity> entityType, World world) {
        super(entityType, world);
    }

    @Redirect(method = "tick",
            at= @At(value = "INVOKE",
                    target = "Lnet/minecraft/server/network/ServerPlayerEntity;handleThrownEnderPearl(Lnet/minecraft/entity/projectile/thrown/EnderPearlEntity;)J"))
    private long load(ServerPlayerEntity instance, EnderPearlEntity enderPearl){
        if((Objects.equals(REMSSettings.pearlTickets, "ON"))){
            int pearlBlockX = (int) Math.floor(enderPearl.getX());
            int pearlBlockZ = (int) Math.floor(enderPearl.getZ());
            double pearlX = enderPearl.getX();
            double pearlZ = enderPearl.getZ();
            double blockMinX = pearlBlockX;
            double blockMaxX = blockMinX + 1;
            double blockMinZ = pearlBlockZ;
            double blockMaxZ = blockMinZ + 1;
            if(pearlX >= blockMinX && pearlX < blockMaxX && pearlZ >= blockMinZ && pearlZ < blockMaxZ) {
                return instance.handleThrownEnderPearl(enderPearl);
            }
            else{
                return 0;
            }
        } else {
            return instance.handleThrownEnderPearl(enderPearl);
        }
    }
}

