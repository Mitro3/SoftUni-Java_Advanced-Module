package shelter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Shelter {
    private List<Animal> data;
    private int capacity;

    public Shelter(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Animal animal) {
        if (data.size() < capacity) {
            data.add(animal);
        }
    }

    public boolean remove(String name) {
        Animal animal = null;
        animal = data.stream().filter(a -> a.getName().equals(name))
                .findAny()
                .orElse(null);

        if (animal != null) {
            data.remove(animal);
            return true;
        }

        return false;
    }

    public Animal getAnimal(String name, String caretaker) {
        Animal animal = null;
        return animal = data.stream().filter(a -> a.getName().equals(name))
                .filter(a -> a.getCaretaker().equals(caretaker))
                .findAny()
                .orElse(null);
    }

    public Animal getOldestAnimal() {
        Animal animal = null;
        return animal = data.stream().max(Comparator.comparing(a -> a.getAge())).orElse(null);
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder("The shelter has the following animals:");
        for (Animal animal : data) {
            sb.append(System.lineSeparator());
            sb.append(animal.getName()).append(" ").append(animal.getCaretaker());
        }

        return sb.toString();
    }
}
