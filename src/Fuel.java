import java.util.Arrays;
import java.util.Objects;

public class Fuel {

    public String[] fuels = {"Petrol", "Diesel"};
    public String fuel;

    public Fuel(int i) {
        if (i >= 0 && i < fuels.length) {
            fuel = fuels[i];
        } else {
            fuel = "Fuel Unkown";
        }
    }

    public Fuel (String s){
        fuel = "Fuel Unknown";
        for(int i = 0; i < fuels.length; i++) {
            if (s.toLowerCase().replace("\\s+", "").equals(fuels[i].toLowerCase().replace("\\s+", ""))) {
                fuel = fuels[i];
            }
        }
    }

    public String[] getFuels(){
        return fuels;
    }

    public void addFuel(String s){
        String[] a = new String[fuels.length+1];
        for (int i = 0; i < fuels.length; i++){
            a[i] = fuels[i];
        }
        a[fuels.length+1] = s;
        this.fuels = a;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuels(String[] f) {
        this.fuels = f;
    }

    public void setFuel(String f) {
        this.fuel = f;
    }

    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        Fuel f = (Fuel) o;
        return Arrays.equals(fuels, f.getFuels()) && fuel.equals(f.getFuel());
    }
}
