package me.jay.mixin.client;

import me.jay.Mirage;
import me.jay.event.client.TickEvent;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.world.ClientWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {
    @Shadow
    public ClientWorld world;

    @Inject(at = @At("TAIL"), method = "tick()V")
    public void tick(CallbackInfo callbackInfo) {
        if (this.world != null) {
            Mirage.eventBus.post(new TickEvent());
        }
    }
}
