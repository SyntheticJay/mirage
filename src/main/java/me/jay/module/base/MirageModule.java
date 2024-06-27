package me.jay.module.base;

import me.jay.Mirage;
import me.zero.alpine.listener.Subscriber;

import net.minecraft.client.MinecraftClient;

public class MirageModule implements Subscriber {
    /**
     * The instance of the Minecraft client
     */
    protected MinecraftClient mc = MinecraftClient.getInstance();

    /**
     * The instance of the Mirage client
     */
    protected Mirage mirage = Mirage.getInstance();

    /**
     * Annotation containing information about the module
     */
    private final ModuleInfo moduleInfo;

    /**
     * The state of the module (enabled or disabled)
     */
    private boolean moduleState;

    /**
     * The suffix of the module
     */
    private String suffix;

    /**
     * MirageModule constructor
     */
    public MirageModule() {
        if (!getClass().isAnnotationPresent(ModuleInfo.class)) {
            throw new IllegalStateException("Module class must have ModuleInfo annotation");
        }

        this.moduleInfo = getClass().getAnnotation(ModuleInfo.class);
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
            Mirage.eventBus.subscribe(this);

            this.moduleState = true;

            this.onEnable();
        } else {
            Mirage.eventBus.unsubscribe(this);

            this.moduleState = false;

            this.onDisable();
        }
    }

    /**
     * Get the module suffix
     *
     * @return the module suffix
     */
    public String getSuffix() {
        return this.suffix;
    }

    /**
     * Set the module suffix
     *
     * @param suffix the new module suffix
     */
    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    /**
     * Toggle the module state
     */
    public void toggle() {
        boolean newState = !this.moduleState;

        setModuleState(newState);
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
