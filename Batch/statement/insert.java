package Batch.statement;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
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
            Statement statement=connection.createStatement();
            Scanner sc=new Scanner(System.in);
            while(true){
                System.out.println("enter id");
                int id= sc.nextInt();
                System.out.println("entyer name");
                String name=sc.next();
                System.out.println("enter age");
                int age= sc.nextInt();
                System.out.print("enetr more data Y?N");
                String choice=sc.next();
                String queery=String.format("INSERT INTO student(ID,NAME,AGE)VALUES(%d,'%s',%d)",id,name,age);
                statement.addBatch(queery);
                if(choice.toUpperCase().equals("N")){
                    break;
                }
            }
           int rs[]= statement.executeBatch();
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