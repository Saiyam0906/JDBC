package PreparedStatement;

import java.sql.*;

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
        try {
            Connection connection= DriverManager.getConnection(url,name,password);
            String query="Delete from student where id=?";
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setInt(1,4);
            int rs=preparedStatement.executeUpdate();
            if(rs>0){
                System.out.println("deleted");
            }else{
                System.out.println("not deleted");
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
