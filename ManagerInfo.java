package Hotel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
//https://stackoverflow.com/questions/1051640/correct-way-to-add-external-jars-lib-jar-to-an-intellij-idea-project
import net.proteanit.sql.*;

public class ManagerInfo extends JFrame implements ActionListener {

    //https://www.javatpoint.com/java-jtable
    JTable t1;
    JButton b1,b2;

    ManagerInfo(){
        t1 = new JTable();
        t1.setBounds(0, 50, 1000, 500);
        add(t1);

        //Add buttons
        b1 = new JButton("Load Data");
        b1.setBounds(300, 565, 100, 30);
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Go Back");
        b2.setBounds(600, 565, 100, 30);
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        b2.addActionListener(this);
        add(b2);

        //Add labels
        JLabel l1 = new JLabel("Name");
        l1.setBounds(40, 10, 80, 30);
        add(l1);

        JLabel l2 = new JLabel("Age");
        l2.setBounds(180, 10, 80, 30);
        add(l2);

        JLabel l3 = new JLabel("Gender");
        l3.setBounds(300, 10, 80, 30);
        add(l3);

        JLabel l4 = new JLabel("Department");
        l4.setBounds(400, 10, 80, 30);
        add(l4);

        JLabel l5 = new JLabel("Salary");
        l5.setBounds(540, 10, 80, 30);
        add(l5);

        JLabel l6 = new JLabel("Phone");
        l6.setBounds(660, 10, 80, 30);
        add(l6);

        JLabel l7 = new JLabel("Aadhar");
        l7.setBounds(780, 10, 80, 30);
        add(l7);

        JLabel l8 = new JLabel("Email");
        l8.setBounds(900, 10, 80, 30);
        add(l8);


        setLayout(null);
        setBounds(150,30,1000, 650);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == b1){

            try{
                //Make the connection
                DBConn c = new DBConn();
                //Make the command
                String cmd = "select * from employees where job = 'Manager'";

                ResultSet rs = c.s.executeQuery(cmd);
                //https://commons.apache.org/proper/commons-dbutils/
                //http://technojeeves.com/index.php/22-resultset-to-tablemodel
                t1.setModel(DbUtils.resultSetToTableModel(rs));

            }catch(Exception e){
                System.out.println(e);
                e.printStackTrace();
            }

        }else if(ae.getSource() == b2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new ManagerInfo();
    }
}
