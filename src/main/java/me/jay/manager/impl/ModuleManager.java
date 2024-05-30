package me.jay.manager.impl;

import me.jay.Mirage;
import me.jay.event.client.KeyPressEvent;
import me.jay.manager.base.IManagerLoadable;
import me.jay.module.base.Module;
import me.zero.alpine.listener.Listener;
import me.zero.alpine.listener.Subscribe;
import me.zero.alpine.listener.Subscriber;
import net.minecraft.client.MinecraftClient;
import org.lwjgl.glfw.GLFW;
import org.reflections.Reflections;

import java.util.ArrayList;

/**
 * A manager for all the modules
 *
 * @author Jay
 */
public class ModuleManager implements IManagerLoadable, Subscriber {
    /**
     * Constructor a new ModuleManager
     */
    public ModuleManager() {
        Mirage.eventBus.subscribe(this);
    }

    /**
     * A map of all the modules
     */
    private final ArrayList<Module> modules = new ArrayList<>();

    /**
     * Init the ModuleManager
     */
    @Override
    public void load() {
        final Reflections reflections = new Reflections("me.jay.module.impl");

        for (Class<? extends Module> clazz : reflections.getSubTypesOf(Module.class)) {
            try {
                Module module = clazz.newInstance();

                modules.add(module);

                Mirage.clientLogger.info("Loaded module: {}", clazz.getSimpleName());
            } catch (Exception e) {
                Mirage.clientLogger.error("Failed to load module: {}", clazz.getSimpleName());

                if (Mirage.debug) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Get an array of all the modules
     */
    public ArrayList<Module> getModules() {
        return this.modules;
    }

    /**
     * The event listener for key press events
     */
    @Subscribe
    private Listener<KeyPressEvent> keyPressListener = new Listener<>(event -> {
        boolean inGame = MinecraftClient.getInstance().world != null;
        boolean pressed = event.i() == GLFW.GLFW_PRESS;

        if (inGame && pressed) this.modules.stream().filter(m -> m.getModuleInfo().defaultKeyBind() == event.key()).forEach(Module::toggle);
    });
}
