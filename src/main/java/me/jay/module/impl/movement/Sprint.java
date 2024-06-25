package me.jay.module.impl.movement;

import me.jay.event.client.TickEvent;
import me.jay.module.base.MirageModule;
import me.jay.module.base.ModuleCategory;
import me.jay.module.base.ModuleInfo;
import me.jay.value.impl.BooleanValue;
import me.zero.alpine.listener.Listener;
import me.zero.alpine.listener.Subscribe;
import me.zero.alpine.listener.Subscriber;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.glfw.GLFW;

@ModuleInfo(name = "Sprint", description = "Automatically sprint", category = ModuleCategory.MOVEMENT, defaultKeyBind = GLFW.GLFW_KEY_V, visable = true)
public class Sprint extends MirageModule implements Subscriber {
    @NotNull
    private final BooleanValue smart = new BooleanValue("Smart", false);

    @Subscribe
    private final Listener<TickEvent> tickEventListener = new Listener<>(event -> {
        boolean hasHunger = mc.player.getHungerManager().getFoodLevel() > 6;

        if (smart.getObject() && hasHunger) {
            if (mc.player.forwardSpeed > 0.0F) {
                mc.player.setSprinting(true);
            }
        } else {
            mc.player.setSprinting(true);
        }
    });
}
