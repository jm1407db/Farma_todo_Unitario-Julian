package UI;

import java.awt.*;

import UI.LoginGUI;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MainMenuGUI extends JFrame{

    public MainMenuGUI(){
        /**Create the main menu interface
         * @autor Julian Moreno
         * @version V1.0
         * @param void
         * @return void
         */
        setSize(400, 600);
        setBackground(Color.cyan);
        setTitle("Main Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 1, 10, 10));

        JButton catalogButton=new JButton("View Catalog");
        JButton adminButton=new JButton("Druggist List");
        JButton exitButton=new JButton("Exit");
        JButton logOutButton=new JButton("Log Out");

        catalogButton.addActionListener(e ->{
            new FarmaTodoGUI().setVisible(true);
            this.dispose();
        });

        adminButton.addActionListener(e->{
            new FarmaceuticosMenu().setVisible(true);
            this.dispose();
        });

        logOutButton.addActionListener(e->{
            LoginGUI logout=new LoginGUI();
            this.dispose();
            logout.startLogin();
        });

        exitButton.addActionListener(e->{
            System.exit(0);
        });

        add(catalogButton);
        add(adminButton);
        add(logOutButton);
        add(exitButton);
    }
}
