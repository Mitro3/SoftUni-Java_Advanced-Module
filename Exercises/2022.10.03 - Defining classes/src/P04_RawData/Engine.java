package P04_RawData;

public class Engine {
    int engineSpeed;
    int enginePower;

    public Engine(int engineSpeed, int enginePower) {
        this.engineSpeed = engineSpeed;
        this.enginePower = enginePower;
    }

    public int getEngineSpeed() {
        return this.engineSpeed;
    }

    public int getEnginePower() {
        return this.enginePower;
    }

    public void setEngineSpeed(int engineSpeed) {
        this.engineSpeed = engineSpeed;
    }

    public void setEnginePower(int enginePower) {
        this.enginePower = enginePower;
    }
}
