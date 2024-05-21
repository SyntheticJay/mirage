package me.jay.event.client;

public class KeyPressEvent {
    private final long window;
    private final int key;
    private final int scancode;
    private final int i;
    private final int j;

    public KeyPressEvent(long window, int key, int scancode, int i, int j) {
        this.window = window;
        this.key = key;
        this.scancode = scancode;
        this.i = i;
        this.j = j;
    }

    public long getWindow() {
        return window;
    }

    public int getKey() {
        return key;
    }

    public int getScancode() {
        return scancode;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }
}
