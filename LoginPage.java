package Hotel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class LoginPage extends JFrame implements ActionListener {
    //There are two labels, Username and Password
    JLabel label1, label2;
    JTextField user;
    JPasswordField pass;
    //There are two buttons, Login and Cancel
    JButton button1, button2;

    //Define the constructor
    LoginPage() {
        //Set the background
        //https://docs.oracle.com/javase/7/docs/api/javax/swing/ImageIcon.html#:~:text=public%20ImageIcon(Image%20image),.awt.image.ImageObserver)
        //https://www.tutorialspoint.com/java/lang/classloader_getsystemresource.htm
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("images/login.jpg"));
        JLabel bg = new JLabel(img);
        bg.setBounds(0, 0, 800, 528);
        add(bg);

        //Instance the labels
        //https://www.javatpoint.com/java-jlabel
        label1 = new JLabel("Username: ");
        label1.setBounds(90, 130, 80, 30);
        bg.add(label1);

        label2 = new JLabel("Password: ");
        label2.setBounds(90, 180, 80, 30);
        bg.add(label2);

        //Instance the textfields
        //https://www.javatpoint.com/java-jtextfield
        user = new JTextField();
        user.setBounds(170, 130, 150, 30);
        bg.add(user);

        //https://www.javatpoint.com/java-jpasswordfield
        pass = new JPasswordField();
        pass.setBounds(170, 180, 150, 30);
        bg.add(pass);

        //I make the buttons
        //https://www.javatpoint.com/java-jbutton
        button1 = new JButton("Login");
        button1.setBounds(100, 230, 80, 30);
        button1.setBackground(Color.BLACK);
        button1.setForeground(Color.WHITE);

        //https://www.javatpoint.com/java-actionlistener
        button1.addActionListener(this);

        bg.add(button1);

        button2 = new JButton("Cancel");
        button2.setBounds(200, 230, 80, 30);
        button2.setBackground(Color.BLACK);
        button2.setForeground(Color.WHITE);

        //https://www.javatpoint.com/java-actionlistener
        button2.addActionListener(this);

        bg.add(button2);


        //Defining the basic frame
        setBounds(240, 80, 800, 528);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //https://hajsoftutorial.com/actionevent-getsource/
        if (ae.getSource() == button1)   //For login button
        {
            String username = user.getText();
            char[] getPass = pass.getPassword();
            //To convert char[] to string
            String password = String.valueOf(getPass);
            //Make the database connection
            DBConn c = new DBConn();
            //Name of table is 'userbase'
            //Make the query
            String query = "select * from userbase where username='" + username + "' and password='" + password + "'";

            try {
                //https://docs.oracle.com/javase/tutorial/jdbc/basics/processingsqlstatements.html
                //https://docs.oracle.com/javase/7/docs/api/java/sql/ResultSet.html#:~:text=A%20table%20of%20data%20representing,positioned%20before%20the%20first%20row.
                //https://www.tutorialspoint.com/java-resultset-next-method-with-example#:~:text=The%20next()%20method%20of,createStatement()%3B%20ResultSet%20rs%20%3D%20stmt.
                ResultSet rs = c.s.executeQuery(query);
                //We have a tabular result
                //It should have only one entry, initially the rs pointer is before the first row
                if (rs.next()) {
                    new Dashboard().setVisible(true);
                } else {
                    //https://www.javatpoint.com/java-joptionpane
                    JOptionPane.showMessageDialog(null, "Invalid username/password");
                }
                this.setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == button2){
            //For Cancel button
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new LoginPage();
    }
}

 /*
 SQL commands

 create table userbase(username varchar(30), password varchar(30));
 insert into userbase values('admin', '12345');

 */