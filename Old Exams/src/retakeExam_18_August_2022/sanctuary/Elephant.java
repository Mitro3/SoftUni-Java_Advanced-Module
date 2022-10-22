package retakeExam_18_August_2022.sanctuary;

public class Elephant {
    private String name;
    private int age;
    private String retiredFrom;

    public Elephant(String name, int age, String retiredFrom) {
        setName(name);
        setAge(age);
        setRetiredFrom(retiredFrom);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    public String getRetiredFrom() {
        return retiredFrom;
    }

    private void setRetiredFrom(String retiredFrom) {
        this.retiredFrom = retiredFrom;
    }

    @Override
    public String toString() {
        return String.format("%s %d - %s", name, age, retiredFrom);
    }
}
