import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public abstract class Car {

    int id;
    private int year;
    private double price;
    private double litres;
    String Image;
    private Fuel fuel;

    protected Car(int id, int y, double p, double l, String i, Fuel f){
        this.id = id;
        year = y;
        price = p;
        litres = l;
        Image = i;
        fuel = f;
    }

    protected Car(int id, int y, double p, double l, String i, String f){
        this.id = id;
        year = y;
        price = p;
        litres = l;
        Image = i;
        fuel = new Fuel(f);
    }

    protected Car(int id, int y, double p, double l, String i, int f){
        this.id = id;
        year = y;
        price = p;
        litres = l;
        Image = i;
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
