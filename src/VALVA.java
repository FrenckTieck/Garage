import java.util.Calendar;

public class VALVA extends Car {

    String model;

    public VALVA(int y, double p, double l, Fuel f, String m) {
        super(0000, p, l, f);
        int now = Calendar.getInstance().get(Calendar.YEAR);
        if(y >= 1927 && y <= now){
            this.setYear(y);
        }
        model = m;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o== null || getClass() != o.getClass()){
            return false;
        }
        VALVA v = (VALVA) o;
        Car c1 = this;
        Car c2 = v;
        return c1.equals(c2) && model.equals(v.getModel());
    }
}
