import java.util.Arrays;

public class Car {

    public int year;
    public double price;
    public double litres;
    public Fuel fuel;

    public Car(int y, double p, double l, Fuel f){
        year = y;
        price = p;
        litres = l;
        fuel = f;
    }

    public Car(int y, double p, double l, String f){
        year = y;
        price = p;
        litres = l;
        fuel = new Fuel(f);
    }

    public Car(int y, double p, double l, int f){
        year = y;
        price = p;
        litres = l;
        fuel = new Fuel(f);
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public double getLitres() {
        return litres;
    }

    public Fuel getFuel() {
        return fuel;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setLitres(double litres) {
        this.litres = litres;
    }

    public void setFuel(Fuel fuel) {
        this.fuel = fuel;
    }

    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o== null || getClass() != o.getClass()){
            return false;
        }
        Car c = (Car) o;
        return year == c.getYear() && price == c.getPrice() && litres == c.getLitres() && fuel.equals(c.getFuel());
    }
}
