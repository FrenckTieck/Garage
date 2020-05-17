import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Main {

    public static void main(String args[]) {
        ArrayList<Integer> test = new ArrayList<Integer>();
        test.add(1);
        System.out.println(test.size());



        String userhome = System.getProperty("user.home");
        JFileChooser chooser = new JFileChooser(userhome);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("jpg, png, jpeg", "jpg", "png", "jpeg");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            System.out.println("You chose to open this file: " +
                    chooser.getSelectedFile().getName());
        }

        try{
            PrintWriter w = new PrintWriter("Printed Files/test.txt", "UTF-8");
            w.println("test1");
            w.close();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
