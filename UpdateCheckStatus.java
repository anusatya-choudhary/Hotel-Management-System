package Hotel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateCheckStatus extends JFrame implements ActionListener {

    JTextField t1,t2,t3,t4, t5;
    JButton b1,b2,b3;
    Choice c1;

    UpdateCheckStatus(){
        JLabel l1 = new JLabel("Check-in update");
        l1.setFont(new Font("Verdana", Font.ITALIC, 15));
        l1.setBounds(20, 30, 200, 30);
        add(l1);

        //Add image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/update_status.jpg"));
        JLabel img = new JLabel(i1);
        img.setBounds(350, 50, 612, 408);
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
        c1.setBounds(150, 85, 100, 30);
        add(c1);

        JLabel l3 = new JLabel("Room Number");
        l3.setBounds(30, 140, 100, 30);
        add(l3);
        t1 = new JTextField();
        t1.setBounds(150, 140, 100, 30);
        add(t1);

        JLabel l4 = new JLabel("Name");
        l4.setBounds(30, 200, 100, 30);
        add(l4);
        t2 = new JTextField();
        t2.setBounds(150, 200, 100, 30);
        add(t2);

        JLabel l5 = new JLabel("Check-in Status");
        l5.setBounds(30, 260, 100, 30);
        add(l5);
        t3 = new JTextField();
        t3.setBounds(150, 260, 100, 30);
        add(t3);

        JLabel l6 = new JLabel("Account Paid");
        l6.setBounds(30, 320, 100, 30);
        add(l6);
        t4 = new JTextField();
        t4.setBounds(150, 320, 100, 30);
        add(t4);

        JLabel l7 = new JLabel("Pending Account");
        l7.setBounds(30, 380, 100, 30);
        add(l7);
        t5 = new JTextField();
        t5.setBounds(150, 380, 100, 30);
        add(t5);

        //Buttons
        b1 = new JButton("Check");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(50, 445, 100, 30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Update");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(175, 445, 100, 30);
        b2.addActionListener(this);
        add(b2);

        b3 = new JButton("Back");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setBounds(300, 445, 100, 30);
        b3.addActionListener(this);
        add(b3);

        //Basic frame
        setLayout(null);
        setBounds(150, 30, 1000, 550);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {   //Check
            //Store Room number
            String room = null;
            String deposit = null;
            String price = null;
            int due = 0;
            //Get guest ID number
            String s1 = c1.getSelectedItem();
            //Make connection
            DBConn c = new DBConn();
            try {
                //Get data from customers table
                ResultSet rs1 = c.s.executeQuery("select * from customers where number = '" + s1 + "'");
                while (rs1.next()) {
                    t1.setText(rs1.getString("room"));
                    t2.setText(rs1.getString("name"));
                    t3.setText(rs1.getString("status"));
                    t4.setText(rs1.getString("deposit"));
                    room = rs1.getString("room");
                    deposit = rs1.getString("deposit");
                }
                //Get data from rooms table
                ResultSet rs2 = c.s.executeQuery("select * from rooms where room_number = '" + room + "'");
                while (rs2.next()) {
                    price = rs2.getString("price");
                    due = Integer.parseInt(price) - Integer.parseInt(deposit);
                    t5.setText(Integer.toString(due));
                }
            } catch (Exception e) {
                System.out.println(e);
                e.printStackTrace();
            }
        } else if (ae.getSource() == b2) {     //Update

            String s1 = c1.getSelectedItem();
            String s2 = t1.getText(); //room_number;
            String s3 = t2.getText(); //name
            String s4 = t3.getText(); //status;
            String s5 = t4.getText(); //deposit

            DBConn c = new DBConn();

            try {
                c.s.executeUpdate("update customers set room = '"+s2+"', name = '"+s3+"', status = '"+s4+"', deposit = '"+s5+"' where number = '"+s1+"'");
            }catch (Exception e){
                System.out.println(e);
                e.printStackTrace();
            }

            JOptionPane.showMessageDialog(null, "Data Updated Successfully");
            new Reception().setVisible(true);
            setVisible(false);
        } else if (ae.getSource() == b3) {
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new UpdateCheckStatus();
    }
}
