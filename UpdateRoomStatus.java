package Hotel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.ImageGraphicAttribute;
import java.sql.ResultSet;

public class UpdateRoomStatus extends JFrame implements ActionListener {

    JTextField t1, t2, t3;
    Choice c1;
    JButton b1, b2, b3;

    UpdateRoomStatus() {

        JLabel l1 = new JLabel("Update Room Status");
        l1.setFont(new Font("Verdana", Font.ITALIC, 15));
        l1.setBounds(20, 30, 200, 30);
        add(l1);

        //Add image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/update_room.jpg"));
        JLabel img = new JLabel(i1);
        img.setBounds(350, 30, 612, 408);
        add(img);

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
        c1.setBounds(150, 80, 100, 30);
        add(c1);

        JLabel l3 = new JLabel("Room Number");
        l3.setBounds(30, 160, 100, 30);
        add(l3);
        t1 = new JTextField();
        t1.setBounds(150, 160, 100, 30);
        add(t1);

        JLabel l4 = new JLabel("Availability");
        l4.setBounds(30, 240, 100, 30);
        add(l4);
        t2 = new JTextField();
        t2.setBounds(150, 240, 100, 30);
        add(t2);

        JLabel l5 = new JLabel("Clean Status");
        l5.setBounds(30, 320, 100, 30);
        add(l5);
        t3 = new JTextField();
        t3.setBounds(150, 320, 100, 30);
        add(t3);

        b1 = new JButton("Check");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(50, 400, 100, 30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Update");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(175, 400, 100, 30);
        b2.addActionListener(this);
        add(b2);

        b3 = new JButton("Back");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setBounds(300, 400, 100, 30);
        b3.addActionListener(this);
        add(b3);

        //Basic frame
        setLayout(null);
        setBounds(150, 30, 1000, 500);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {   //Check
            //Store Room number
            String room = null;
            //Get guest ID number
            String s1 = c1.getSelectedItem();
            //Make connection
            DBConn c = new DBConn();
            try {
                //Get data from customers table
                ResultSet rs1 = c.s.executeQuery("select * from customers where number = '" + s1 + "'");
                while (rs1.next()) {
                    t1.setText(rs1.getString("room"));
                    room = rs1.getString("room");
                }
                //Get data from rooms table
                ResultSet rs2 = c.s.executeQuery("select * from rooms where room_number = '" + room + "'");
                while (rs2.next()) {
                    t2.setText(rs2.getString("available"));
                    t3.setText(rs2.getString("cleaning_status"));
                }
            } catch (Exception e) {
                System.out.println(e);
                e.printStackTrace();
            }
        } else if (ae.getSource() == b2) {     //Update
            //Get data
            String room = t1.getText();
            String available = t2.getText();
            String status = t3.getText();
            //Make connection
            DBConn c = new DBConn();
            String cmd = "update rooms set available = '" + available + "', cleaning_status = '" + status + "' where room_number = '" + room + "'";
            //Execute
            try {
                c.s.executeUpdate(cmd);
                JOptionPane.showMessageDialog(null, "Room details updated successfully");
                new Reception().setVisible(true);
                this.setVisible(false);
            } catch (Exception e) {
                System.out.println(e);
                e.printStackTrace();
            }
        } else if (ae.getSource() == b3) {
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new UpdateRoomStatus();
    }
}
