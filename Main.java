package Hotel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//I am making a windows application. For that I will use JFrame/Swing for the GUI
public class Main extends JFrame implements ActionListener {
    //Constructor
    Main() {
        //Move and resize component
        //https://docs.oracle.com/javase/7/docs/api/java/awt/Window.html#setBounds(java.awt.Rectangle)
        //Set the frame size same as image size
        setBounds(200, 100, 980, 400);

        //A image of the hotel needs to be at the welcome page
        //https://docs.oracle.com/javase/7/docs/api/javax/swing/ImageIcon.html#:~:text=public%20ImageIcon(Image%20image),.awt.image.ImageObserver)
        //https://www.tutorialspoint.com/java/lang/classloader_getsystemresource.htm
        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("images/hotel_image.jpg"));

        //The image icon will be set inside a Jlabel
        //https://www.javatpoint.com/java-jlabel
        JLabel label1 = new JLabel(img1);
        //I want exact fit
        label1.setBounds(0, 0, 980, 400);
        //Add the component
        add(label1);

        JLabel label2 = new JLabel("Anusatya's hotel");
        //Text has to be located inside the first label
        //setBound args are given accordingly
        //https://www.tutorialspoint.com/how-to-change-jlabel-font-in-java
        label2.setBounds(350, 50, 200, 40);
        label2.setFont(new Font("Verdana", Font.ITALIC, 20));
        label1.add(label2);

        //Make a button
        //https://www.javatpoint.com/java-jbutton
        JButton b1 = new JButton("Welcome");
        b1.setBounds(540, 57, 90, 30);
        b1.setBackground(new Color(135, 206, 235));

        //https://www.javatpoint.com/java-actionlistener
        b1.addActionListener(this);

        label1.add(b1);

        //No layout
        setLayout(null);
        setVisible(true);

//        //I will now make the name blink
//        //https://docs.oracle.com/javase/tutorial/essential/concurrency/sleep.html
//        while (true) {
//            //The thread class is used here, the text will be made visible or not visible
//            //The program will be made slower with Thread.sleep()
//            label2.setVisible(false);
//            try {
//                Thread.sleep(500);
//            } catch (Exception e) {
//                //Nothing
//            }
//            label2.setVisible(true);
//            try {
//                Thread.sleep(500);
//            } catch (Exception e) {
//                //Nothing
//            }
//        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Default setVisible is false
        new LoginPage().setVisible(true);
        this.setVisible(false);
    }

    public static void main(String[] args) {
        // write your code here
        new Main();
    }
}
