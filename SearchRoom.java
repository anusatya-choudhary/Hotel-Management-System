package Hotel_Management_System;

import com.mysql.cj.jdbc.result.ResultSetImpl;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class SearchRoom extends JFrame implements ActionListener {

    JComboBox m1;
    JCheckBox c1;
    JButton b1,b2;
    JTable t1;

    SearchRoom(){
        JLabel l1 = new JLabel("Search for rooms");
        l1.setFont(new Font("Verdana", Font.ITALIC, 17));
        l1.setForeground(Color.BLACK);
        l1.setBounds(445, 30, 200, 30);
        add(l1);

        JLabel l2 = new JLabel("Room bed type");
        l2.setBounds(50, 100, 100, 30);
        add(l2);
        m1 = new JComboBox(new String[]{"Single Bed", "Double bed"});
        m1.setBounds(180, 100, 100, 30);
        add(m1);

        c1 = new JCheckBox("Only display available");
        c1.setBounds(450, 100, 180, 30);
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
        JLabel l6 = new JLabel("Room Number");
        l6.setBounds(50, 160, 80, 30);
        add(l6);

        JLabel l7 = new JLabel("Availability");
        l7.setBounds(270, 160, 80, 30);
        add(l7);

        JLabel l3 = new JLabel("Cleaning status");
        l3.setBounds(450, 160, 100, 30);
        add(l3);

        JLabel l4 = new JLabel("Price");
        l4.setBounds(670, 160, 80, 30);
        add(l4);

        JLabel l5 = new JLabel("Bed type");
        l5.setBounds(870, 160, 80, 30);
        add(l5);

        //Basic frame
        setBounds(140, 30, 1000, 550);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == b1){
            try{
                String str1 = "select * from rooms where bed_type = '"+m1.getSelectedItem()+"'";
                String str2 = "select * from rooms where available = 'Available' AND bed_type = '"+m1.getSelectedItem()+"'";
                DBConn c = new DBConn();

                if(c1.isSelected()){
                    ResultSet rs = c.s.executeQuery(str2);
                    t1.setModel(DbUtils.resultSetToTableModel(rs));
                }else{
                    ResultSet rs = c.s.executeQuery(str1);
                    t1.setModel(DbUtils.resultSetToTableModel(rs));
                }

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
        new SearchRoom();
    }
}
