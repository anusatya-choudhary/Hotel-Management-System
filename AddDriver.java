package Hotel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDriver extends JFrame implements ActionListener {

    JTextField t1, t2, t3, t4, t5;
    JComboBox c1, c2;
    JButton b1, b2;

    AddDriver() {
        //Title
        JLabel title = new JLabel("Add Driver");
        title.setBounds(50, 30, 150, 30);
        title.setFont(new Font("Verdana", Font.ITALIC, 19));
        add(title);

        //Add image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/add_driver.jpg"));
        JLabel img = new JLabel(i1);
        img.setBounds(400, 80, 300, 200);
        add(img);

        //Name
        JLabel name = new JLabel("Name: ");
        name.setBounds(50, 80, 100, 30);
        add(name);
        t1 = new JTextField();
        t1.setBounds(150, 80, 150, 30);
        add(t1);

        //Age
        JLabel age = new JLabel("Age: ");
        age.setBounds(50, 130, 100, 30);
        add(age);
        t2 = new JTextField();
        t2.setBounds(150, 130, 150, 30);
        add(t2);

        //Gender
        JLabel gender = new JLabel("Gender: ");
        gender.setBounds(50, 180, 100, 30);
        add(gender);
        c1 = new JComboBox(new String[]{"Male", "Female"});
        c1.setBounds(150, 180, 70, 30);
        c1.setBackground(Color.WHITE);
        add(c1);

        //Car company
        JLabel company = new JLabel("Car company: ");
        company.setBounds(50, 230, 100, 30);
        add(company);
        t3 = new JTextField();
        t3.setBounds(150, 230, 150, 30);
        add(t3);

        //Car model
        JLabel model = new JLabel("Car model: ");
        model.setBounds(50, 280, 100, 30);
        add(model);
        t4 = new JTextField();
        t4.setBounds(150, 280, 150, 30);
        add(t4);

        //Availability
        JLabel available = new JLabel("Availability: ");
        available.setBounds(50, 330, 100, 30);
        add(available);
        c2 = new JComboBox(new String[]{"Available", "Occupied"});
        c2.setBounds(150, 330, 120, 30);
        c2.setBackground(Color.WHITE);
        add(c2);

        //Location
        JLabel location = new JLabel("Location: ");
        location.setBounds(50, 380, 100, 30);
        add(location);
        t5 = new JTextField();
        t5.setBounds(150, 380, 150, 30);
        add(t5);

        //Submit button
        b1 = new JButton("Submit");
        b1.setBounds(50, 450, 80, 30);
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.addActionListener(this);
        add(b1);

        //Cancel button
        b2 = new JButton("Cancel");
        b2.setBounds(200, 450, 80, 30);
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        b2.addActionListener(this);
        add(b2);

        //Basic frame
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(200, 50, 900, 550);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            //Gather data
            String name = t1.getText();
            String age = t2.getText();
            String gender = (String) c1.getSelectedItem();
            String company = t3.getText();
            String model = t4.getText();
            String available = (String) c2.getSelectedItem();
            String location = t5.getText();

            //Make the connection
            DBConn c = new DBConn();
            //Make the command
            String cmd = "insert into drivers values('" + name + "','" + age + "','" + gender + "','" + company + "','" + model + "','" + available + "','" + location + "')";
            try {

                //Insert entry
                //https://www.tutorialspoint.com/what-is-the-difference-between-execute-executequery-and-executeupdate-methods-in-jdbc
                c.s.executeUpdate(cmd);
                JOptionPane.showMessageDialog(null, "Driver details added.");
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
        new AddDriver();
    }
}
 /*
    SQL commands

    create table drivers(name varchar(30), age varchar(10), gender varchar(15), car_company varchar(20), car_model varchar(20), availability varchar(20), location varchar(20));

 */