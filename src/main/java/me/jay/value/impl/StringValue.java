package me.jay.value.impl;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import me.jay.value.base.Value;
import org.jetbrains.annotations.NotNull;

import java.util.function.Predicate;

public class StringValue extends Value<String> {
    /**
     * Construct a new StringValue instance
     *
     * @param name The name of the value
     * @param defaultVal The default value
     */
    public StringValue(String name, String defaultVal) {
        this(name, defaultVal, null);
    }

    /**
     * Construct a new StringValue instance
     *
     * @param name The name of the value
     * @param defaultVal The default value
     * @param validator The validator
     */
    public StringValue(String name, String defaultVal, Predicate<String> validator) {
        super(name, defaultVal, validator);
    }

    /**
     * Add the string value to the JsonObject
     *
     * @param jsonObject The JsonObject
     */
    @Override
    public void addToJsonObject(@NotNull JsonObject jsonObject) {
        jsonObject.addProperty(getName(), getObject());
    }

    /**
     * Get the string value from the JsonObject
     *
     * @param jsonObject The JsonObject
     */
    @Override
    public void fromJsonObject(@NotNull JsonObject jsonObject) {
        if (!jsonObject.has(getName())) {
            throw new IllegalArgumentException("Supposed string value entry " + getName() + " is not present in the JsonObject.");
        }

        JsonElement element = jsonObject.get(getName());

        if (element instanceof JsonPrimitive primitive) {
            if (!primitive.isString()) {
                throw new IllegalArgumentException("Supposed string value entry " + getName() + " is not a of string value.");
            }

            setObject(primitive.getAsString());
        }
    }
}
