package exam_23_October_2021.hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Person> roster;
    private String name;
    private int capacity;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void add(Person person) {
        if (roster.size() < capacity) {
            roster.add(person);
        }
    }

    public boolean remove(String name) {
        Person person = null;
        person = roster.stream().filter(p -> p.getName().equals(name))
                .findAny()
                .orElse(null);

        if (person != null) {
            roster.remove(person);
            return true;
        }

        return false;
    }

    public Person getPerson(String name, String hometown) {
        Person person = null;
        person = roster.stream()
                .filter(p -> p.getName().equals(name))
                .filter(p -> p.getHometown().equals(hometown))
                .findAny()
                .orElse(null);

        return person;
    }

    public int getCount() {
        return roster.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("The people in the exam_23_October_2021.hotel ").append(name).append(" are:");
        for (Person person : roster) {
            sb.append(System.lineSeparator());
            sb.append(person);
        }

        return sb.toString();
    }
}
