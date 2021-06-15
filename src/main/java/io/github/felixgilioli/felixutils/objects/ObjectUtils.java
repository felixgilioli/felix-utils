package io.github.felixgilioli.felixutils.objects;

import java.util.Objects;
import java.util.function.Predicate;

/**
 * Class with utility methods for working with {@link Object}.
 */
public class ObjectUtils {

    private ObjectUtils() {}

    /**
     * Check that the specified object reference is not null and respect the condition
     * @param obj the object reference to check for condition
     * @return object if not null
     * @throws IllegalArgumentException if object is does not respect the condition
     * @throws NullPointerException if object is null
     */
    public static <T> T checkArgument(T obj, Predicate<T> condition) {
        Objects.requireNonNull(obj);
        Objects.requireNonNull(condition);

        if (!condition.test(obj)) {
            throw new IllegalArgumentException();
        }

        return obj;
    }

    /**
     * Check that the specified object reference is not null and respect the condition
     * @param obj the object reference to check for condition
     * @param message details message to be used in the event that is throws
     * @return object if not null
     * @throws IllegalArgumentException if object is does not respect the condition
     * @throws NullPointerException if object is null
     */
    public static <T> T checkArgument(T obj, Predicate<T> condition, String message) {
        Objects.requireNonNull(message);
        Objects.requireNonNull(obj, message);
        Objects.requireNonNull(condition);

        if (!condition.test(obj)) {
            throw new IllegalArgumentException(message);
        }

        return obj;
    }
}
