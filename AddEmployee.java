package Hotel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.ImageGraphicAttribute;
import java.sql.ResultSet;

public class AddEmployee extends JFrame implements ActionListener {

    JTextField t1, t2, t3, t4, t5, t6;
    JRadioButton rb1, rb2;
    JComboBox c1;
    JButton b1, b2;

    AddEmployee() {
        //Add title label
        JLabel title = new JLabel("Register Employee");
        title.setBounds(350, 30, 250, 30);
        title.setFont(new Font("Verdana", Font.PLAIN, 20));
        add(title);

        //Add image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/add_employee.jpg"));
        //Scale the image
        //https://stackoverflow.com/questions/7252983/resizing-image-java-getscaledinstance
        Image i2 = i1.getImage().getScaledInstance(500, 375, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(360, 90, 500, 375);
        add(img);

        int offset = 60;
        //Name
        JLabel name = new JLabel("Name:");
        name.setBounds(60, 30 + offset, 100, 30);
        add(name);

        t1 = new JTextField();
        t1.setBounds(160, 30 + offset, 180, 30);
        add(t1);

        //Age
        JLabel age = new JLabel("Age:");
        age.setBounds(60, 80 + offset, 100, 30);
        add(age);

        t2 = new JTextField();
        t2.setBounds(160, 80 + offset, 180, 30);
        add(t2);

        //Gender (radio button)
        JLabel gender = new JLabel("Gender:");
        gender.setBounds(60, 130 + offset, 100, 30);
        add(gender);
        //https://www.javatpoint.com/java-jradiobutton
        rb1 = new JRadioButton("Male");
        rb1.setBounds(160, 130 + offset, 70, 30);
        rb1.setBackground(Color.WHITE);
        add(rb1);
        rb2 = new JRadioButton("Female");
        rb2.setBounds(230, 130 + offset, 70, 30);
        rb2.setBackground(Color.WHITE);
        add(rb2);

        //Job (Drop down)
        JLabel job = new JLabel("Job:");
        job.setBounds(60, 180 + offset, 100, 30);
        add(job);
        //https://www.javatpoint.com/java-jcombobox
        String jobs[] = {"Receptionist", "Porters", "Housekeeping", "Kitchen Staff", "Room Service", "Waiter/Waitress", "Manager", "Accountant", "Chef"};
        c1 = new JComboBox(jobs);
        c1.setBounds(160, 180 + offset, 125, 30);
        c1.setBackground(Color.WHITE);
        add(c1);

        //Salary
        JLabel salary = new JLabel("Salary:");
        salary.setBounds(60, 230 + offset, 100, 30);
        add(salary);

        t3 = new JTextField();
        t3.setBounds(160, 230 + offset, 180, 30);
        add(t3);

        //Phone
        JLabel phone = new JLabel("Phone:");
        phone.setBounds(60, 280 + offset, 100, 30);
        add(phone);

        t4 = new JTextField();
        t4.setBounds(160, 280 + offset, 180, 30);
        add(t4);

        //Aadhar
        JLabel aadhar = new JLabel("Aadhar:");
        aadhar.setBounds(60, 330 + offset, 100, 30);
        add(aadhar);

        t5 = new JTextField();
        t5.setBounds(160, 330 + offset, 180, 30);
        add(t5);

        //Email
        JLabel email = new JLabel("Email:");
        email.setBounds(60, 380 + offset, 100, 30);
        add(email);

        t6 = new JTextField();
        t6.setBounds(160, 380 + offset, 180, 30);
        add(t6);

        //Submit Button
        b1 = new JButton("Submit");
        b1.setBounds(90, 520, 80, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Back");
        b2.setBounds(200, 520, 100, 30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);


        //Main frame
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(200, 0, 900, 700);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == b1){
            //Gather all text
            String name = t1.getText();
            String age = t2.getText();
            String salary = t3.getText();
            String phone = t4.getText();
            String aadhar = t5.getText();
            String email = t6.getText();

            String gender = null;
            if(rb1.isSelected())
                gender = "Male";
            else
                gender = "Female";

            String job = (String)c1.getSelectedItem();

            //Make connection
            DBConn c = new DBConn();
            //Make the command
            String cmd = "insert into employees values('" +name+ "','" +age+ "','" +gender+ "','" +job+ "','" +salary+ "','" +phone+ "','" +aadhar+ "','" +email+ "')";

            try{

                //Insert entry
                //https://www.tutorialspoint.com/what-is-the-difference-between-execute-executequery-and-executeupdate-methods-in-jdbc
                c.s.executeUpdate(cmd);
                JOptionPane.showMessageDialog(null,"New employee details added!");
                this.setVisible(false);

            }catch (Exception e){
                System.out.println(e);
                e.printStackTrace();
            }
        }else{
            new Dashboard().setVisible(true);
            this.setVisible(false);
        }

    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}
 /*
 SQl commands

 create table employees(name varchar(30), age varchar(10), gender varchar(15), job varchar(30), salary varchar(20), phone varchar(15), aadhar varchar(20), email varchar(30));

 */