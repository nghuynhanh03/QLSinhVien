/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Admin
 */
public class MyConnection {
    public static Connection getConnection(){
        Connection cn = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbStudent", "root", "root");
        }catch(ClassNotFoundException e){
            System.out.println("ClassNotFoundException " + e);
        }catch(SQLException e){
            System.out.println("SQLException " + e);
        }
        return cn;
    }}
