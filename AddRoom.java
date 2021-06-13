package Hotel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class AddRoom extends JFrame implements ActionListener {

    JTextField t1, t2;
    JComboBox c1, c2, c3;
    JButton b1, b2;

    AddRoom() {
        //Add the title
        JLabel title = new JLabel("Add room");
        title.setBounds(50, 20, 150, 30);
        title.setFont(new Font("Verdama", Font.ITALIC, 25));
        add(title);

        //Add image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/add_room.jpg"));
        JLabel img = new JLabel(i1);
        img.setBounds(400, 50, 550, 366);
        add(img);

        //Room number
        JLabel room = new JLabel("Room Number:");
        room.setBounds(50, 80, 150, 30);
        room.setFont(new Font("Verdana", Font.PLAIN, 15));
        add(room);
        t1 = new JTextField();
        t1.setBounds(200, 80, 150, 30);
        add(t1);

        //Availability
        JLabel available = new JLabel("Availability:");
        available.setBounds(50, 130, 150, 30);
        available.setFont(new Font("Verdana", Font.PLAIN, 15));
        add(available);

        c1 = new JComboBox(new String[]{"Available", "Occupied"});
        c1.setBounds(200, 130, 100, 30);
        add(c1);

        //Cleaning status
        JLabel status = new JLabel("Cleaning status:");
        status.setBounds(50, 180, 150, 30);
        status.setFont(new Font("Verdana", Font.PLAIN, 15));
        add(status);

        c2 = new JComboBox(new String[]{"Clean", "Dirty"});
        c2.setBounds(200, 180, 80, 30);
        add(c2);

        //Price
        JLabel price = new JLabel("Price:");
        price.setBounds(50, 230, 150, 30);
        price.setFont(new Font("Verdana", Font.PLAIN, 15));
        add(price);
        t2 = new JTextField();
        t2.setBounds(200, 230, 150, 30);
        add(t2);

        //Bed type
        JLabel type = new JLabel("Bed Type:");
        type.setBounds(50, 280, 150, 30);
        type.setFont(new Font("Verdana", Font.PLAIN, 15));
        add(type);

        c3 = new JComboBox(new String[]{"Single bed", "Double bed"});
        c3.setBounds(200, 280, 100, 30);
        add(c3);

        //Add room button
        b1 = new JButton("Add room");
        b1.setBounds(50, 360, 100, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);

        //Add cancel button
        b2 = new JButton("Back");
        b2.setBounds(180, 360, 100, 30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);


        //Basic frame
        setBounds(180, 100, 1000, 500);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b1) {
            //Gather form data
            String room = t1.getText();
            String available = (String) c1.getSelectedItem();
            String status = (String) c2.getSelectedItem();
            String price = t2.getText();
            String type = (String) c3.getSelectedItem();

            //Make connection
            DBConn c = new DBConn();
            //Make the command
            String cmd = "insert into rooms values('" + room + "','" + available + "','" + status + "','" + price + "','" + type + "')";

            try {

                //Insert entry
                //https://www.tutorialspoint.com/what-is-the-difference-between-execute-executequery-and-executeupdate-methods-in-jdbc
                c.s.executeUpdate(cmd);
                JOptionPane.showMessageDialog(null, "Room added successfully");
                this.setVisible(false);

            } catch (Exception e) {
                System.out.println(e);
                e.printStackTrace();
            }
        } else {
            new Dashboard().setVisible(true);
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddRoom();
    }
}

 /*
    SQL commands

    create table rooms(room_number varchar(10), available varchar(20), cleaning_status varchar(20), price varchar(10), bed_type varchar(20));
 */
