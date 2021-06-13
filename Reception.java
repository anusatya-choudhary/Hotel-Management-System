package Hotel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame implements ActionListener {

    JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12;

    Reception() {

        //Add image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/reception.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img  = new JLabel(i3);
        img.setBounds(300,50,450,500);
        add(img);

        //Add buttons
        b1 = new JButton("New Customer Form");
        b1.setBounds(50, 30, 180, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Room");
        b2.setBounds(50, 80, 180, 30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);

        b3 = new JButton("Department");
        b3.setBounds(50, 130, 180, 30);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.addActionListener(this);
        add(b3);

        b4 = new JButton("All Employees Info");
        b4.setBounds(50, 180, 180, 30);
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        b4.addActionListener(this);
        add(b4);

        b5 = new JButton("Customer Info");
        b5.setBounds(50, 230, 180, 30);
        b5.setBackground(Color.BLACK);
        b5.setForeground(Color.WHITE);
        b5.addActionListener(this);
        add(b5);

        b6 = new JButton("Manager Info");
        b6.setBounds(50, 280, 180, 30);
        b6.setBackground(Color.BLACK);
        b6.setForeground(Color.WHITE);
        b6.addActionListener(this);
        add(b6);

        b7 = new JButton("Checkout");
        b7.setBounds(50, 330, 180, 30);
        b7.setBackground(Color.BLACK);
        b7.setForeground(Color.WHITE);
        b7.addActionListener(this);
        add(b7);

        b8 = new JButton("Update Check status");
        b8.setBounds(50, 380, 180, 30);
        b8.setBackground(Color.BLACK);
        b8.setForeground(Color.WHITE);
        b8.addActionListener(this);
        add(b8);

        b9 = new JButton("Update Room status");
        b9.setBounds(50, 430, 180, 30);
        b9.setBackground(Color.BLACK);
        b9.setForeground(Color.WHITE);
        b9.addActionListener(this);
        add(b9);

        b10 = new JButton("Pick up service");
        b10.setBounds(50, 480, 180, 30);
        b10.setBackground(Color.BLACK);
        b10.setForeground(Color.WHITE);
        b10.addActionListener(this);
        add(b10);

        b11 = new JButton("Search room");
        b11.setBounds(50, 530, 180, 30);
        b11.setBackground(Color.BLACK);
        b11.setForeground(Color.WHITE);
        b11.addActionListener(this);
        add(b11);

        b12 = new JButton("Logout");
        b12.setBounds(50, 580, 180, 30);
        b12.setBackground(Color.BLACK);
        b12.setForeground(Color.WHITE);
        b12.addActionListener(this);
        add(b12);

        //Basic frame
        setBounds(250, 0, 800, 660);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == b1){           //New Customer form
            new AddCustomer().setVisible(true);
            this.setVisible(false);
        }else if(ae.getSource() == b2){     //Room
            new Room().setVisible(true);
            this.setVisible(false);
        }else if(ae.getSource() == b3){     //Department
            new Department().setVisible(true);
            this.setVisible(false);
        }else if(ae.getSource() == b4){     //All employees Info
            new EmployeeInfo().setVisible(true);
            this.setVisible(false);
        }else if(ae.getSource() == b5){     //Customer Info
            new CustomerInfo().setVisible(true);
            this.setVisible(false);
        }else if(ae.getSource() == b6){     //Manager Info
            new ManagerInfo().setVisible(true);
            this.setVisible(false);
        }else if(ae.getSource() == b7){     //Checkout
            new CheckOut().setVisible(true);
            this.setVisible(false);
        }else if(ae.getSource() == b8){     //Update Check status
            new UpdateCheckStatus().setVisible(true);
            this.setVisible(false);
        }else if(ae.getSource() == b9){     //Update room status
            new UpdateRoomStatus().setVisible(true);
            this.setVisible(false);
        }else if(ae.getSource() == b10){    //Pick up service
            new Pickup().setVisible(true);
            this.setVisible(false);
        }else if(ae.getSource() == b11){    //Search room
            new SearchRoom().setVisible(true);
            this.setVisible(false);
        }else if(ae.getSource() == b12){    //Logout
            this.setVisible(false);
            new Main();
        }
    }

    public static void main(String[] args) {
        new Reception();
    }
}
