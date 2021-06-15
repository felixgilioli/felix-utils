package io.github.felixgilioli.felixutils.objects;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("ObjectUtils")
class ObjectUtilsTest {

    @Test
    @DisplayName("'checkArgument' when the object passed is null")
    void checkArgumentWhenObjIsNull() {
        assertThrows(NullPointerException.class, () -> ObjectUtils.checkArgument(null, o -> true));
    }

    @Test
    @DisplayName("'checkArgument' when the condition passed is null")
    void checkArgumentWhenConditionIsNull() {
        assertThrows(NullPointerException.class, () -> ObjectUtils.checkArgument("Felix", null));
    }

    @Test
    @DisplayName("'checkArgument' when the condition passed is false")
    void checkArgumentWhenConditionIsFalse() {
        assertThrows(IllegalArgumentException.class, () -> ObjectUtils.checkArgument("Felix", n -> n.startsWith("X")));
    }

    @Test
    @DisplayName("'checkArgument' when the condition passed is true")
    void checkArgumentWhenConditionIsTrue() {
        final String name = ObjectUtils.checkArgument("Felix", n -> n.startsWith("F"));
        assertEquals("Felix", name);
    }

}
