package P07_Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Company company;
    private Car car;
    private List<Pokemon> pokemonList = new ArrayList<>();
    private List<Parent> parentList = new ArrayList<>();
    private List<Child> childrenList = new ArrayList<>();

    public Person(String name, Company company) {
        this.name = name;
        this.company = company;
    }

    public Person(String name, Pokemon pokemon) {
        this.name = name;
        this.pokemonList = new ArrayList<>();
    }

    public Person(String name, Parent parent) {
        this.name = name;
        this.parentList = new ArrayList<>();
    }

    public Person(String name, Child child) {
        this.name = name;
        this.childrenList = new ArrayList<>();
    }

    public Person(String name, Car car) {
        this.name = name;
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public void setPokemonList(List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }

    public List<Parent> getParentList() {
        return parentList;
    }

    public void setParentList(List<Parent> parentList) {
        this.parentList = parentList;
    }

    public List<Child> getChildrenList() {
        return childrenList;
    }

    public void setChildrenList(List<Child> childrenList) {
        this.childrenList = childrenList;
    }

    public static class Company {
        private String companyName;
        private String department;
        private double salary;

        public Company(String name, String department, double salary) {
            this.companyName = name;
            this.department = department;
            this.salary = salary;
        }

        public String getCompanyName() {
            return companyName;
        }

        public String getDepartment() {
            return department;
        }

        public double getSalary() {
            return salary;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        public String format() {
            return String.format("%s %s %.2f", companyName, department, salary);
        }
    }

    public static class Car {
        private String model;
        private int speed;

        public Car(String model, int speed) {
            this.model = model;
            this.speed = speed;
        }

        public String getModel() {
            return model;
        }

        public int getSpeed() {
            return speed;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public void setSpeed(int speed) {
            this.speed = speed;
        }

        public String format() {
            return String.format("%s %s", model, speed);
        }
    }

    public static class Pokemon {
        private String pokemonName;
        private String pokemonType;

        public Pokemon(String pokemonName, String pokemonType) {
            this.pokemonName = pokemonName;
            this.pokemonType = pokemonType;
        }

        public String getPokemonName() {
            return pokemonName;
        }

        public String getPokemonType() {
            return pokemonType;
        }

        public void setPokemonName(String pokemonName) {
            this.pokemonName = pokemonName;
        }

        public void setPokemonType(String pokemonType) {
            this.pokemonType = pokemonType;
        }

        public String format() {
            return String.format("%s %s", pokemonName, pokemonType);
        }
    }

    public static class Parent {
        private String parentName;
        private String parentBirthday;

        public Parent(String parentName, String parentBirthday) {
            this.parentName = parentName;
            this.parentBirthday = parentBirthday;
        }

        public String getParentName() {
            return parentName;
        }

        public String getParentBirthday() {
            return parentBirthday;
        }

        public void setParentName(String parentName) {
            this.parentName = parentName;
        }

        public void setParentBirthday(String parentBirthday) {
            this.parentBirthday = parentBirthday;
        }

        public String format() {
            return String.format("%s %s", parentName, parentBirthday);
        }
    }

    public static class Child {
        private String childName;
        private String childBirthday;

        public Child(String childName, String childBirthday) {
            this.childName = childName;
            this.childBirthday = childBirthday;
        }

        public String getChildName() {
            return childName;
        }

        public void setChildName(String childName) {
            this.childName = childName;
        }

        public String getChildBirthday() {
            return childBirthday;
        }

        public void setChildBirthday(String childBirthday) {
            this.childBirthday = childBirthday;
        }

        public String format() {
            return String.format("%s %s", childName, childBirthday);
        }
    }

    public void printFormat() {
        System.out.println(name);
        System.out.println("Company:");
        if (company != null) {
            System.out.println(company.format());
        }

        System.out.println("Car:");
        if (car != null) {
            System.out.println(car.format());
        }

        System.out.println("Pokemon:");
        if (!getPokemonList().isEmpty()) {
            getPokemonList().forEach(p -> System.out.printf("%s%n", p.format()));
        }

        System.out.println("Parents:");
        if (!getParentList().isEmpty()) {
            getParentList().forEach(p -> System.out.printf("%s%n", p.format()));
        }

        System.out.println("Children:");
        if (!getChildrenList().isEmpty()) {
            getChildrenList().forEach(c -> System.out.printf("%s%n", c.format()));
        }
     }
}
