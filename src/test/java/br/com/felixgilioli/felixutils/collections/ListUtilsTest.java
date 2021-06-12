package br.com.felixgilioli.felixutils.collections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("ListUtils")
class ListUtilsTest {

    @Test
    @DisplayName("'filter' when the list passed is null")
    void filterWhenListIsNull() {
        assertThrows(NullPointerException.class, () -> ListUtils.filter(null, o -> true));
    }

    @Test
    @DisplayName("'filter' when the condition passed is null")
    void filterWhenConditionIsNull() {
        assertThrows(NullPointerException.class, () -> ListUtils.filter(singletonList("Felix"), null));
    }

    @Test
    @DisplayName("'filter' when the list passed is empty")
    void filterWhenListIsEmpty() {
        assertTrue(ListUtils.filter(emptyList(), o -> true).isEmpty());
    }

    @Test
    @DisplayName("'filter' odd numbers")
    void filterOddNumbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        numbers = ListUtils.filter(numbers, n -> n % 2 == 0);

        assertEquals(Arrays.asList(2, 4, 6, 8, 10), numbers);
    }

    @Test
    @DisplayName("'filter' names that start with 'F'")
    void filterNamesThatStartWithF() {
        List<String> names = Arrays.asList("Felix", "Daiane", "Fernando", "Adriana", "Ricardo");
        names = ListUtils.filter(names, name -> name.startsWith("F"));

        assertEquals(Arrays.asList("Felix", "Fernando"), names);
    }

    @Test
    @DisplayName("'filter' when no conditions are true")
    void filterWhenNoConditionsAreTrue() {
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        numbers = ListUtils.filter(numbers, n -> false);

        assertTrue(numbers.isEmpty());
    }

    @Test
    @DisplayName("'filter' when all conditions are true")
    void filterWhenAllConditionsAreTrue() {
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        numbers = ListUtils.filter(numbers, n -> true);

        assertEquals(Arrays.asList(1, 2, 3), numbers);
    }
}
