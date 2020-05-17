import java.util.ArrayList;

public class Factory {

    ArrayList<Car> cars;
    int id;

    public Factory(){
        cars = new ArrayList<Car>();
        id = 0;
    }

    public Factory(ArrayList<Car> c){
        cars = c;
        id = c.size();
    }

    public void addBMVV(int y, double p, double l, String i, int f, String m) {
        id++;
        BMVV b = new BMVV(id, y, p, l, i, f, m);
        cars.add(b);
    }

    public void addAUDO(int y, double p, double l, String i, int f, String m) {
        id++;
        AUDO a = new AUDO(id, y, p, l, i, f, m);
        cars.add(a);
    }

    public void addNISCAN(int y, double p, double l, String i, int f, String m) {
        id++;
        NISCAN n = new NISCAN(id, y, p, l, i, f, m);
        cars.add(n);
    }

    public void addVALVA(int y, double p, double l, String i, int f, String m) {
        id++;
        VALVA v = new VALVA(id, y, p, l, i, f, m);
        cars.add(v);
    }

    public void addTOYO(int y, double p, double l, String i, int f, String m) {
        id++;
        TOYO t = new TOYO(id, y, p, l, i, f, m);
        cars.add(t);
    }

    public void addCITVAN(int y, double p, double l, String i, int f, String m) {
        id++;
        CITVAN c = new CITVAN(id, y, p, l, i, f, m);
        cars.add(c);
    }

    public int howManyCars(){
        return cars.size();
    }

    public ArrayList<Car> getCars(){
        return cars;
    }

    public int howManyBMVV(){
        int i = 0;
        for(int a = 0; a < cars.size(); a++){
            if(cars.get(a) instanceof BMVV){
                i++;
            }
        }
        return i;
    }

    public ArrayList<BMVV> getBMVV(){
        ArrayList<BMVV> b = new ArrayList<BMVV>();
        for(int i = 0; i < cars.size(); i++){
            Car c = cars.get(i);
            if(c instanceof BMVV){
                b.add((BMVV) c);
            }
        }
        return b;
    }

    public int howManyAUDO(){
        int i = 0;
        for(int a = 0; a < cars.size(); a++){
            if(cars.get(a) instanceof AUDO){
                i++;
            }
        }
        return i;
    }

    public ArrayList<AUDO> getAUDO(){
        ArrayList<AUDO> b = new ArrayList<AUDO>();
        for(int i = 0; i < cars.size(); i++){
            Car c = cars.get(i);
            if(c instanceof AUDO){
                b.add((AUDO) c);
            }
        }
        return b;
    }

    public int howManyNISCAN(){
        int i = 0;
        for(int a = 0; a < cars.size(); a++){
            if(cars.get(a) instanceof NISCAN){
                i++;
            }
        }
        return i;
    }

    public ArrayList<NISCAN> getNISCAN(){
        ArrayList<NISCAN> b = new ArrayList<NISCAN>();
        for(int i = 0; i < cars.size(); i++){
            Car c = cars.get(i);
            if(c instanceof NISCAN){
                b.add((NISCAN) c);
            }
        }
        return b;
    }

    public int howManyVALVA(){
        int i = 0;
        for(int a = 0; a < cars.size(); a++){
            if(cars.get(a) instanceof VALVA){
                i++;
            }
        }
        return i;
    }

    public ArrayList<VALVA> getVALVA(){
        ArrayList<VALVA> b = new ArrayList<VALVA>();
        for(int i = 0; i < cars.size(); i++){
            Car c = cars.get(i);
            if(c instanceof VALVA){
                b.add((VALVA) c);
            }
        }
        return b;
    }

    public int howManyTOYO(){
        int i = 0;
        for(int a = 0; a < cars.size(); a++){
            if(cars.get(a) instanceof TOYO){
                i++;
            }
        }
        return i;
    }

    public ArrayList<TOYO> getTOYO(){
        ArrayList<TOYO> b = new ArrayList<TOYO>();
        for(int i = 0; i < cars.size(); i++){
            Car c = cars.get(i);
            if(c instanceof TOYO){
                b.add((TOYO) c);
            }
        }
        return b;
    }

    public int howManyCIVAN(){
        int i = 0;
        for(int a = 0; a < cars.size(); a++){
            if(cars.get(a) instanceof CITVAN){
                i++;
            }
        }
        return i;
    }

    public ArrayList<CITVAN> getCITVAN(){
        ArrayList<CITVAN> b = new ArrayList<CITVAN>();
        for(int i = 0; i < cars.size(); i++){
            Car c = cars.get(i);
            if(c instanceof CITVAN){
                b.add((CITVAN) c);
            }
        }
        return b;
    }

    public boolean removeCar(int i){
        if(i>= 0 && i < cars.size()){
            cars.remove(i);
            id--;
            return true;
        } else {
            return false;
        }
    }

    public boolean removeCar(Car c) {
        return cars.remove(c);
    }

    public Car find(String m) {
        for(int i = 0; i < cars.size(); i++){
            Car temp = cars.get(i);
            if(temp.getModel().equals(m)){
                return temp;
            }
        }
        return null;
    }

    public String printCar(int i){
        if(i >= 0 && i < cars.size()){
            return cars.get(i).toString();
        } else {
            return "";
        }
    }

    public double totalValue(){
        double value = 0;
        for(int i = 0; i < cars.size(); i++){
            value += cars.get(i).getPrice();
        }
        return value;
    }

    public String printStockLevel(){
        return "Total Cars: " + this.howManyCars() +
                ", BMVV: " + this.howManyBMVV() +
                ", AUDO: " + this.howManyAUDO() +
                ", NISCAN: " + this.howManyNISCAN() +
                ", VALVA: " + this.howManyVALVA() +
                ", TOYO: " + this.howManyTOYO() +
                ", CITVAN: " + this.howManyCIVAN() +
                ", Total Value: " + this.totalValue();
    }

    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o== null || getClass() != o.getClass()){
            return false;
        }
        Factory f = (Factory) o;
        return id == f.howManyCars() && cars.equals(f.getCars());
    }
}
