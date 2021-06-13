package Hotel_Management_System;

import com.mysql.cj.jdbc.result.ResultSetImpl;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Pickup extends JFrame implements ActionListener {

    Choice c1;
    JButton b1,b2;
    JTable t1;

    Pickup(){
        JLabel l1 = new JLabel("Pickup Service");
        l1.setFont(new Font("Verdana", Font.ITALIC, 17));
        l1.setForeground(Color.BLACK);
        l1.setBounds(445, 30, 200, 30);
        add(l1);

        JLabel l2 = new JLabel("Type of car");
        l2.setBounds(50, 100, 100, 30);
        add(l2);

        c1 = new Choice();
        try {
            DBConn c = new DBConn();
            ResultSet rs = c.s.executeQuery("select * from drivers");
            while (rs.next()) {
                c1.add(rs.getString("car_model"));
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        c1.setBounds(150, 100, 200, 30);
        add(c1);


        t1 = new JTable();
        t1.setBounds(0, 200, 1000, 200);
        add(t1);

        //Buttons
        b1 = new JButton("Submit");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(350, 445, 100, 30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(550, 445, 100, 30);
        b2.addActionListener(this);
        add(b2);

        //Add labels
        JLabel l6 = new JLabel("Name");
        l6.setBounds(30, 160, 80, 30);
        add(l6);

        JLabel l7 = new JLabel("Age");
        l7.setBounds(200, 160, 80, 30);
        add(l7);

        JLabel l3 = new JLabel("Gender");
        l3.setBounds(330, 160, 100, 30);
        add(l3);

        JLabel l4 = new JLabel("Company");
        l4.setBounds(460, 160, 80, 30);
        add(l4);

        JLabel l5 = new JLabel("Car model");
        l5.setBounds(630, 160, 80, 30);
        add(l5);

        JLabel l8 = new JLabel("Availability");
        l8.setBounds(740, 160, 80, 30);
        add(l8);

        JLabel l9 = new JLabel("Location");
        l9.setBounds(890, 160, 80, 30);
        add(l9);


        //Basic frame
        setBounds(140, 30, 1000, 550);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == b1){
            try{
                String str = "select * from drivers where car_model = '"+c1.getSelectedItem()+"'";

                DBConn c = new DBConn();
                ResultSet rs = c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));

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
        new Pickup();
    }
}
