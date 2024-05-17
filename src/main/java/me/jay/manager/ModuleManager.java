package me.jay.manager;

import me.jay.Mirage;
import me.jay.api.manager.IManagerLoadable;
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
            } catch (InstantiationException | IllegalAccessException e) {
                Mirage.clientLogger.error("Failed to load module: {}", clazz.getSimpleName());

                if (Mirage.DEBUG) {
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
}
