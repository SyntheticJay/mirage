package me.jay.command.base;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface CommandInfo {
    /**
     * The name of the command
     *
     * @return The name of the command
     */
    String name();

    /**
     * The description of the command
     *
     * @return The description of the command
     */
    String description();

    /**
     * The usage of the command
     *
     * @return The usage of the command
     */
    String arguments() default "";

    /**
     * The aliases of the command
     *
     * @return The aliases of the command
     */
    String[] aliases() default {};
}
