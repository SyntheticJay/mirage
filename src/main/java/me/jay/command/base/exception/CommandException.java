package me.jay.command.base.exception;

import me.jay.command.base.MirageCommand;

import java.io.Serial;

public abstract class CommandException extends Exception {
    /**
     * The serial version UID
     */
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * The command
     */
    protected MirageCommand command;

    /**
     * Construct a new CommandException instance
     *
     * @param command The command
     */
    public CommandException(MirageCommand command) {
        this.command = command;
    }

    /**
     * Print the exception to the chat
     */
    public abstract void print();
}
