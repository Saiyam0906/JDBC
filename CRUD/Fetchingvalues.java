package CRUD;

import java.sql.*;

public class Fetchingvalues {
   private static final String url="jdbc:mysql://localhost:3306/db";
   private  static final String name="root";
    private static final String passdword="Saiyam09";
    public static void main(String[] args){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try{
            Connection connection=DriverManager.getConnection(url,name,passdword);
            Statement statement=connection.createStatement();
            String query="Select * from student";
           // statement.executeQuery(query);
            ResultSet rs=statement.executeQuery(query);
            while(rs.next()){
                int id=rs.getInt("id");
                String name=rs.getString("name");
                int age=rs.getInt("age");
                System.out.println(id+" "+name+" "+age);
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
}
