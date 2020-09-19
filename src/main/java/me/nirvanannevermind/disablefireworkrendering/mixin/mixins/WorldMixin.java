package me.nirvanannevermind.disablefireworkrendering.mixin.mixins;

import me.nirvanannevermind.disablefireworkrendering.DisableFireworkRendering;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityFireworkRocket;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(World.class)
public abstract class WorldMixin {

    // cancel spawning rockets
    @Inject(method = "spawnEntity", at = @At("HEAD"), cancellable = true)
    public void spawnEntity(Entity entityIn, CallbackInfoReturnable<Boolean> cir) {
       if(DisableFireworkRendering.INSTANCE.enabled && entityIn instanceof EntityFireworkRocket) {
           cir.cancel();
       }
    }

    // cancel ticking rockets
    @Inject(method = "updateEntity", at = @At("HEAD"), cancellable = true)
    public void updateEntity(Entity ent, CallbackInfo ci) {
        if(DisableFireworkRendering.INSTANCE.enabled && ent instanceof EntityFireworkRocket) {
            ci.cancel();
        }
    }
}
