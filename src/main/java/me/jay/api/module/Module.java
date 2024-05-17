package me.jay.api.module;

import me.jay.Mirage;
import me.zero.alpine.listener.Subscriber;

import net.minecraft.client.MinecraftClient;

public class Module implements Subscriber {
    /**
     * The instance of the Minecraft client
     */
    protected MinecraftClient mc = MinecraftClient.getInstance();

    /**
     * Annotation containing information about the module
     */
    private final ModuleInfo moduleInfo = getClass().getAnnotation(ModuleInfo.class);

    /**
     * The state of the module (enabled or disabled)
     */
    private boolean moduleState;

    /**
     * Module constructor
     */
    public Module() {
        if (!getClass().isAnnotationPresent(ModuleInfo.class)) {
            throw new IllegalStateException("Module class must have ModuleInfo annotation");
        }
    }

    /**
     * Determine if the module is enabled.
     */
    public boolean isEnabled() {
        return this.moduleState;
    }

    /**
     * Set the module state
     *
     * @param newModuleState the new module state
     */
    public void setModuleState(boolean newModuleState) {
        if (newModuleState) {
            this.moduleState = true;
            this.onEnable();

            Mirage.eventBus.subscribe(this);
        } else {
            this.moduleState = false;
            this.onDisable();

            Mirage.eventBus.unsubscribe(this);
        }
    }

    /**
     * Toggle the module state
     */
    public void toggle() {
        setModuleState(!this.moduleState);
    }

    /**
     * Gets the module info
     *
     * @return the module info
     */
    public ModuleInfo getModuleInfo() {
        return moduleInfo;
    }

    /**
     * Fired when the module is enabled
     */
    public void onEnable() {}

    /**
     * Fired when the module is disabled
     */
    public void onDisable() {}
}
