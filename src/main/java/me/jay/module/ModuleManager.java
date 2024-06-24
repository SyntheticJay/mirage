package me.jay.module;

import me.jay.Mirage;
import me.jay.event.client.KeyPressEvent;
import me.jay.module.base.MirageModule;
import me.jay.module.base.ModuleCategory;
import me.jay.module.base.ModuleInfo;
import me.zero.alpine.listener.Listener;
import me.zero.alpine.listener.Subscribe;
import me.zero.alpine.listener.Subscriber;
import net.minecraft.client.MinecraftClient;
import org.lwjgl.glfw.GLFW;
import org.reflections.Reflections;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A manager for all the modules
 *
 * @author Jay
 */
public class ModuleManager implements Subscriber {
    /**
     * The root package for all the modules
     */
    public String MODULES_ROOT = "me.jay.module.impl";

    /**
     * A map of all the modules
     */
    private final HashMap<ModuleCategory, ArrayList<MirageModule>> moduleMap = new HashMap<>();

    /**
     * ModuleManager constructor
     */
    public ModuleManager() {
        Mirage.eventBus.subscribe(this);
    }

    /**
     * Init the ModuleManager
     */
    public void load() {
        final Reflections reflections = new Reflections(this.MODULES_ROOT);

        for (Class<?> clazz : reflections.getTypesAnnotatedWith(ModuleInfo.class)) {
            try {
                MirageModule module = (MirageModule) clazz.getDeclaredConstructor().newInstance();

                ModuleInfo moduleInfo = module.getModuleInfo();

                ModuleCategory category = moduleInfo.category();

                if (!this.moduleMap.containsKey(category)) this.moduleMap.put(category, new ArrayList<>());

                this.moduleMap.get(category).add(module);

                Mirage.getInstance().valueManager.registerObject(moduleInfo.name(), module);

                Mirage.clientLogger.info("Loaded module: {} in category {}", clazz.getName(), category.name());
            } catch (Exception e) {
                Mirage.clientLogger.error("Failed to load module: {}", clazz.getName(), e);
            }
        }
    }

    /**
     * Get an array of all the modules
     */
    public HashMap<ModuleCategory, ArrayList<MirageModule>> getModules() {
        return this.moduleMap;
    }

    /**
     * The event listener for key press events
     */
    @Subscribe
    private Listener<KeyPressEvent> keyPressListener = new Listener<>(event -> {
        boolean inGame = MinecraftClient.getInstance().world != null;
        boolean keyPressed = event.i() == GLFW.GLFW_PRESS;

        if (inGame && keyPressed) {
            this.moduleMap.values()
                    .stream()
                    .flatMap(ArrayList::stream)
                    .filter(m -> m.getModuleInfo().defaultKeyBind() == event.key())
                    .forEach(MirageModule::toggle);
        }
    });
}
