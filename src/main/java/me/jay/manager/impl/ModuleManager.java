package me.jay.manager.impl;

import me.jay.Mirage;
import me.jay.event.client.KeyPressEvent;
import me.jay.manager.base.IManagerLoadable;
import me.jay.module.base.Module;
import me.zero.alpine.listener.Listener;
import org.reflections.Reflections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A manager for all the modules
 *
 * @author Jay
 */
public class ModuleManager implements IManagerLoadable {
    /**
     * A map of all the modules
     */
    private final HashMap<Class<? extends Module>, Module> modules = new HashMap<>();

    /**
     * Init the ModuleManager
     */
    @Override
    public void load() {
        final Reflections reflections = new Reflections("me.jay.module");

        for (Class<? extends Module> clazz : reflections.getSubTypesOf(Module.class)) {
            try {
                Module module = clazz.newInstance();

                modules.put(clazz, module);

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
    public List<Module> getModules() {
        return new ArrayList<>(modules.values());
    }

    /**
     * The event listener for key press events
     */
    private Listener<KeyPressEvent> keyPressListener = new Listener<>(event -> {
        for (Module module : modules.values9)
    });
}
