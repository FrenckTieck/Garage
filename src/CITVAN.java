import java.util.Calendar;

public class CITVAN extends Car {

    String image;

    public CITVAN(int id, int y, double p, double l, String m, Fuel f, String i) {
        super(id, 0000, p, l, i, f);
        int now = Calendar.getInstance().get(Calendar.YEAR);
        if(y >= 1931 && y <= now){
            this.setYear(y);
        }
        image = i;
        this.setModel("CITVAN" + m);
    }

    public CITVAN(int id, int y, double p, double l, String m, String f, String i) {
        super(id, 0000, p, l, i, f);
        int now = Calendar.getInstance().get(Calendar.YEAR);
        if(y >= 1931 && y <= now){
            this.setYear(y);
        }
        image = i;
        this.setModel("CITVAN" + m);
    }

    public CITVAN(int id, int y, double p, double l, String m, int f, String i) {
        super(id, 0000, p, l, i, f);
        int now = Calendar.getInstance().get(Calendar.YEAR);
        if(y >= 1931 && y <= now){
            this.setYear(y);
        }
        image = i;
        this.setModel("CITVAN" + m);
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
        CITVAN c = (CITVAN) o;
        Car c1 = this;
        Car c2 = c;
        return c1.equals(c2) && model.equals(c.getModel());
    }
}
