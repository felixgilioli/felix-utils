package io.github.felixgilioli.felixutils.collections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("ListUtils")
class ListUtilsTest {

    @Test
    @DisplayName("'filter' when the collection passed is null")
    void filterWhenCollectionIsNull() {
        assertThrows(NullPointerException.class, () -> ListUtils.filter(null, o -> true));
    }

    @Test
    @DisplayName("'filter' when the condition passed is null")
    void filterWhenConditionIsNull() {
        List<String> nameList = singletonList("Felix");
        assertThrows(NullPointerException.class, () -> ListUtils.filter(nameList, null));
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
        numbers = ListUtils.filter(numbers, n -> n % 2 == 1);

        assertEquals(Arrays.asList(1, 3, 5, 7, 9), numbers);
    }

    @Test
    @DisplayName("'filter' with Set of numbers")
    void filterWithSetOfNumbers() {
        Set<Integer> numbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        List<Integer> evenNumbers = ListUtils.filter(numbers, n -> n % 2 == 0);

        assertEquals(Arrays.asList(2, 4, 6, 8, 10), evenNumbers);
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

    @Test
    @DisplayName("'map' when the collection passed is null")
    void mapWhenCollectionIsNull() {
        assertThrows(NullPointerException.class, () -> ListUtils.map(null, o -> o));
    }

    @Test
    @DisplayName("'map' when the mapper passed is null")
    void mapWhenMapperIsNull() {
        List<String> nameList = singletonList("Felix");
        assertThrows(NullPointerException.class, () -> ListUtils.map(nameList, null));
    }

    @Test
    @DisplayName("'map' when the collection passed is empty")
    void mapWhenCollectionIsEmpty() {
        assertTrue(ListUtils.map(emptyList(), o -> o).isEmpty());
    }

    @Test
    @DisplayName("'map' with list of numbers in a string")
    void mapWithListOfNumbersInAString() {
        List<String> numbersInStringList = Arrays.asList("1", "2", "3");
        List<Integer> numbers = ListUtils.map(numbersInStringList, Integer::valueOf);
        assertEquals(Arrays.asList(1, 2, 3), numbers);
    }

    @Test
    @DisplayName("'map' with set of numbers in a string")
    void mapWithSetOfNumbersInAString() {
        Set<String> numbersInStringList = new HashSet<>(Arrays.asList("1", "2", "3"));
        List<Integer> numbers = ListUtils.map(numbersInStringList, Integer::valueOf);
        assertEquals(Arrays.asList(1, 2, 3), numbers);
    }

    @Test
    @DisplayName("'findFirst' when the collection passed is null")
    void findFirstWhenCollectionIsNull() {
        assertThrows(NullPointerException.class, () -> ListUtils.findFirst(null, o -> true));
    }

    @Test
    @DisplayName("'findFirst' when the condition passed is null")
    void findFirstWhenConditionIsNull() {
        assertThrows(NullPointerException.class, () -> ListUtils.findFirst(emptyList(), null));
    }

    @Test
    @DisplayName("'findFirst' when the collection passed is empty")
    void findFirstWhenCollectionIsEmpty() {
        final Optional<Object> firstObject = ListUtils.findFirst(emptyList(), o -> true);
        assertFalse(firstObject.isPresent());
    }
}
