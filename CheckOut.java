package Hotel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class CheckOut extends JFrame implements ActionListener {

    JTextField t1;
    Choice c1;
    JButton b1, b2, b3;

    CheckOut() {
        //Add image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/checkout.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(350, 230, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(350, 20, 350, 230);
        add(img);

        JLabel l1 = new JLabel("Checkout");
        l1.setBounds(30, 20, 100, 30);
        l1.setFont(new Font("Verdana", Font.ITALIC, 15));
        add(l1);

        JLabel l2 = new JLabel("Guest ID");
        l2.setBounds(30, 80, 100, 30);
        add(l2);
        c1 = new Choice();
        try {
            DBConn c = new DBConn();
            ResultSet rs = c.s.executeQuery("select * from customers");
            while (rs.next()) {
                c1.add(rs.getString("number"));
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        c1.setBounds(150, 85, 100, 30);
        add(c1);

        JLabel l3 = new JLabel("Room Number");
        l3.setBounds(30, 140, 100, 30);
        add(l3);
        t1 = new JTextField();
        t1.setBounds(150, 140, 100, 30);
        add(t1);

        //Buttons
        b1 = new JButton("Check");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(25, 200, 100, 30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Checkout");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(135, 200, 100, 30);
        b2.addActionListener(this);
        add(b2);

        b3 = new JButton("Back");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setBounds(240, 200, 100, 30);
        b3.addActionListener(this);
        add(b3);

        //Basic Frame
        setLayout(null);
        setBounds(250, 200, 800, 300);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == b1){   //Check
            //Get guest ID number
            String s1 = c1.getSelectedItem();
            //Make connection
            DBConn c = new DBConn();
            try {
                //Get data from customers table
                ResultSet rs1 = c.s.executeQuery("select * from customers where number = '" + s1 + "'");
                while (rs1.next()) {
                    t1.setText(rs1.getString("room"));
                }
            } catch (Exception e) {
                System.out.println(e);
                e.printStackTrace();
            }
        }else if(ae.getSource() == b2){     //Checkout
            //Get guest ID number
            String id = c1.getSelectedItem();
            //Store Room number
            String room = t1.getText();
            //Commands
            String str1 = "delete from customers where number = '" +id+ "'";
            String str2 = "update rooms set available = 'Available' where room_number = '"+room+"'";
            DBConn c = new DBConn();
            try {
                c.s.executeUpdate(str1);
                c.s.executeUpdate(str2);
                JOptionPane.showMessageDialog(null,"Checkout completed.");
                new Reception().setVisible(true);
                this.setVisible(false);
            } catch (Exception e) {
                System.out.println(e);
                e.printStackTrace();
            }
        }else if(ae.getSource() == b3){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new CheckOut();
    }
}
