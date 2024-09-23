package Batch.prepared;



import java.sql.*;
import java.util.Scanner;

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
            String query = "INSERT INTO student(ID,NAME,AGE)VALUES(?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            Scanner sc=new Scanner(System.in);
            while(true){
                System.out.println("enter id");
                int id= sc.nextInt();
                System.out.println("enter name");
                String name = sc.next();
                System.out.println("enter age");
                int age= sc.nextInt();
                System.out.print("enetr more data Y?N");
                String choice=sc.next();
                preparedStatement.setInt(1,id);
                preparedStatement.setString(2,name);
                preparedStatement.setInt(3,age);
                preparedStatement.addBatch();
                if(choice.toUpperCase().equals("N")){
                    break;
                }
            }
            int rs[]= preparedStatement.executeBatch();
            for(int i=0;i<rs.length;i++){
                if(rs[i]==0){
                    System.out.println("query no is"+i+"not executed successfully");
                }
            }


        }catch (SQLException e){
            System.out.println(e.getMessage());
        }


    }
}
