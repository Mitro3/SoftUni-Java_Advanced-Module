package P04_RawData;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Map<Double, Integer> Tires;

    public Car(String model, Engine engine, Cargo cargo, Tires tires) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.Tires = new LinkedHashMap<>(tires.getTiresData());
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public Map<Double, Integer> getTires() {
        return Tires;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public void setTires(Map<Double, Integer> tires) {
        Tires = tires;
    }
}
