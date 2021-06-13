package Hotel_Management_System;

import com.mysql.cj.jdbc.result.ResultSetImpl;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Department extends JFrame implements ActionListener {


    JButton b1,b2;
    JTable t1;

    Department(){

        t1 = new JTable();
        t1.setBounds(0, 50, 700, 330);
        add(t1);

        //Buttons
        b1 = new JButton("Submit");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(180, 400, 100, 30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(380, 400, 100, 30);
        b2.addActionListener(this);
        add(b2);

        //Add labels

        JLabel l3 = new JLabel("Department");
        l3.setBounds(150, 10, 100, 30);
        add(l3);

        JLabel l4 = new JLabel("Budget");
        l4.setBounds(490, 10, 100, 30);
        add(l4);



        //Basic frame
        setBounds(340, 30, 700, 480);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == b1){
            try{
                String str = "select * from department";

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
        new Department();
    }
}
