package exam_15_December_2021.aquarium;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {
    private List<Fish> fishInPool;
    private String name;
    private  int capacity;
    private int size;

    public Aquarium(String name, int capacity, int size) {
        this.fishInPool = new ArrayList<>();
        this.name = name;
        this.capacity = capacity;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public int getFishInPool() {
        return fishInPool.size();
    }

    public void add(Fish fish) {
        if (fishInPool.size() < capacity && !fishInPool.contains(fish)) {
            fishInPool.add(fish);
        }
    }

    public boolean remove(String name) {
        Fish fish = findFish(name);

        if (fish != null) {
            fishInPool.remove(fish);
            return true;
        }

        return false;
    }

    public Fish findFish(String name) {
        Fish fish = null;
        return fish = fishInPool.stream().filter(f -> f.getName().equals(name))
                .findAny()
                .orElse(null);
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append("Aquarium: ").append(name).append(" ^ Size: ").append(size);
        for (Fish fish : fishInPool) {
            sb.append(System.lineSeparator());
            sb.append(fish);
        }

        return sb.toString();
    }
}
