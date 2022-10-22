package P06_GC_MethodString;
import java.util.ArrayList;
import java.util.List;

public class Box<T extends Comparable> {
    private List<T> values;

    public Box() {
        this.values = new ArrayList<>();
    }

    public void add(T element) {
        values.add(element);
    }

    public void swapIndices(int firstIndex, int secondIndex) {
        T temp = values.get(firstIndex);
        values.set(firstIndex, values.get(secondIndex));
        values.set(secondIndex, temp);
    }

    public int countOfGreaterItems(T element) {
        return (int) values.stream()
                .filter(e -> e.compareTo(element) > 0)
                .count();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T value : values) {
            sb.append(String.format("%s: %s%n", value.getClass().getName(), value));
        }
        return sb.toString();
    }
}
