package CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete {
    private static final String url="jdbc:mysql://localhost:3306/db";
    private static final String name="root";
    private static final String password="Saiyam09";
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try{
            Connection connection=DriverManager.getConnection(url,name,password);
            Statement statement=connection.createStatement();
            String query="DELETE FROM student WHERE ID=4";
            int ra=statement.executeUpdate(query);
            if(ra>0){
                System.out.println("row deleted");
            }else{
                System.out.println("not deleted");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
