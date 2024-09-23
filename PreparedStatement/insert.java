package PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class insert {
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
            Connection connection= DriverManager.getConnection(url,name,password);
            String query="INSERT INTO student(id,name,age)VALUES (?,?,?)";
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setInt(1,4);
            preparedStatement.setString(2,"Sangeeta");
            preparedStatement.setInt(3,56);
            int ra=preparedStatement.executeUpdate();
            if(ra>0){
                System.out.println("done");
            }else{
                System.out.println("not done");
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        System.out.println(
        );

    }
}
