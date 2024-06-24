package me.jay.value.impl;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import me.jay.value.base.Value;
import org.jetbrains.annotations.NotNull;

import java.util.function.Predicate;

public class ModeValue extends Value<Integer> {
    /**
     * The available modes
     */
    private String[] modes;

    /**
     * Construct a new ModeValue instance
     *
     * @param name The name of the value
     * @param defaultVal The default value
     * @param modes The available modes
     */
    public ModeValue(String name, String defaultVal, String... modes) {
        this(name, defaultVal, null, modes);
    }

    /**
     * Construct a new ModeValue instance
     *
     * @param name The name of the value
     * @param defaultVal The default value
     * @param validator The validator
     * @param modes The available modes
     */
    public ModeValue(String name, String defaultVal, Predicate<Integer> validator, String... modes) {
        super(name, 0, validator);

        this.modes = modes;

        setObject(defaultVal);
    }

    /**
     * Get the available modes
     *
     * @return The available modes
     */
    public String[] getModes() {
        return modes;
    }

    /**
     * Set the object
     *
     * @param s The object
     */
    private void setObject(String s) {
        int object = -1;

        for (int i = 0; i < modes.length; i++) {
            String mode = modes[i];

            if (mode.equalsIgnoreCase(s)) object = i;
        }
        if (object == -1) throw new IllegalArgumentException("Value '" + object + "' wasn't found");

        setObject(object);
    }

    /**
     * Get the object as a string
     *
     * @return The object as a string
     */
    @Override
    public boolean setObject(Integer object) {
        if (object < 0 || modes.length <= object) {
            throw new IllegalArgumentException(object + " is not valid (max: " + (modes.length - 1) + ")");
        }

        return super.setObject(object);
    }

    /**
     * Add the mode value to the JsonObject
     *
     * @param jsonObject The JsonObject
     */
    @Override
    public void addToJsonObject(@NotNull JsonObject jsonObject) {
        jsonObject.addProperty(getName(), getObject());
    }

    /**
     * Get the mode value from the JsonObject
     *
     * @param jsonObject The JsonObject
     */
    @Override
    public void fromJsonObject(@NotNull JsonObject jsonObject) {
        if (!jsonObject.has(getName())) {
            throw new IllegalArgumentException("Supposed mode value entry '" + getName() + "' is not present in the JsonObject.");
        }

        JsonElement element = jsonObject.get(getName());

        if (element instanceof JsonPrimitive primitive) {
            if (!primitive.isNumber()) {
                throw new IllegalArgumentException("Supposed mode value entry '" + getName() + "' is not a of number value.");
            }

            setObject(element.getAsInt());
        }
    }
}
