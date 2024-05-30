package me.jay.mixin.client;

import me.jay.Mirage;
import me.jay.event.client.KeyPressEvent;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Keyboard;

import net.minecraft.client.MinecraftClient;
import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Keyboard.class)
@Environment(EnvType.CLIENT)
public class MixinKeyboard {
    @Inject(method = "onKey", at = @At("HEAD"))
    public void hookKeyboardKey(long window, int key, int scancode, int i, int j, CallbackInfo callback) {
        Mirage.eventBus.post(new KeyPressEvent(window, key, scancode, i, j));
    }
}
