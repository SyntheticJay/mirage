package me.jay.module.base;

import org.lwjgl.glfw.GLFW;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

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
    int defaultKeyBind() default GLFW.GLFW_KEY_UNKNOWN;

    /**
     * Determine if the module is visable in the GUI
     */
    boolean visable();
}
