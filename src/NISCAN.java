import java.util.Calendar;

public class NISCAN extends Car {

    String model;

    public NISCAN(int id, int y, double p, double l, String i, Fuel f, String m) {
        super(id, 0000, p, l, i, f);
        int now = Calendar.getInstance().get(Calendar.YEAR);
        if(y >= 1958 && y <= now){
            this.setYear(y);
        }
        model = m;
    }

    public NISCAN(int id, int y, double p, double l, String i, String f, String m) {
        super(id, 0000, p, l, i, f);
        int now = Calendar.getInstance().get(Calendar.YEAR);
        if(y >= 1931 && y <= now){
            this.setYear(y);
        }
        model = m;
    }

    public NISCAN(int id, int y, double p, double l, String i, int f, String m) {
        super(id, 0000, p, l, i, f);
        int now = Calendar.getInstance().get(Calendar.YEAR);
        if(y >= 1931 && y <= now){
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
        NISCAN n = (NISCAN) o;
        Car c1 = this;
        Car c2 = n;
        return c1.equals(c2) && model.equals(n.getModel());
    }
}
