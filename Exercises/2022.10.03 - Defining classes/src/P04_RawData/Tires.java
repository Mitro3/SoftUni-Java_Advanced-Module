package P04_RawData;

import java.util.LinkedHashMap;
import java.util.Map;

public class Tires {
    private Map<Double, Integer> tiresData;

    public Tires(Map<Double, Integer> tiresData) {
        this.tiresData = tiresData;
    }

    public Map<Double, Integer> getTiresData() {
        return tiresData;
    }

    public void setTiresData(Map<Double, Integer> tiresData) {
        this.tiresData = tiresData;
    }
}
