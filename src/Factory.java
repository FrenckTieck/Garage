public class Factory {

    public CarFactory cars;
    public UserFactory users;

    public Factory(){
        cars = new CarFactory();
        users = new UserFactory();
    }


}
