package me.jay.value.base;

import com.google.gson.JsonObject;

import java.util.function.Predicate;

public abstract class Value<T> {
    /**
     * The name of the value
     */
    private final String name;

    /**
     * The object
     */
    private T object;

    /**
     * The default value
     */
    private final T defaultValue;

    /**
     * The validator
     */
    private Predicate<T> validator;

    /**
     * Construct a new Value instance
     *
     * @param name The name of the value
     * @param defaultValue The default value
     * @param validator The validator
     */
    public Value(String name, T defaultValue, Predicate<T> validator) {
        this.name = name;
        this.object = defaultValue;
        this.defaultValue = defaultValue;
        this.validator = validator;
    }

    /**
     * Get the name of the value
     *
     * @return The name of the value
     */
    public String getName() {
        return name;
    }

    /**
     * Get the object
     *
     * @return The object
     */
    public T getObject() {
        return object;
    }

    /**
     * Set the object
     *
     * @param object The object
     */
    public boolean setObject(T object) {
        if (validator != null && !validator.test(object)) return false;

        this.object = object;

        return true;
    }

    /**
     * Set the validator
     *
     * @param validator The validator
     */
    public void setValidator(Predicate<T> validator) {
        this.validator = validator;
    }

    /**
     * Get the default value
     *
     * @return The default value
     */
    public T getDefaultValue() {
        return defaultValue;
    }

    /**
     * Add the value to a JsonObject
     *
     * @param jsonObject The JsonObject
     */
    public abstract void addToJsonObject(JsonObject jsonObject);

    /**
     * Get the value from a JsonObject
     *
     * @param jsonObject The JsonObject
     */
    public abstract void fromJsonObject(JsonObject jsonObject);
}
