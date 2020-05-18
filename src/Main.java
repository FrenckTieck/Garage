import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.PrintWriter;

public class Main {

    public static void main(String args[]) {
        CarFactory c = new CarFactory();
        UserFactory u = new UserFactory();

        String path = "";

        try{
            path = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getPath();
        } catch(Exception e){}

        String[] words = path.split("\\\\");
        words[words.length-1] = "";
        path = words[0];
        for(int i = 1; i < words.length-1; i++){
            path += "\\" + words[i];
        }

        c.addBMVV(2019, 20000, 125.25, "Model 1", 1, path + "\\Images\\car1.jpg");
        c.addAUDO(2018, 40000, 160.00, "Model 2", 0, path + "\\Images\\car2.jpg");
        c.addCITVAN(2014, 38000, 105.00, "Model 3", 0, path + "\\Images\\car3.jpg");
        c.addNISCAN(2013, 670000, 200.50, "Model 4", 0, path + "\\Images\\car4.jpg");
        c.addTOYO(2009, 50000, 130.25, "Model 5", 0, path + "\\Images\\car5.jpg");
        c.addVALVA(1990, 10000, 90.75, "Model 6", 1, path + "\\Images\\car6.jpg");
        c.addBMVV(2005, 100000, 150.00, "Model 7", 1, path + "\\Images\\car7.jpg");

        u.addAdmin("admin", "admin");
        u.addUser("user", "user");
        u.addAdmin("Kevin", "Kevin");
        u.addUser("Josh", "Josh");

        gui gui = new gui(c, u);
        gui.frame.setVisible(true);

    }
}
