package me.jay.command.base.exception;

import me.jay.Mirage;
import me.jay.command.base.CommandInfo;
import me.jay.command.base.MirageCommand;

public class InvalidSyntaxException extends CommandException {
    /**
     * Construct a new InvalidSyntaxException instance
     *
     * @param command The command that caused the exception
     */
    public InvalidSyntaxException(MirageCommand command) {
        super(command);
    }

    /**
     * Print the exception to chat.
     */
    @Override
    public void print() {
        CommandInfo info = command.getCommandInfo();

        String usage = info.name() + " " + info.arguments();

        Mirage.getInstance().commandManager.sendMessage("Invalid syntax! Usage: " + usage);
    }
}
