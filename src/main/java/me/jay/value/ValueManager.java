package me.jay.value;

import me.jay.Mirage;
import me.jay.value.base.Value;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValueManager {
    private final HashMap<String, List<Value>> values = new HashMap<>();

    /**
     * Register all values from an object
     *
     * @param name   The name of the owner
     * @param object The object where value-fields are declared
     */
    public void registerObject(String name, Object object) {
        List<Value> values = new ArrayList<>();

        for (final Field field : object.getClass().getDeclaredFields()) {
            try {
                field.setAccessible(true);

                final Object obj = field.get(object);

                if (obj instanceof Value) values.add((Value) obj);
            } catch (IllegalAccessException e) {
                Mirage.clientLogger.error("ValueManager: Failed to access field: " + field.getName());
            }
        }

        this.values.put(name, values);
    }

    /**
     * Get all values from an owner
     *
     * @param name The name of the owner
     * @return If there's an owner with this name (the case is ignored) it will return all values of it else it will return null
     */
    public List<Value> getAllValuesFrom(String name) {
        for (Map.Entry<String, List<Value>> stringListEntry : values.entrySet()) {
            if (stringListEntry.getKey().equalsIgnoreCase(name)) return stringListEntry.getValue();
        }

        return null;
    }

    /**
     * Get a value from an owner
     *
     * @param owner The name of the owner
     * @param name  The name of the value
     * @return The value or null
     */
    public Value get(String owner, String name) {
        List<Value> found = getAllValuesFrom(owner);

        if (found == null) return null;

        return found.stream().filter(val -> name.equalsIgnoreCase(val.getName())).findFirst().orElse(null);
    }
}
