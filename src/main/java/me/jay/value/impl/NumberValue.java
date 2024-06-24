package me.jay.value.impl;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import me.jay.value.base.Value;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Predicate;

public class NumberValue<T extends Number> extends Value<T> {
    /**
     * The minimum value
     */
    private final T minimum;

    /**
     * The maximum value
     */
    private final T maximum;

    public NumberValue(String name, T defaultVal, @NotNull T min, @NotNull T max) {
        this(name, defaultVal, min, max, null);
    }

    public NumberValue(String name, T defaultVal, @NotNull T minimum, @NotNull T maximum, @Nullable Predicate<T> validator) {
        super(name, defaultVal,
                validator == null ?
                        val -> val.doubleValue() >= minimum.doubleValue() && val.doubleValue() <= maximum.doubleValue() :
                        validator.and(val -> val.doubleValue() >= minimum.doubleValue() && val.doubleValue() <= maximum.doubleValue())
        );

        this.minimum = minimum;
        this.maximum = maximum;
    }

    public T getMinimum() {
        return minimum;
    }

    public T getMaximum() {
        return maximum;
    }

    @Override
    public void addToJsonObject(JsonObject jsonObject) {
        jsonObject.addProperty(getName(), getObject());
    }

    @Override
    public void fromJsonObject(JsonObject jsonObject) {
        if (!jsonObject.has(getName())) {
            throw new IllegalArgumentException("Supposed number value entry " + getName() + " is not present in the JsonObject.");
        }

        JsonElement element = jsonObject.get(getName());

        if (element instanceof JsonPrimitive primitive) {
            if (!primitive.isNumber()) {
                throw new IllegalArgumentException("Supposed number value entry " + getName() + " is not a of number value.");
            }

            if (getObject() instanceof Integer) {
                setObject((T) Integer.valueOf(jsonObject.get(getName()).getAsNumber().intValue()));
            }

            if (getObject() instanceof Long) {
                setObject((T) Long.valueOf(jsonObject.get(getName()).getAsNumber().longValue()));
            }

            if (getObject() instanceof Float) {
                setObject((T) Float.valueOf(jsonObject.get(getName()).getAsNumber().floatValue()));
            }

            if (getObject() instanceof Double) {
                setObject((T) Double.valueOf(jsonObject.get(getName()).getAsNumber().doubleValue()));
            }
        }
    }
}
