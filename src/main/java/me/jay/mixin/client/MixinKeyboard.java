package me.jay.mixin.client;

import me.jay.Mirage;
import me.jay.event.client.KeyPressEvent;
import net.minecraft.client.Keyboard;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Keyboard.class)
public class MixinKeyboard {
    @Inject(method = "onKey", at = @At("HEAD"))
    public void hookKeyboardKey(long window, int key, int scancode, int i, int j, CallbackInfo callback) {
        Mirage.eventBus.post(new KeyPressEvent(window, key, scancode, i, j));
    }
}
