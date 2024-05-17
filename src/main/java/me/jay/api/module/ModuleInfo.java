package me.jay.api.module;

import net.minecraft.client.option.KeyBinding;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * An annotation to provide information about a module
 *
 * @author Jay
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface ModuleInfo {
    /**
     * The name of the client
     */
    String name();

    /**
     * The description of the client
     */
    String description();

    /**
     * The category of the module
     */
    ModuleCategory category() default ModuleCategory.MISC;

    /**
     * The default key-bind of the module
     */
    int defaultKeyBind() default -1;

    /**
     * Determine if the module is visable in the GUI
     */
    boolean visable();
}
