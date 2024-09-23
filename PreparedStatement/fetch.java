package PreparedStatement;

import java.sql.*;

public class fetch{
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
            String query="SELECT * FROM student";
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
           while(rs.next()){
               int id=rs.getInt("id");
               String name=rs.getString("name");
               int age=rs.getInt("age");
               System.out.println(id+"\t"+name+"\t"+age);
           }
//            if(rs.next()){
//                int id=rs.getInt("id");
//                String name=rs.getString("name");
//                int age=rs.getInt("age");
//                System.out.println(id+"\t"+name+"\t"+age);
//            }else{
//                System.out.println("error");
//            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}

/*
if u need to retrive one data like age or marks use if satement
if u need to retrive whole statement use while statement
*/
