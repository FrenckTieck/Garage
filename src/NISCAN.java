import java.util.Calendar;

public class NISCAN extends Car {

    String image;

    public NISCAN(int id, int y, double p, double l, String m, Fuel f, String i) {
        super(id, 0000, p, l, i, f);
        int now = Calendar.getInstance().get(Calendar.YEAR);
        if(y >= 1958 && y <= now){
            this.setYear(y);
        }
        image = i;
        this.setModel("NISCAN " + m);
    }

    public NISCAN(int id, int y, double p, double l, String m, String f, String i) {
        super(id, 0000, p, l, i, f);
        int now = Calendar.getInstance().get(Calendar.YEAR);
        if(y >= 1931 && y <= now){
            this.setYear(y);
        }
        image = i;
        this.setModel("NISCAN " + m);
    }

    public NISCAN(int id, int y, double p, double l, String m, int f, String i) {
        super(id, 0000, p, l, i, f);
        int now = Calendar.getInstance().get(Calendar.YEAR);
        if(y >= 1931 && y <= now){
            this.setYear(y);
        }
        image = i;
        this.setModel("NISCAN " + m);
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
