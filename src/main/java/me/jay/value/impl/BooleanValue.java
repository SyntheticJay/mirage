package me.jay.value.impl;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import me.jay.value.base.Value;

public class BooleanValue extends Value<Boolean> {
    /**
     * Construct a new BooleanValue instance
     *
     * @param name The name of the value
     * @param defaultValue The default value
     */
    public BooleanValue(String name, boolean defaultValue) {
        super(name, defaultValue, null);
    }

    /**
     * Add the boolean value to the JsonObject
     *
     * @param jsonObject The JsonObject
     */
    @Override
    public void addToJsonObject(JsonObject jsonObject) {
        jsonObject.addProperty(getName(), getObject());
    }

    /**
     * Get the boolean value from the JsonObject
     *
     * @param jsonObject The JsonObject
     */
    @Override
    public void fromJsonObject(JsonObject jsonObject) {
        if (!jsonObject.has(getName())) {
            throw new IllegalArgumentException("Supposed boolean value entry " + getName() + " is not present in the JsonObject.");
        }

        JsonElement element = jsonObject.get(getName());

        if (element instanceof JsonPrimitive primitive) {
            if (!primitive.isBoolean()) {
                throw new IllegalArgumentException("Supposed boolean value entry " + getName() + " is not a of boolean value.");
            }

            setObject(primitive.getAsBoolean());
        }
    }
}
