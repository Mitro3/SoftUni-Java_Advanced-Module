package vetClinic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Clinic {
    private List<Pet> data;
    private int capacity;

    public Clinic(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet) {
        if (data.size() < capacity) {
            data.add(pet);
        }
    }

    public boolean remove(String name) {
        return data.removeIf(p -> p.getName().equals(name));
    }

    public Pet getPet(String name, String owner) {
        for (Pet pet : data) {
            if (pet.getName().equals(name) && pet.getOwner().equals(owner)) {
                return pet;
            }
        }

        return null;
    }

    public Pet getOldestPet() {
        return Collections.max(data, (f, s) -> Integer.compare(f.getAge(), s.getAge()));
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder("The clinic has the following patients:");

        for (Pet pet : data) {
            sb.append(System.lineSeparator()).append(pet.getName()).append(" ").append(pet.getOwner());
        }

        return sb.toString();
    }
}
