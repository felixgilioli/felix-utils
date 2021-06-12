package br.com.felixgilioli.felixutils.collections;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.Objects.requireNonNull;

/**
 * Class with utility methods for working with {@link List}.
 */
public class ListUtils {

    /**
     * Return a new list with the filtered elements.
     * @param collection collection of elements.
     * @param condition condition to filter the elements.
     * @return list with the filtered elements.
     */
    public static <T> List<T> filter(Collection<T> collection, Predicate<T> condition) {
        requireNonNull(collection);
        requireNonNull(condition);

        if (collection.isEmpty()) {
            return Collections.emptyList();
        }

        return collection.stream()
                .filter(condition)
                .collect(Collectors.toList());
    }

    /**
     * Return a new list with the new elements.
     * @param collection collection of elements.
     * @param mapper new element.
     * @return list with the new elements.
     */
    public static <T, S> List<T> map(Collection<S> collection, Function<S, T> mapper) {
        requireNonNull(collection);
        requireNonNull(mapper);

        if (collection.isEmpty()) {
            return Collections.emptyList();
        }

        return collection.stream()
                .map(mapper)
                .collect(Collectors.toList());
    }

}
