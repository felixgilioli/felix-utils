package io.github.felixgilioli.felixutils.strings;

/**
 * Class with utility methods for working with {@link String}.
 */
public class StringUtils {

    private StringUtils() {
    }

    /**
     * Checks if a string is empty(""), null or whitespace only.
     * @param s string to check.
     * @return true if the string is null, empty or whitespace only.
     */
    public static boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();
    }

    /**
     * Checks if a string is not empty(""), not null and not whitespace only.
     * @param s string to check.
     * @return true if the string is not null, not empty and not whitespace only.
     */
    public static boolean isNotBlank(String s) {
        return s != null && !s.trim().isEmpty();
    }
}
