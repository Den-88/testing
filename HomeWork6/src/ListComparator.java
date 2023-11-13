import java.util.List;

public class ListComparator {
    private final List<Integer> list1;
    private final List<Integer> list2;

    public ListComparator(List<Integer> list1, List<Integer> list2) {
        this.list1 = list1;
        this.list2 = list2;
    }

    public double calculateAverage(List<Integer> numList) {
        if (numList.isEmpty()) {
            return 0;
        }
        int sum = 0;
        for (int num : numList) {
            sum += num;
        }
        return (double) sum / numList.size();
    }

    public String compareLists() {
        double average1 = calculateAverage(list1);
        double average2 = calculateAverage(list2);

        if (average1 > average2) {
            return "Первый список имеет большее среднее значение";
        } else if (average1 < average2) {
            return "Второй список имеет большее среднее значение";
        } else {
            return "Средние значения равны";
        }
    }
}
