package me.jay.command.base;

public abstract class MirageCommand {
    /**
     * The command information
     */
    private final CommandInfo commandInfo;

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
     * Determine if the input matches the command
     *
     * @param input The input
     *
     * @return Whether the input matches the command
     */
    public boolean hasMatch(String input) {
        for (String alias : commandInfo.aliases()) {
            if (alias.equalsIgnoreCase(input)) return true;
        }

        return false;
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
     *
     * @param args The arguments
     */
    public abstract void fire(String[] args);
}
