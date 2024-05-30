package me.jay.event.client;

/**
 * A key press event
 *
 * @param window The window
 * @param key The key
 * @param scancode The scancode
 * @param i The i value
 * @param j The j value
 */
public record KeyPressEvent(long window, int key, int scancode, int i, int j) { }
