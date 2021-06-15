package io.github.felixgilioli.felixutils.objects;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    @DisplayName("'checkArgument with message' when the object passed is null")
    void checkArgumentWithMessageWhenObjIsNull() {
        final String defaultMessage = "Default Message";
        try {
            ObjectUtils.checkArgument(null, o -> true, defaultMessage);
            fail();
        } catch (NullPointerException e) {
            assertEquals(defaultMessage, e.getMessage());
        }
    }

    @Test
    @DisplayName("'checkArgument with message' when the condition passed is null")
    void checkArgumentWithMessageWhenConditionIsNull() {
        try {
            ObjectUtils.checkArgument("Felix", null, "default");
            fail();
        } catch (NullPointerException e) {
            assertNull(e.getMessage());
        }
    }

    @Test
    @DisplayName("'checkArgument with message' when the message passed is null")
    void checkArgumentWithMessageWhenMessageIsNull() {
        try {
            ObjectUtils.checkArgument("Felix", s -> s.startsWith("F"), null);
            fail();
        } catch (NullPointerException e) {
            assertNull(e.getMessage());
        }
    }

    @Test
    @DisplayName("'checkArgument with message' when the condition passed is false")
    void checkArgumentWithMessageWhenConditionIsFalse() {
        final String defaultMessage = "name must be start with 'X'";
        try {
            ObjectUtils.checkArgument("Felix", s -> s.startsWith("X"), defaultMessage);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals(defaultMessage, e.getMessage());
        }
    }

    @Test
    @DisplayName("'checkArgument with message' when the condition passed is true")
    void checkArgumentWithMessageWhenConditionIsTrue() {
        final String defaultMessage = "name must be start with 'F'";
        final String name = ObjectUtils.checkArgument("Felix", s -> s.startsWith("F"), defaultMessage);
        assertEquals("Felix", name);
    }

}
