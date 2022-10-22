package retakeExam_18_August_2022.sanctuary;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Habitat {
    private int capacity;
    private List<Elephant> data;

    public Habitat(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add (Elephant elephant) {
        if (data.size() < capacity) {
            data.add(elephant);
        }
    }

    public boolean remove (String name) {
        Elephant elephant = null;
        elephant = data.stream().filter(e -> e.getName().equals(name))
                .findAny()
                .orElse(null);

        if (elephant != null) {
            data.remove(elephant);
            return true;
        }

        return false;
    }

    public Elephant getElephant (String retiredFrom) {
       return data.stream()
                .filter(e -> e.getRetiredFrom().equals(retiredFrom))
               .findFirst()
               .orElse(null);
    }

    public Elephant getOldestElephant() {
        return data.stream()
                .max(Comparator.comparing(elephant -> elephant.getAge()))
                .orElse(null);
    }

    public int getAllElephants() {
        return data.size();
    }

    public String getReport() {
        StringBuilder sb = new StringBuilder("Saved elephants in the park:");
        for (Elephant elephant : data) {
            sb.append(System.lineSeparator());
            sb.append(elephant.getName()).append(" came from: ").append(elephant.getRetiredFrom());
        }


        return sb.toString();
    }

}
