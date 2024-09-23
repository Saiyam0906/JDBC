package PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class update{
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
            String query = "update student set age=? where id=?";
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setInt(1, 29); // 1st parameter for 'age'
            preparedStatement.setInt(2, 2); // 2nd parameter for 'id'


            int rs=preparedStatement.executeUpdate();
            if(rs>0){
                System.out.println("data successfully");
            }else {
                System.out.println("not done");
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
}
