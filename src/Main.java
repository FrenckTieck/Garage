import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.PrintWriter;

public class Main {

    public static void main(String args[]) {
        CarFactory c = new CarFactory();
        UserFactory u = new UserFactory();
        c.addBMVV(2019, 20000, 125.25, "Model 1", 1, "Images/car1.jpg");
        c.addAUDO(2018, 40000, 160.00, "Model 2", 0, "Images/car2.jpg");
        c.addCITVAN(2014, 38000, 105.00, "Model 3", 0, "Images/car3.jpg");
        c.addNISCAN(2013, 670000, 200.50, "Model 4", 0, "Images/car4.jpg");
        c.addTOYO(2009, 50000, 130.25, "Model 5", 0, "Images/car5.jpg");
        c.addVALVA(1990, 10000, 90.75, "Model 6", 1, "Images/car6.jpg");
        c.addBMVV(2005, 100000, 150.00, "Model 7", 1, "Images/car7.jpg");

        u.addAdmin("admin", "admin");
        u.addUser("user", "user");
        u.addAdmin("Kevin", "Kevin");
        u.addUser("Josh", "Josh");

        gui gui = new gui(c, u);
        gui.frame.setVisible(true);
    }
}
