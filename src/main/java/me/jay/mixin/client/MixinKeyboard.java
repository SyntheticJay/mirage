package me.jay.mixin.client;

import me.jay.Mirage;
import me.jay.event.client.KeyPressEvent;
import net.minecraft.client.Keyboard;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Keyboard.class)
public class MixinKeyboard {
    @Inject(method = "onKey", at = @At(value = "FIELD", target = "Lnet/minecraft/client/MinecraftClient;currentScreen:Lnet/minecraft/client/gui/screen/Screen;", shift = At.Shift.BEFORE, ordinal = 0))
    public void hookKeyboardKey(long window, int key, int scancode, int i, int j, CallbackInfo callback) {
        KeyPressEvent event = new KeyPressEvent(window, key, scancode, i, j);

        Mirage.clientLogger.info("Key: {} Scancode: {} i: {} j: {}", key, scancode, i, j);

        Mirage.eventBus.post(event);
    }
}
