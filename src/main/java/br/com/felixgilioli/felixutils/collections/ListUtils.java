package br.com.felixgilioli.felixutils.collections;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.Objects.requireNonNull;

/**
 * Class with utility methods for working with {@link List}.
 */
public class ListUtils {

    /**
     * Return a new list with the filtered elements.
     * @param list list of elements.
     * @param condition condition to filter the elements.
     * @return list with the filtered elements.
     */
    public static <T> List<T> filter(List<T> list, Predicate<T> condition) {
        requireNonNull(list);
        requireNonNull(condition);

        if (list.isEmpty()) {
            return list;
        }

        return list.stream()
                .filter(condition)
                .collect(Collectors.toList());
    }

}
