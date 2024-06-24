package me.jay;

import me.jay.command.CommandManager;
import me.jay.module.ModuleManager;
import me.jay.value.ValueManager;
import me.zero.alpine.bus.EventBus;
import me.zero.alpine.bus.EventManager;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The main class for Mirage
 *
 * @author Jay
 */
public class Mirage implements ModInitializer {
	private static Mirage instance;

	/**
	 * Constants
	 */
	public static final String CLIENT_NAME = "Mirage";

	/**
	 * The logger
	 */
    public static final Logger clientLogger = LoggerFactory.getLogger(CLIENT_NAME);

	/**
	 * The event bus
	 */
	public static final EventBus eventBus = EventManager.builder()
			.setName(CLIENT_NAME)
			.build();

	/**
	 * The module manager
	 */
	public final ModuleManager moduleManager = new ModuleManager();

	/**
	 * The value manager
	 */
	public final ValueManager valueManager = new ValueManager();

	/**
	 * The command manager
	 */
	public final CommandManager commandManager = new CommandManager();

	/**
	 * Construct a new Mirage instance
	 */
	public Mirage() {
		instance = this;
	}

	/**
	 * Fires when the client is initialized
	 */
	@Override
	public void onInitialize() {
		this.moduleManager.load();
		this.commandManager.load();

		Runtime.getRuntime().addShutdownHook(new Thread(this::onClientShutdown));
	}

	/**
	 * Fires when the client is shutdown
	 */
	public void onClientShutdown() {
		//
	}

	/**
	 * Get the instance of Mirage
	 *
	 * @return The instance of Mirage
	 */
	public static Mirage getInstance() {
		return instance;
	}
}