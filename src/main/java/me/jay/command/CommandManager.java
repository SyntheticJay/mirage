package me.jay.command;

import me.jay.Mirage;
import me.jay.command.base.CommandInfo;
import me.jay.command.base.MirageCommand;
import me.jay.command.base.exception.InvalidSyntaxException;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import org.reflections.Reflections;

import java.util.HashMap;

public class CommandManager {
    /**
     * The prefix for all the commands
     */
    public static final String PREFIX = ".";

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
     *
     * @return An array of all the commands
     */
    public HashMap<String, MirageCommand> getCommands() {
        return commands;
    }

    /**
     * Handle a chat message
     */
    public void handleChat(String chatText) {
        String[] split = chatText.substring(1).split(" ");

        String commandName = split[0];

        MirageCommand command = this.findCommand(commandName);

        if (command == null) return;

        String[] args = new String[split.length - 1];

        System.arraycopy(split, 1, args, 0, args.length);

        try {
            command.handle(args);
        } catch (InvalidSyntaxException e) {
            e.print();
        }
    }

    private MirageCommand findCommand(String commandName) {
        if (this.commands.containsKey(commandName)) return this.commands.get(commandName);

        for (MirageCommand command : this.commands.values()) {
            CommandInfo commandInfo = command.getCommandInfo();

            for (String alias : commandInfo.aliases()) {
                if (alias.equalsIgnoreCase(commandName)) {
                    return command;
                }
            }
        }

        return null;
    }

    /**
     * Send a message to the chat
     *
     * @param msg The message to send
     */
    public void sendMessage(String msg) {
        MinecraftClient mc = MinecraftClient.getInstance();

        if (mc.inGameHud == null) return;

        Text text = Text.of(Formatting.DARK_BLUE + "[" + Formatting.BLUE + "Mirage" + Formatting.DARK_BLUE + "] " + Formatting.RESET + msg);

        mc.inGameHud.getChatHud().addMessage(text);
    }
}
