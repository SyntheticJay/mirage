package me.jay.command;

import me.jay.Mirage;
import me.jay.command.base.CommandInfo;
import me.jay.command.base.MirageCommand;
import org.reflections.Reflections;

import java.util.HashMap;

public class CommandManager {
    /**
     * The root package for all the commands
     */
    public final String COMMANDS_ROOT = "me.jay.command.impl";

    /**
     * A map of all the commands
     */
    private final HashMap<String, MirageCommand> commands = new HashMap<>();

    /**
     * Load the commands
     */
    public void load() {
        final Reflections reflections = new Reflections(this.COMMANDS_ROOT);

        for (Class<?> clazz : reflections.getTypesAnnotatedWith(CommandInfo.class)) {
            try {
                MirageCommand command = (MirageCommand) clazz.getDeclaredConstructor().newInstance();

                CommandInfo commandInfo = command.getCommandInfo();

                this.commands.put(commandInfo.name(), command);
            } catch (Exception e) {
                Mirage.clientLogger.error("Failed to load command: {}", clazz.getName(), e);
            }
        }
    }

    /**
     * Get an array of all the commands
     */
    public HashMap<String, MirageCommand> getCommands() {
        return commands;
    }
}
