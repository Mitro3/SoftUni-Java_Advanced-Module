package P04_RawData;

public class Cargo {
    int cargoWeight;
    String cargoType;

    public Cargo(int cargoWeigth, String cargoType) {
        this.cargoWeight = cargoWeigth;
        this.cargoType = cargoType;
    }

    public int getCargoWeight() {
        return this.cargoWeight;
    }

    public String getCargoType() {
        return this.cargoType;
    }

    public void setCargoWeight(int cargoWeight) {
        this.cargoWeight = cargoWeight;
    }

    public void setCargoType(String cargoType) {
        this.cargoType = cargoType;
    }
}
