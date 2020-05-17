import java.util.ArrayList;

public class Factory {

    ArrayList<Car> cars;

    public Factory(){
        cars = new ArrayList<Car>();
    }

    public Factory(ArrayList<Car> c){
        cars = c;
    }

    public void addBMVV(int y, double p, double l, String i, int f, String m) {
        BMVV b = new BMVV(y, p, l, i, f, m);
        cars.add(b);
    }

    public void addAUDO(int y, double p, double l, String i, int f, String m) {
        AUDO a = new AUDO(y, p, l, i, f, m);
        cars.add(a);
    }

    public void addNISCAN(int y, double p, double l, String i, int f, String m) {
        NISCAN n = new NISCAN(y, p, l, i, f, m);
        cars.add(n);
    }

    public void addVALVA(int y, double p, double l, String i, int f, String m) {
        VALVA v = new VALVA(y, p, l, i, f, m);
        cars.add(v);
    }

    public void addTOYO(int y, double p, double l, String i, int f, String m) {
        TOYO t = new TOYO(y, p, l, i, f, m);
        cars.add(t);
    }

    public void addCITVAN(int y, double p, double l, String i, int f, String m) {
        CITVAN c = new CITVAN(y, p, l, i, f, m);
        cars.add(c);
    }

    public int howManyCars(){
        return cars.size();
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
}
