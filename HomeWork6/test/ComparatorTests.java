import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ComparatorTests {
    private ListComparator comparator;

    @Test
    public void testCalculateAverage() {
        List<Integer> list = Arrays.asList(8, 5, 2);
        comparator = new ListComparator(list, list);
        assertThat(comparator.calculateAverage(list)).isEqualTo(5.0);
    }

    @Test
    public void testCalculateEmptyList() {
        List<Integer> list = new ArrayList<>();
        comparator = new ListComparator(list, list);
        assertThat(comparator.calculateAverage(list)).isEqualTo(0);
    }

    @Test
    public void testCompareFirstListLarger() {
        List<Integer> list1 = Arrays.asList(9, 7, 3);
        List<Integer> list2 = Arrays.asList(3, 5, 1);
        comparator = new ListComparator(list1, list2);
        assertThat(comparator.compareLists()).isEqualTo("Первый список имеет большее среднее значение");
    }

    @Test
    public void testCompareSecondListLarger() {
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(4, 5, 6);
        comparator = new ListComparator(list1, list2);
        assertThat(comparator.compareLists()).isEqualTo("Второй список имеет большее среднее значение");
    }

    @Test
    public void testCompareListsEqual() {
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(4, 0, 2);
        comparator = new ListComparator(list1, list2);
        assertThat(comparator.compareLists()).isEqualTo("Средние значения равны");
    }
}
