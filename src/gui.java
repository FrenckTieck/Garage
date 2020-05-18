import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

public class gui {

    public CarFactory cars;
    public UserFactory users;
    public User user;
    public JToolBar menu;
    public JFrame frame;
    public JPanel home;
    public JPanel car;
    public JPanel current;
    public JPanel previous;
    public JPanel login;
    public JPanel signUp;
    public String[] brands = {"BMVV", "AUDO", "CITVAN", "NISCAN", "VALVA", "TOYO", ""};
    String path;

    public gui(CarFactory c, UserFactory u){
        car = null;
        login = null;
        signUp = null;

        cars = c;
        users = u;
        user = null;
        frame = new JFrame("Home");
        frame.setFont(new Font("Verdana", 1, 20));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1500, 1000);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        menu = new JToolBar();
        JButton b1 = new JButton("Back");
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                previous();
            }
        });

        JButton b2 = new JButton("Login");
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginPage();
            }
        });
        JButton b3 = new JButton("Sign Up");
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                signUpPage();
            }
        });
        menu.add(b1);
        menu.addSeparator();
        menu.add(b2);
        menu.addSeparator();
        menu.add(b3);
        menu.addSeparator();

        JLabel header = new JLabel("Awesome Autos");
        header.setFont(new Font("Comic Sans MS", 1, 36));
        menu.add(BorderLayout.CENTER, header);

        frame.getContentPane().add(BorderLayout.NORTH, menu);

        home = new JPanel();
        home.setLayout(new BoxLayout(home, BoxLayout.Y_AXIS));

        JPanel cars = new JPanel();
        cars.setLayout(new BoxLayout(cars, BoxLayout.Y_AXIS));

        for(int i = 0; i < c.howManyCars(); i++){
            Car c1 = c.cars.get(i);
            JPanel temp = new JPanel();
            JPanel text = new JPanel();
            text.setLayout(new BoxLayout(text, BoxLayout.Y_AXIS));

            brands[6] = c1.getModel();
            int b = brand(c1);
            JLabel n = new JLabel(brands[b]);
            n.setFont(new Font("Arial Black", 1, 28));

            JButton m = new JButton(c1.getModel());
            m.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    carPage(c1);
                }
            });
            JLabel y = new JLabel(String.valueOf(c1.getYear()));
            JLabel p = new JLabel("£" + String.valueOf(c1.getPrice()));
            JLabel l = new JLabel(String.valueOf(c1.getLitres()+" litres"));
            JLabel f = new JLabel(c1.getFuel().getFuel());
            JLabel s = new JLabel("<html><br/></html>");
            JLabel imageLabel = null;

            path = "";

            try{
                path = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getPath();
            } catch(Exception e){}

            String[] words = path.split("\\\\");
            words[words.length-1] = "";
            path = words[0];
            for(int in = 1; in < words.length-1; in++){
                path += "\\" + words[in];
            }

            try {
                BufferedImage tempImage = null;
                if(b == 0){
                    tempImage = ImageIO.read(new File(((BMVV) c1).getImage()));
                }else if(b == 1){
                    tempImage = ImageIO.read(new File(((AUDO) c1).getImage()));
                } else if(b == 2){
                    tempImage = ImageIO.read(new File(((CITVAN) c1).getImage()));
                } else if (b == 3){
                    tempImage = ImageIO.read(new File(((NISCAN) c1).getImage()));
                } else if (b == 4){
                    tempImage = ImageIO.read(new File(((VALVA) c1).getImage()));
                }else if (b == 5){
                    tempImage = ImageIO.read(new File(((TOYO) c1).getImage()));
                }else {
                    tempImage = ImageIO.read(new File(path + "\\Images\\car7.jpg"));
                }

                double ratio = (double) tempImage.getHeight()/200;
                double doubleWidth = (double) tempImage.getWidth()/ratio;
                int width = (int) doubleWidth;
                Image Image = tempImage.getScaledInstance(width, 200, 1);
                imageLabel = new JLabel(new ImageIcon(Image));
            }catch(Exception e){}

            temp.add(imageLabel);
            text.add(n);
            text.add(m);
            text.add(y);
            text.add(p);
            text.add(l);
            text.add(f);
            text.add(s);
            temp.add(text);
            cars.add(temp);

        }

        JScrollPane sp = new JScrollPane(cars);
        sp.getVerticalScrollBar().setUnitIncrement(16);
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        sp.setBounds(50,30,1500,1000);
        home.add(sp);
        frame.getContentPane().add(BorderLayout.CENTER, home);
        previous = null;
        current = home;
    }

    public void loginPage(){
        if(login == null){
            login = new JPanel();
            login.setLayout(new BoxLayout(login, BoxLayout.Y_AXIS));
            JLabel kop = new JLabel("Login");
            kop.setFont(new Font("Verdana", 1, 30));
            login.add(BorderLayout.EAST, kop);

            JPanel u = new JPanel();
            u.setLayout(new BoxLayout(u, BoxLayout.X_AXIS));
            JLabel us = new JLabel("username");
            u.add(us);
            JTextField t = new JTextField();
            t.setMaximumSize(new Dimension(500, 50));
            u.add(t);
            login.add(u);

            JPanel p = new JPanel();
            p.setLayout(new BoxLayout(p, BoxLayout.X_AXIS));
            JLabel pa = new JLabel("password");
            p.add(pa);
            JPasswordField pt = new JPasswordField();
            pt.setMaximumSize(new Dimension(500, 50));
            p.add(pt);
            login.add(p);

            JLabel message = new JLabel();
            JButton b = new JButton("Submit");
            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    boolean l = logginIn(t.getText(), new String(pt.getPassword()));
                    if(l){
                        t.setText("");
                        pt.setText("");
                        message.setText("");
                        login.setVisible(false);
                        previous.setVisible(true);
                        current = previous;
                        previous = null;
                        menuLogin();
                        frame.invalidate();
                        frame.validate();
                    } else {
                        message.setText("<html><font color='red'>Wrong Username or Password</font></html>");
                    }
                }
            });

            login.add(BorderLayout.EAST, b);
            login.add(BorderLayout.AFTER_LAST_LINE, message);
            frame.add(BorderLayout.CENTER, login);
        }
        current.setVisible(false);
        login.setVisible(true);
        previous = current;
        current = login;
        frame.invalidate();
        frame.validate();

    }

    public void signUpPage(){
        if(signUp == null){
            signUp = new JPanel();
            signUp.setLayout(new BoxLayout(signUp, BoxLayout.Y_AXIS));
            JLabel kop = new JLabel("Sign Up");
            kop.setFont(new Font("Verdana", 1, 30));
            signUp.add(BorderLayout.EAST, kop);

            JPanel u = new JPanel();
            u.setLayout(new BoxLayout(u, BoxLayout.X_AXIS));
            JLabel us = new JLabel("username");
            u.add(us);
            JTextField t = new JTextField();
            t.setMaximumSize(new Dimension(500, 50));
            u.add(t);
            signUp.add(u);

            JPanel p = new JPanel();
            p.setLayout(new BoxLayout(p, BoxLayout.X_AXIS));
            JLabel pa = new JLabel("password");
            p.add(pa);
            JTextField pt = new JTextField();
            pt.setMaximumSize(new Dimension(500, 50));
            p.add(pt);
            signUp.add(p);

            JLabel message = new JLabel();
            JButton b = new JButton("Submit");
            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(pt.getText().length() > 4){
                        boolean s = singingUp(t.getText(), pt.getText());
                        if(s){
                            logginIn(t.getText(), pt.getText());
                            t.setText("");
                            pt.setText("");
                            message.setText("");
                            signUp.setVisible(false);
                            previous.setVisible(true);
                            current = previous;
                            previous = null;
                            menuLogin();
                            frame.invalidate();
                            frame.validate();
                        } else {
                            message.setText("<html><font color='red'>Username Taken</font></html>");
                        }
                    } else {
                        message.setText("<html><font color='red'>Password to short</font></html>");
                    }
                }
            });

            signUp.add(BorderLayout.EAST, b);
            signUp.add(BorderLayout.AFTER_LAST_LINE, message);
            frame.add(BorderLayout.CENTER, signUp);
        }
        current.setVisible(false);
        signUp.setVisible(true);
        previous = current;
        current = signUp;
        frame.invalidate();
        frame.validate();
    }

    public int brand(Car c){
        if(c instanceof BMVV){
            return 0;
        } else if(c instanceof AUDO){
            return 1;
        }else if(c instanceof CITVAN){
            return 2;
        }else if(c instanceof NISCAN){
            return 3;
        }else if(c instanceof VALVA){
            return 4;
        }else if(c instanceof TOYO){
            return  5;
        }else {
            return 6;
        }
    }

    public void carPage(Car c){
        if(car == null){
            car = new JPanel();
        } else {
            car.removeAll();
        }
        int b = brand(c);
        brands[6] = c.getModel();
        String brand = brands[b];

        JLabel imageLabel = null;
        try {
            BufferedImage tempImage = null;
            if(b == 0){
                tempImage = ImageIO.read(new File(((BMVV) c).getImage()));
            }else if(b == 1){
                tempImage = ImageIO.read(new File(((AUDO) c).getImage()));
            } else if(b == 2){
                tempImage = ImageIO.read(new File(((CITVAN) c).getImage()));
            } else if (b == 3){
                tempImage = ImageIO.read(new File(((NISCAN) c).getImage()));
            } else if (b == 4){
                tempImage = ImageIO.read(new File(((VALVA) c).getImage()));
            }else if (b == 5){
                tempImage = ImageIO.read(new File(((TOYO) c).getImage()));
            }else {
                tempImage = ImageIO.read(new File(path + "\\Images\\car7.jpg"));
            }

            double ratio = (double) tempImage.getHeight()/500;
            double doubleWidth = (double) tempImage.getWidth()/ratio;
            int width = (int) doubleWidth;
            Image Image = tempImage.getScaledInstance(width, 500, 1);
            imageLabel = new JLabel(new ImageIcon(Image));
        }catch(Exception e){}

        car.add(imageLabel);


        JPanel text = new JPanel();

        JLabel n = new JLabel(brand);
        n.setFont(new Font("Arial Black", 1, 50));
        JLabel m = new JLabel(c.getModel());
        m.setFont(new Font("Arial Black", 1, 35));

        JLabel space = new JLabel("<html><br/></html>");
        space.setFont(new Font("Verdana", 1, 25));
        JLabel y = new JLabel("Year " + String.valueOf(c.getYear()));
        y.setFont(new Font("Verdana", 1, 25));
        JLabel p = new JLabel("€" + String.valueOf(c.getPrice()));
        p.setFont(new Font("Verdana", 1, 25));
        JLabel l = new JLabel(String.valueOf(c.getLitres()+" litres"));
        l.setFont(new Font("Verdana", 1, 25));
        JLabel f = new JLabel(c.getFuel().getFuel());
        f.setFont(new Font("Verdana", 1, 25));

        text.add(n);
        text.add(m);
        text.add(space);
        text.add(y);
        text.add(p);
        text.add(l);
        text.add(f);
        text.setLayout(new BoxLayout(text, BoxLayout.Y_AXIS));

        car.add(text);

        frame.add(BorderLayout.CENTER, car);
        current.setVisible(false);
        car.setVisible(true);
        previous = current;
        current = car;
        frame.invalidate();
        frame.validate();
    }

    public void previous(){
        if(previous != null) {
            current.setVisible(false);
            previous.setVisible(true);
            JPanel temp = current;
            current = previous;
            previous = temp;
            frame.invalidate();
            frame.validate();
        }
    }

    public boolean logginIn(String u, String p){
        User temp = users.login(u, p);
        if(temp != null) {
            user = temp;
            return true;
        } else {
            return false;
        }
    }

    public void menuLogin(){
        menu.removeAll();
        JButton b1 = new JButton("Back");
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                previous();
            }
        });
        menu.add(b1);
        menu.addSeparator();
        if(user.getAdmin()){
            JButton b2 = new JButton("Write Stock to file");
            b2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    writeToFile();
                }
            });
            menu.add(b2);
            menu.addSeparator();
        }

        JLabel header = new JLabel("Awesome Autos");
        header.setFont(new Font("Comic Sans MS", 1, 36));
        menu.add(BorderLayout.CENTER, header);
        menu.addSeparator();
        JLabel username = new JLabel("Hello " + user.getUsername());
        username.setFont(new Font("Verdana", 1, 25));
        menu.add(BorderLayout.EAST, username);
        menu.addSeparator();
        JButton logout = new JButton("Logout");
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logout();
            }
        });
        menu.add(BorderLayout.EAST, logout);
    }

    public void writeToFile(){
        try{
            PrintWriter w = new PrintWriter(path + "\\StockValue.txt", "UTF-8");
            w.println(cars.printStockLevel());
            w.close();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void logout(){
        menu.removeAll();
        user = null;
        JButton b1 = new JButton("Back");
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                previous();
            }
        });

        JButton b2 = new JButton("Login");
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginPage();
            }
        });
        JButton b3 = new JButton("Sign Up");
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                signUpPage();
            }
        });
        menu.add(b1);
        menu.addSeparator();
        menu.add(b2);
        menu.addSeparator();
        menu.add(b3);
        menu.addSeparator();

        JLabel header = new JLabel("Awesome Autos");
        header.setFont(new Font("Comic Sans MS", 1, 36));
        menu.add(BorderLayout.CENTER, header);
        menu.setVisible(false);
        menu.invalidate();
        menu.validate();
        menu.setVisible(true);
    }

    public boolean singingUp(String u, String p){
        return users.addUser(u, p);
    }


}
