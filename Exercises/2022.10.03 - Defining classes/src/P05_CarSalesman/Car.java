package P05_CarSalesman;

public class Car {
    private String model;
    private Engine engine;
    private int weight;
    private String color;

    public Car(String model, Engine engine, int weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public Car(String model, Engine engine, int weight) {
        this(model, engine, weight, "n/a");
    }

    public Car(String model, Engine engine, String color) {
        this(model, engine, -1, color);
    }

    public Car(String model, Engine engine) {
        this(model, engine, -1, "n/a");
    }

    @Override
    public String toString() {
        String engineDisplacement = String.valueOf(this.engine.getDisplacement());
        if (engine.getDisplacement() == -1) {
            engineDisplacement = "n/a";
        }

        String weight = String.valueOf(this.weight);
        if (this.weight == -1) {
            weight = "n/a";
        }
            return String.format("%s:%n", model)
                    + String.format("%s:%n", engine.getModel())
                    + String.format(("Power: %d%n"), engine.getPower())
                    + String.format("Displacement: %s%n", engineDisplacement)
                    + String.format("Efficiency: %s%n", engine.getEfficiency())
                    + String.format("Weight: %s%n", weight)
                    + String.format("Color: %s", color);

    }
}
