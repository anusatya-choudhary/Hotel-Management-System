package Hotel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class AddCustomer extends JFrame implements ActionListener {

    JTextField t1, t2, t3, t4, t5;
    JButton b1, b2;
    JComboBox c1;
    Choice c2;
    JRadioButton r1, r2;

    AddCustomer(){
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/new_customer.jpg"));
        JLabel img = new JLabel(i1);
        img.setBounds(450, 40, 411, 500);
        add(img);

        JLabel l1 = new JLabel("NEW CUSTOMER FORM");
        l1.setBounds(150, 20, 200, 30);
        l1.setFont(new Font("Verdana", Font.ITALIC, 15));
        add(l1);

        JLabel l2 = new JLabel("Id:");
        l2.setBounds(50, 80, 150, 30);
        l2.setFont(new Font("Verdana", Font.PLAIN, 14));
        add(l2);
        c1 = new JComboBox(new String[] {"Passport", "Voter ID Card", "Driving License", "Aadhar Card"});
        c1.setBounds(200, 80, 100, 30);
        c1.setBackground(Color.WHITE);
        add(c1);

        JLabel l3 = new JLabel("Number:");
        l3.setBounds(50, 140, 150, 30);
        l3.setFont(new Font("Verdana", Font.PLAIN, 14));
        add(l3);
        t1 = new JTextField();
        t1.setBounds(200, 140, 150, 30);
        add(t1);

        JLabel l4 = new JLabel("Name:");
        l4.setBounds(50, 200, 150, 30);
        l4.setFont(new Font("Verdana", Font.PLAIN, 14));
        add(l4);
        t2 = new JTextField();
        t2.setBounds(200, 200, 150, 30);
        add(t2);

        JLabel l5 = new JLabel("Gender:");
        l5.setBounds(50, 260, 150, 30);
        l5.setFont(new Font("Verdana", Font.PLAIN, 14));
        add(l5);
        r1 = new JRadioButton("Male");
        r1.setBackground(Color.WHITE);
        r1.setBounds(200, 260, 80, 30);
        add(r1);
        r2 = new JRadioButton("Female");
        r2.setBackground(Color.WHITE);
        r2.setBounds(280, 260, 80, 30);
        add(r2);

        JLabel l6 = new JLabel("Country:");
        l6.setBounds(50, 320, 150, 30);
        l6.setFont(new Font("Verdana", Font.PLAIN, 14));
        add(l6);
        t3 = new JTextField();
        t3.setBounds(200, 320, 150, 30);
        add(t3);

        JLabel l7 = new JLabel("Room Number:");
        l7.setBounds(50, 380, 150, 30);
        l7.setFont(new Font("Verdana", Font.PLAIN, 14));
        add(l7);
        c2 = new Choice();
        try{
            DBConn c = new DBConn();
            String cmd = "select * from rooms";
            ResultSet rs = c.s.executeQuery(cmd);

            while(rs.next()){
                c2.add(rs.getString("room_number"));
            }
        }catch (Exception e){
            System.out.println(e);
            e.printStackTrace();
        }
        c2.setBounds(200, 380, 100, 80);
        add(c2);

        JLabel l8 = new JLabel("Checked In:");
        l8.setBounds(50, 440, 150, 30);
        l8.setFont(new Font("Verdana", Font.PLAIN, 14));
        add(l8);
        t4 = new JTextField();
        t4.setBounds(200, 440, 150, 30);
        add(t4);

        JLabel l9 = new JLabel("Deposit:");
        l9.setBounds(50, 500, 150, 30);
        l9.setFont(new Font("Verdana", Font.PLAIN, 14));
        add(l9);
        t5 = new JTextField();
        t5.setBounds(200, 500, 150, 30);
        add(t5);

        b1 = new JButton("Add Customer");
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.setBounds(60, 550, 120, 30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Go back");
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        b2.setBounds(200, 550, 120, 30);
        b2.addActionListener(this);
        add(b2);


        //Basic Frame
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(150, 0, 1000, 650);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == b1){

            String id = (String)c1.getSelectedItem();
            String number = t1.getText();
            String name = t2.getText();
            String gender = null;
            if(r1.isSelected()){
                gender = "Male";
            }else if(r2.isSelected()){
                gender = "Female";
            }
            String country = t3.getText();
            String room = c2.getSelectedItem();
            String status = t4.getText();
            String deposit = t5.getText();

            String cmd1 = "insert into customers values('" +id+ "','" +number+ "','" +name+ "','" +gender+ "','" +country+ "','" +room+ "','" +status+ "','" +deposit+ "')";
            String cmd2 = "update rooms set available = 'Occupied' where room_number = '" +room+ "'";
            try{
                DBConn c = new DBConn();
                c.s.executeUpdate(cmd1);
                c.s.executeUpdate(cmd2);
                JOptionPane.showMessageDialog(null,"New Customer Added.");
                new Reception().setVisible(true);
                this.setVisible(false);
            }catch (Exception e){
                System.out.println(e);
                e.printStackTrace();
            }

        }else if(ae.getSource() == b2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddCustomer();
    }
}
 /*
    SQL commands

    create table customers(id varchar(20), number varchar(20), name varchar(30), gender varchar(15), country varchar(20), room varchar(10), status varchar(20), deposit varchar(20));
 */