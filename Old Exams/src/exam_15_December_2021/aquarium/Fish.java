package exam_15_December_2021.aquarium;

public class Fish {
    private String name;
    private String color;
    private int fins;

    public Fish(String name, String color, int fins) {
        this.name = name;
        this.color = color;
        this.fins = fins;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getFins() {
        return fins;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Fish: ").append(name);
        sb.append(System.lineSeparator());
        sb.append("Color: ").append(color);
        sb.append(System.lineSeparator());
        sb.append("Number of fins: ").append(fins);
        return sb.toString();
    }
}
