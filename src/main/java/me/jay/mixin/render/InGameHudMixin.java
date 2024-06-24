package me.jay.mixin.render;

import me.jay.Mirage;
import me.jay.event.render.Render2DEvent;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class InGameHudMixin {
    @Inject(method = "render", at = @At("RETURN"))
    public void renderHud(DrawContext context, float tickDelta, CallbackInfo ci) {
        Mirage.eventBus.post(new Render2DEvent(context, tickDelta));
    }
}
