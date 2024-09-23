package CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class update {
    public static final String url="jdbc:mysql://localhost:3306/db";
    public static final String name="root";
    public static final String password="Saiyam09";

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try{
            Connection connection= DriverManager.getConnection(url,name,password);
            Statement statement=connection.createStatement();
            String query=String.format("UPDATE student SET age = %d Where id = %d",56,3);
            String query1=String.format("UPDATE student SET age = %d Where id = %d",56,4);
            int rs=statement.executeUpdate(query1);
            if(rs>0){
                System.out.println("updated");
            }else{
                System.out.println("not updated");
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }


    }
}
