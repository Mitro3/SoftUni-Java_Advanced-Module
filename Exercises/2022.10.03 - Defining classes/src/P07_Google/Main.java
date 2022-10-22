package P07_Google;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Person> personSet = new HashSet<>();

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] personData = input.split("\\s+");
            String name = personData[0];
            String switcher = personData[1];

            Person person = null;

            switch (switcher) {
                case "company":
                    String companyName = personData[2];
                    String department = personData[3];
                    double salary = Double.parseDouble(personData[4]);

                    Person.Company company = new Person.Company(companyName, department, salary);

                    if (personSet.isEmpty()) {
                        person = new Person(name, company);
                    } else {
                        if (personSet.stream().anyMatch(p -> p.getName().equals(name))) {
                            person = getPerson(personSet, name);
                        } else {
                            person = new Person(name, company);

                        }
                    }
                    person.setCompany(company);
                    break;

                case "pokemon":
                    String pokemonName = personData[2];
                    String pokemonType = personData[3];

                    Person.Pokemon pokemon = new Person.Pokemon(pokemonName, pokemonType);

                    if (personSet.isEmpty()) {
                        List<Person.Pokemon> pokemonList = new ArrayList<>();
                        pokemonList.add(pokemon);
                        person = new Person(name, pokemon);
                        person.setPokemonList(pokemonList);

                    } else {
                        List<Person.Pokemon> currPokemonList = new ArrayList<>();

                        if (personSet.stream().anyMatch(p -> p.getName().equals(name))) {
                            person = getPerson(personSet, name);
                            if (person.getPokemonList() != null) {
                                currPokemonList = person.getPokemonList();
                            }
                            currPokemonList.add(pokemon);
                            person.setPokemonList(currPokemonList);

                        } else {
                            List<Person.Pokemon> pokemonList = new ArrayList<>();
                            pokemonList.add(pokemon);
                            person = new Person(name, pokemon);
                            person.setPokemonList(pokemonList);
                        }
                    }
                    break;

                case "parents":
                    String parentName = personData[2];
                    String parentBirthday = personData[3];

                    Person.Parent parent = new Person.Parent(parentName, parentBirthday);

                    if (personSet.isEmpty()) {
                        List<Person.Parent> parentList = new ArrayList<>();
                        parentList.add(parent);
                        person = new Person(name, parent);
                        person.setParentList(parentList);

                    } else {
                        List<Person.Parent> currParentsList = new ArrayList<>();

                        if(personSet.stream().anyMatch(p -> p.getName().equals(name))) {
                            person = getPerson(personSet, name);
                            if (person.getParentList() != null) {
                                currParentsList = person.getParentList();
                            }
                            currParentsList.add(parent);
                            person.setParentList(currParentsList);

                        } else {
                            List<Person.Parent> parentList = new ArrayList<>();
                            parentList.add(parent);
                            person = new Person(name, parent);
                            person.setParentList(parentList);
                        }
                    }
                    break;

                case "children":
                    String childName = personData[2];
                    String childBirthday = personData[3];

                    Person.Child child = new Person.Child(childName, childBirthday);

                    if (personSet.isEmpty()) {
                        List<Person.Child> childrenList = new ArrayList<>();
                        childrenList.add(child);
                        person = new Person(name, child);
                        person.setChildrenList(childrenList);

                    } else {
                        List<Person.Child> currChildrenList = new ArrayList<>();

                        if (personSet.stream().anyMatch(p -> p.getName().equals(name))) {
                            person = getPerson(personSet, name);
                            if (person.getChildrenList() != null) {
                                currChildrenList = person.getChildrenList();
                            }
                            currChildrenList.add(child);
                            person.setChildrenList(currChildrenList);

                        } else {
                            List<Person.Child> childrenList = new ArrayList<>();
                            childrenList.add(child);
                            person = new Person(name, child);
                            person.setChildrenList(childrenList);
                        }
                    }
                    break;

                case "car":
                    String carModel = personData[2];
                    int carSpeed = Integer.parseInt(personData[3]);

                    Person.Car car = new Person.Car(carModel, carSpeed);

                    if (personSet.isEmpty()) {
                        person = new Person(name, car);
                    } else {
                        if (personSet.stream().anyMatch(p -> p.getName().equals(name))) {
                            person = getPerson(personSet, name);
                        } else {
                            person = new Person(name, car);
                        }
                    }
                    person.setCar(car);

                    break;
            }

            personSet.add(person);
            input = scanner.nextLine();

        }

        String personToPrint = scanner.nextLine();

        personSet.stream().filter(p -> p.getName().equals(personToPrint)).forEach(Person::printFormat);
    }


    private static Person getPerson(Set<Person> personSet, String name) {
        Person person;
        person = personSet.stream().filter(p -> p.getName().equals(name))
                .findAny()
                .orElse(null);
        return person;
    }
}
