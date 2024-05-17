package me.jay.api.module;

public enum ModuleCategory {
    COMBAT("Combat", 0xFF0000),
    MOVEMENT("Movement", 0x00FF00),
    PLAYER("Player", 0x0000FF),
    RENDER("Render", 0xFF00FF),
    MISC("Misc", 0xFFFF00);

    /**
     * The name of the category
     */
    private final String name;

    /**
     * The color of the category
     */
    private final int color;

    /**
     * Constructs a new ModuleCategory
     *
     * @param name the name of the category
     * @param color the color of the category
     */
    ModuleCategory(String name, int color) {
        this.name = name;
        this.color = color;
    }

    /**
     * Gets the name of the category
     *
     * @return the name of the category
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the color of the category
     *
     * @return the color of the category
     */
    public int getColor() {
        return color;
    }
}
