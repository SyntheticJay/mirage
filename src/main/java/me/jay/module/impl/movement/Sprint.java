package me.jay.module.impl.movement;

import me.jay.event.client.TickEvent;
import me.jay.module.base.MirageModule;
import me.jay.module.base.ModuleCategory;
import me.jay.module.base.ModuleInfo;
import me.zero.alpine.listener.Listener;
import me.zero.alpine.listener.Subscribe;
import me.zero.alpine.listener.Subscriber;
import org.lwjgl.glfw.GLFW;


@ModuleInfo(name = "Sprint", description = "Automatically sprint", category = ModuleCategory.PLAYER, defaultKeyBind = GLFW.GLFW_KEY_V, visable = true)
public class Sprint extends MirageModule implements Subscriber {
    @Subscribe
    private final Listener<TickEvent> tickEventListener = new Listener<>(event -> {
        if (isMoving() && mc.player.getHungerManager().getFoodLevel() >= 6) {
            mc.player.setSprinting(true);
        }
    });

    private boolean isMoving() {
        return (mc.player.forwardSpeed != 0 || mc.player.sidewaysSpeed != 0)
                && !mc.player.isUsingItem() &&
                !mc.player.isRiding() &&
                !mc.player.isSneaking();
    }
}
