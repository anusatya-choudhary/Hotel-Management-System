package Hotel_Management_System;

import java.sql.*;

//The purpose of this class is to create a 'connection' with the local mysql database
public class DBConn {
    //https://www.javatpoint.com/example-to-connect-to-the-mysql-database
    Connection c;
    Statement s;

    public DBConn() {
        try {
            //JDBC is an API that connects the Java application and a relational DB and enables us to execute queries
            //from the application on the database
            Class.forName("com.mysql.cj.jdbc.Driver");
            //hms is the name of the database
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hms", "root", "mysql");
            s = c.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
