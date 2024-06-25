package me.jay.command.base;

import me.jay.Mirage;
import me.jay.command.base.exception.InvalidSyntaxException;
import net.minecraft.client.MinecraftClient;

import java.util.ArrayList;

public abstract class MirageCommand {
    /**
     * The command information
     */
    private final CommandInfo commandInfo;

    /**
     * The Minecraft client instance
     */
    protected MinecraftClient mc = MinecraftClient.getInstance();

    /**
     * The Mirage instance
     */
    protected Mirage mirage = Mirage.getInstance();

    /**
     * Construct a new MirageCommand instance
     */
    public MirageCommand() {
        if (!getClass().isAnnotationPresent(CommandInfo.class)) {
            throw new IllegalStateException("No CommandInfo annotation found on " + getClass().getSimpleName());
        }

        this.commandInfo = getClass().getAnnotation(CommandInfo.class);
    }

    /**
     * Get the command information
     *
     * @return The command information
     */
    public CommandInfo getCommandInfo() {
        return commandInfo;
    }

    /**
     * Fire the command
     */
    public abstract void handle(String... args) throws InvalidSyntaxException;
}
