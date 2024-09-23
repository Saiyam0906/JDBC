package CRUD;

import java.sql.*;

public class insert {
    private static final String url="jdbc:mysql://localhost:3306/db";
    private static final String name="root";
    private static final String password="Saiyam09";
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        try{
            Connection connection= DriverManager.getConnection(url,name,password);
            Statement statement=connection.createStatement();
            String queery=String.format("INSERT INTO student(ID,NAME,AGE)VALUES(%o,'%s',%o)",3,"Suresh",56);
            String queery1=String.format("INSERT INTO student(ID,NAME,AGE)VALUES(%d,'%s',%d)",4,"Sangeeta",56);
            int rs=statement.executeUpdate(queery1);
            if(rs>0){
                System.out.println("data inserted successfully");
            }else{
                System.out.println("data not inserted");
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }


    }
}
