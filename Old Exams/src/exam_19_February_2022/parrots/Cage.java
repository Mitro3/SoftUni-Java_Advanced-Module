package exam_19_February_2022.parrots;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cage {
    private String name;
    private int capacity;
    private List<Parrot> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void add(Parrot parrot) {
        if (data.size() < capacity) {
            data.add(parrot);
        }
    }

    public boolean remove(String name) {
        Parrot parrot = getParrot(name);

        if (parrot != null) {
            data.remove(parrot);
            return true;
        }

        return false;
    }

    private Parrot getParrot(String name) {
        Parrot parrot = null;
        parrot = data.stream().filter(p -> p.getName().equals(name))
                .findFirst()
                .orElse(null);
        return parrot;
    }

    public Parrot sellParrot(String name) {
        Parrot parrot = getParrot(name);
        parrot.setAvailable(false);

        return parrot;
    }

    public List<Parrot> sellParrotBySpecies(String species) {
        List<Parrot> parrotsToSell = data.stream().filter(p -> p.getSpecies().equals(species))
                .collect(Collectors.toList());

        for (Parrot parrot : parrotsToSell) {
            parrot.setAvailable(false);
        }

        return parrotsToSell;
    }

    public int count() {
        return data.size();
    }

    public String report() {
        List<Parrot> parrotsNotSold = data.stream()
                .filter(p -> p.isAvailable() == true)
                .collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Parrots available at %s:", name));
        for (Parrot parrot : parrotsNotSold) {
            sb.append(System.lineSeparator());
            sb.append(parrot);
        }

        return sb.toString();
    }


}
