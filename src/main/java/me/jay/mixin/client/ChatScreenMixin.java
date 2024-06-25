package me.jay.mixin.client;

import me.jay.Mirage;
import me.jay.command.CommandManager;
import net.minecraft.client.gui.screen.ChatScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import javax.security.auth.callback.Callback;

@Mixin(ChatScreen.class)
public class ChatScreenMixin {
    @Inject(at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/hud/ChatHud;addToMessageHistory(Ljava/lang/String;)V", shift = At.Shift.AFTER), method = "sendMessage(Ljava/lang/String;Z)V", cancellable = true)
    public void onSendMessage(String chatText, boolean addToHistory, CallbackInfo ci) {
        if (chatText.startsWith(CommandManager.PREFIX)) {
            Mirage.getInstance().commandManager.handleChat(chatText);

            ci.cancel();
        }
    }
}
