package Hotel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener {
    //We have to make a menubar
    //https://www.javatpoint.com/java-jmenuitem-and-jmenu
    JMenuBar mb;
    JMenu m1, m2;
    JMenuItem i1, i2, i3, i4;

    //Make the constructor
    Dashboard() {
        mb = new JMenuBar();
        add(mb);
        mb.setBounds(0, 0, 900, 30);

        m1 = new JMenu("Hotel Management");
        mb.add(m1);

        m2 = new JMenu("Admin");
        mb.add(m2);

        i1 = new JMenuItem("Reception");
        i1.addActionListener(this);
        m1.add(i1);

        i2 = new JMenuItem("Add employee");
        i2.addActionListener(this);
        m2.add(i2);

        i3 = new JMenuItem("Add room");
        i3.addActionListener(this);
        m2.add(i3);

        i4 = new JMenuItem("Add driver");
        i4.addActionListener(this);
        m2.add(i4);

        //Set the background
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("images/dashboard.jpg"));
        JLabel bg = new JLabel(img);
        bg.setBounds(0, 0, 900, 611);
        add(bg);

        //Make a welcome message
        JLabel msg = new JLabel("Anusatya's hotel welcomes you!");
        msg.setBounds(450, 80, 500, 50);
        msg.setFont(new Font("Verdana", Font.ITALIC, 20));
        bg.add(msg);

        setLayout(null);
        setBounds(200, 50, 900, 611);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //https://docs.oracle.com/javase/7/docs/api/java/awt/event/ActionEvent.html#:~:text=getActionCommand,-public%20String%20getActionCommand&text=String%20getActionCommand()-,Returns%20the%20command%20string%20associated%20with%20this%20action.,%22%20and%20%22hide%20details%22.
        //https://stackoverflow.com/questions/8214958/the-getsource-and-getactioncommand/8215194
        if (ae.getActionCommand().equals("Reception")) {
            new Reception().setVisible(true);
            this.setVisible(false);
        } else if (ae.getActionCommand().equals("Add employee")) {
            new AddEmployee().setVisible(true);
            this.setVisible(false);
        } else if (ae.getActionCommand().equals("Add room")) {
            new AddRoom().setVisible(true);
            this.setVisible(false);
        } else if(ae.getActionCommand().equals("Add driver")){
            new AddDriver().setVisible(true);
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Dashboard();
    }
}
