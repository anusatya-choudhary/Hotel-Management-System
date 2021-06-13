package Hotel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

public class Room extends JFrame implements ActionListener {

    JTable t1;
    JButton b1, b2;

    Room(){
        t1 = new JTable();
        t1.setBounds(0, 40, 500, 400);
        add(t1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/room.jpg"));
        JLabel img = new JLabel(i1);
        img.setBounds(600, 100, 300, 300);
        add(img);

        JLabel l1 = new JLabel("Room number");
        l1.setBounds(10, 10, 100, 30);
        add(l1);

        JLabel l2 = new JLabel("Availabilty");
        l2.setBounds(120, 10, 100, 30);
        add(l2);

        JLabel l3 = new JLabel("Cleaning status");
        l3.setBounds(200, 10, 100, 30);
        add(l3);

        JLabel l4 = new JLabel("Price");
        l4.setBounds(330, 10, 100, 30);
        add(l4);

        JLabel l5 = new JLabel("Cleaning status");
        l5.setBounds(400, 10, 100, 30);
        add(l5);

        b1 = new JButton("Load rooms");
        b1.setBounds(100, 480, 120, 30);
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Go back");
        b2.setBounds(300, 480, 120, 30);
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        b2.addActionListener(this);
        add(b2);


        setLayout(null);
        setBounds(150, 20, 1000, 600);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == b1){
            try{
                //Make connection
                DBConn c = new DBConn();
                //Make command
                String cmd = "select * from rooms";
                ResultSet rs = c.s.executeQuery(cmd);
                //https://commons.apache.org/proper/commons-dbutils/
                //http://technojeeves.com/index.php/22-resultset-to-tablemodel
                t1.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
                System.out.println(e);
                e.printStackTrace();
            }
        }else if (ae.getSource() == b2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Room();
    }
}
