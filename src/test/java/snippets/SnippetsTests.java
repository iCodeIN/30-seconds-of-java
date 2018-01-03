package snippets;

import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SnippetsTests {

    @Test
    public void gcd_of_array_containing_1_to_5_is_1() throws Exception {
        OptionalInt gcd = Snippets.arrayGcd(new int[]{1, 2, 3, 4, 5});
        assertThat(gcd).isNotEmpty();
        assertThat(gcd).hasValue(1);
    }

    @Test
    public void gcd_of_array_containing_4_8_and_12_is_4() throws Exception {
        OptionalInt gcd = Snippets.arrayGcd(new int[]{4, 8, 12});
        assertThat(gcd).isNotEmpty();
        assertThat(gcd).hasValue(4);
    }

    @Test
    public void lcm_of_array_containing_1_to_5_is_60() throws Exception {
        OptionalInt lcm = Snippets.arrayLcm(new int[]{1, 2, 3, 4, 5});
        assertThat(lcm).isNotEmpty();
        assertThat(lcm).hasValue(60);
    }

    @Test
    public void lcm_of_array_containing_4_8_and_12_is_24() throws Exception {
        OptionalInt lcm = Snippets.arrayLcm(new int[]{4, 8, 12});
        assertThat(lcm).isNotEmpty();
        assertThat(lcm).hasValue(24);
    }

    @Test
    public void max_of_array_containing_10_1_and_5_is_10() throws Exception {
        OptionalInt max = Snippets.arrayMax(new int[]{10, 1, 5});
        assertThat(max).hasValue(10);
    }

    @Test
    public void min_of_array_containing_10_1_and_5_is_10() throws Exception {
        OptionalInt min = Snippets.arrayMin(new int[]{10, 1, 5});
        assertThat(min).hasValue(1);
    }

    @Test
    public void chunk_breaks_input_array__with_odd_length() throws Exception {
        int[][] chunks = Snippets.chunk(new int[]{1, 2, 3, 4, 5}, 2);
        assertThat(chunks)
                .containsExactly(
                        new int[]{1, 2},
                        new int[]{3, 4},
                        new int[]{5}
                );
    }

    @Test
    public void chunk_breaks_input_array__with_event_length() throws Exception {
        int[][] chunks = Snippets.chunk(new int[]{1, 2, 3, 4, 5, 6}, 2);
        assertThat(chunks)
                .containsExactly(
                        new int[]{1, 2},
                        new int[]{3, 4},
                        new int[]{5, 6}
                );
    }

    @Test
    public void countOccurrences_counts_occurrences_of_a_value() throws Exception {
        long count = Snippets.countOccurrences(new int[]{1, 1, 2, 1, 2, 3}, 1);
        assertThat(count).isEqualTo(3);
    }

    @Test
    public void deepFlatten_flatten_a_deeply_nested_array() throws Exception {
        int[] flatten = Snippets.deepFlatten(
                new Object[]{1, new Object[]{2}, new Object[]{3, 4, 5}}
        );

        assertThat(flatten).isEqualTo(new int[]{1, 2, 3, 4, 5});
    }

    @Test
    public void difference_between_array_with_1_2_3_and_array_with_1_2_4_is_3() throws Exception {
        int[] difference = Snippets.difference(new int[]{1, 2, 3}, new int[]{1, 2, 4});
        assertThat(difference).isEqualTo(new int[]{3});
    }

    @Test
    public void difference_between_array_with_1_2_3_and_array_with_1_2_3_is_empty_array() throws Exception {
        int[] difference = Snippets.difference(new int[]{1, 2, 3}, new int[]{1, 2, 3});
        assertThat(difference).isEmpty();
    }

    @Test
    public void differenceWith_return_all_squares_that_do_not_exist_in_second() throws Exception {
        int[] difference = Snippets.differenceWith(
                new int[]{1, 4, 9, 16, 25},
                new int[]{1, 2, 3, 6, 7},
                (o1, o2) -> o1 - (o2 * o2)
        );

        assertThat(difference).isEqualTo(new int[]{16, 25});
    }

    @Test
    public void differenceWith_returns_empty_array_when_two_arrays_are_equal_as_per_comparison_operation() throws Exception {
        int[] difference = Snippets.differenceWith(
                new int[]{1, 2, 3},
                new int[]{1, 2, 3},
                (o1, o2) -> o1 - o2
        );

        assertThat(difference).isEmpty();
    }

    @Test
    public void differenceWith_returns_first_array_when_elements_in_second_array_are_not_comparable_as_per_comparison_operation() throws Exception {
        int[] difference = Snippets.differenceWith(
                new int[]{1, 2, 3},
                new int[]{10, 11, 12},
                (o1, o2) -> o1 - o2
        );

        assertThat(difference).isEqualTo(new int[]{1, 2, 3});
    }

    @Test
    public void distinct_remove_all_duplicate_values_from_an_array() throws Exception {
        int[] distinct = Snippets.distinctValuesOfArray(new int[]{1, 2, 2, 3, 4, 4, 5});
        assertThat(distinct).isEqualTo(new int[]{1, 2, 3, 4, 5});
    }

    @Test
    public void drop_elements_less_than_3() throws Exception {
        int[] elements = Snippets.dropElements(new int[]{1, 2, 3, 4}, i -> i >= 3);
        assertThat(elements).isEqualTo(new int[]{3, 4});
    }

    @Test
    public void drop_elements_returns_empty_array_when_no_element_match_the_condition() throws Exception {
        int[] elements = Snippets.dropElements(new int[]{1, 2, 3, 4}, i -> i < 1);
        assertThat(elements).isEmpty();
    }

    @Test
    public void drop_elements__return_all_elements_when_all_elements_match_the_condition() throws Exception {
        int[] elements = Snippets.dropElements(new int[]{1, 2, 3, 4}, i -> i <= 4);
        assertThat(elements).isEqualTo(new int[]{1, 2, 3, 4});
    }

    @Test
    public void dropRight_remove_n_elements_from_right() throws Exception {
        int[] elements = Snippets.dropRight(new int[]{1, 2, 3}, 1);
        assertThat(elements).isEqualTo(new int[]{1, 2});

        elements = Snippets.dropRight(new int[]{1, 2, 3}, 2);
        assertThat(elements).isEqualTo(new int[]{1});

        elements = Snippets.dropRight(new int[]{1, 2, 3}, 3);
        assertThat(elements).isEmpty();

        elements = Snippets.dropRight(new int[]{1, 2, 3}, 42);
        assertThat(elements).isEmpty();
    }

    @Test
    public void everyNth_return_every_2nd_element() throws Exception {
        int[] elements = Snippets.everyNth(new int[]{1, 2, 3, 4, 5, 6}, 2);
        assertThat(elements).isEqualTo(new int[]{2, 4, 6});
    }

    @Test
    public void filterNonUnique_return_unique_elements() throws Exception {
        int[] elements = Snippets.filterNonUnique(new int[]{1, 2, 2, 3, 4, 4, 5});
        assertThat(elements).isEqualTo(new int[]{1, 3, 5});
    }

    @Test
    public void filterNonUnique_return_same_array_when_all_unique() throws Exception {
        int[] elements = Snippets.filterNonUnique(new int[]{1, 2, 3, 4, 5});
        assertThat(elements).isEqualTo(new int[]{1, 2, 3, 4, 5});
    }

    @Test
    public void filterNonUnique_return_empty_array_when_all_duplicated() throws Exception {
        int[] elements = Snippets.filterNonUnique(new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 5});
        assertThat(elements).isEmpty();
    }

    @Test
    public void flatten_flat_one_level_array() throws Exception {
        int[] flatten = Snippets.flatten(new Object[]{1, new int[]{2}, 3, 4});
        assertThat(flatten).isEqualTo(new int[]{1, 2, 3, 4});
    }

    @Test
    public void flattenDepth_flatten_to_specified_depth() throws Exception {
        Object[] input = {
                1,
                new Object[]{2},
                new Object[]{
                        new Object[]{
                                new Object[]{
                                        3
                                },
                                4
                        }, 5
                }
        };

        Object[] flatten = Snippets.flattenDepth(input, 2);
        assertThat(flatten).isEqualTo(new Object[]{1, 2, new Object[]{3}, 4, 5});
    }

    @Test
    public void group_elements_by_length() throws Exception {
        Map<Integer, List<String>> groups = Snippets.groupBy(new String[]{"one", "two", "three"}, String::length);
        assertThat(groups)
                .containsExactly(
                        new SimpleEntry<>(3, Arrays.asList("one", "two")),
                        new SimpleEntry<>(5, Collections.singletonList("three"))
                );
    }

    @Test
    public void initial_return_array_except_last_element() throws Exception {
        Integer[] initial = Snippets.initial(new Integer[]{1, 2, 3});
        assertThat(initial).isEqualTo(new Integer[]{1, 2});
    }

    @Test
    public void initializeArrayWithRange_from_1_to_5() throws Exception {
        int[] numbers = Snippets.initializeArrayWithRange(5, 1);
        assertThat(numbers).isEqualTo(new int[]{1, 2, 3, 4, 5});
    }

    @Test
    public void initializeArrayWithValues() throws Exception {
        int[] elements = Snippets.initializeArrayWithValues(5, 2);
        assertThat(elements).isEqualTo(new int[]{2, 2, 2, 2, 2});
    }

    @Test
    public void intersection_between_two_arrays() throws Exception {
        int[] elements = Snippets.intersection(new int[]{1, 2, 3}, new int[]{4, 3, 2});
        assertThat(elements).isEqualTo(new int[]{2, 3});
    }

    @Test
    public void isSorted_return_1_when_array_sorted_is_ascending_order() throws Exception {
        int sorted = Snippets.isSorted(new Integer[]{0, 1, 2, 3});
        assertThat(sorted).isEqualTo(1);

        sorted = Snippets.isSorted(new Integer[]{0, 1, 2, 2});
        assertThat(sorted).isEqualTo(1);
    }

    @Test
    public void isSorted_return_minus_1_when_array_sorted_in_descending_order() throws Exception {
        int sorted = Snippets.isSorted(new Integer[]{3, 2, 1, 0});
        assertThat(sorted).isEqualTo(-1);

        sorted = Snippets.isSorted(new Integer[]{3, 3, 2, 1, 0});
        assertThat(sorted).isEqualTo(-1);
    }

    @Test
    public void isSorted_returns_0_when_array_is_not_sorted() throws Exception {
        int sorted = Snippets.isSorted(new Integer[]{3, 4, 1, 0});
        assertThat(sorted).isEqualTo(0);
    }
}
