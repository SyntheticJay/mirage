package me.jay;

import me.jay.manager.impl.ModuleManager;
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
	/**
	 * The debug mode for the client
	 */
	public static final boolean debug = true;

	/**
	 * The logger for the client
	 */
    public static final Logger clientLogger = LoggerFactory.getLogger("mirage");

	/**
	 * The event bus for the client
	 */
	public static final EventBus eventBus = EventManager.builder().setName("mirage").build();

	/**
	 * The module manager for the client
	 */
	private final ModuleManager moduleManager;

	/**
	 * The constructor for the client
	 */
	public Mirage() {
		this.moduleManager = new ModuleManager();
	}

	/**
	 * Fired when the client is initialized
	 */
	@Override
	public void onInitialize() {
		this.moduleManager.load();

		Runtime.getRuntime().addShutdownHook(new Thread(this::onClientShutdown));
	}

	/**
	 * Fired when the client is shutting down
	 */
	public void onClientShutdown() {
		//
	}

	/**
	 * Gets the module manager for the client
	 *
	 * @return the module manager
	 */
	public ModuleManager getModuleManager() {
		return moduleManager;
	}
}