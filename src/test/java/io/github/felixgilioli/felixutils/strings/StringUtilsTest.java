package io.github.felixgilioli.felixutils.strings;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("StringUtils")
class StringUtilsTest {

    @Test
    @DisplayName("'isBlank' when string passed is null")
    void isBlankWhenStringIsNull() {
        boolean isBlank = StringUtils.isBlank(null);
        assertTrue(isBlank);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "     "})
    @DisplayName("'isBlank' when string passed is blank")
    void isBlankWhenStringIsBlank(String s) {
        boolean isBlank = StringUtils.isBlank(s);
        assertTrue(isBlank);
    }

    @ParameterizedTest
    @ValueSource(strings = {".", "Felix", "Felix Gilioli"})
    @DisplayName("'isBlank' when string passed is not blank")
    void isBlankWhenStringIsNotBlank(String s) {
        boolean isBlank = StringUtils.isBlank(s);
        assertFalse(isBlank);
    }

    @Test
    @DisplayName("'isNotBlank' when string passed is null")
    void isNotBlankWhenStringIsNull() {
        boolean isNotBlank = StringUtils.isNotBlank(null);
        assertFalse(isNotBlank);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "     "})
    @DisplayName("'isNotBlank' when string passed is blank")
    void isNotBlankWhenStringIsBlank(String s) {
        boolean isNotBlank = StringUtils.isNotBlank(s);
        assertFalse(isNotBlank);
    }

    @ParameterizedTest
    @ValueSource(strings = {".", "Felix", "Felix Gilioli"})
    @DisplayName("'isNotBlank' when string passed is not blank")
    void isNotBlankWhenStringIsNotBlank(String s) {
        boolean isNotBlank = StringUtils.isNotBlank(s);
        assertTrue(isNotBlank);
    }
}
