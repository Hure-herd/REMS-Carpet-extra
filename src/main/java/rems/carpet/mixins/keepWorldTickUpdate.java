
package rems.carpet.mixins;

import net.minecraft.server.world.ServerWorld;
import rems.carpet.REMSSettings;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerWorld.class)
public abstract class keepWorldTickUpdate {

    @Shadow
    public abstract void resetIdleTimeout();

    @Inject(method = "tick", at = @At("HEAD"))
    private void tick(CallbackInfo ci) {
        if (REMSSettings.keepWorldTickUpdate) {
            this.resetIdleTimeout();
        }
    }
}
