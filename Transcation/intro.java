package Transcation;

import java.sql.*;
import java.util.Scanner;

public class intro {
    private static final String url="jdbc:mysql://localhost:3306/trans";
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
            connection.setAutoCommit(false);
            String debit="update accounts set balance = balance-? where acc_no =?";
            String credit="update accounts set balance = balance+? where acc_no=?";
            PreparedStatement p1=connection.prepareStatement(debit);
            PreparedStatement p2=connection.prepareStatement(credit);
            Scanner sc=new Scanner(System.in);
            System.out.println("enter the amount");
            int amount= sc.nextInt();
            p1.setInt(1,amount);
            p1.setInt(2,102);
            p2.setInt(1,amount);
            p2.setInt(2,101);
            p1.executeUpdate();
            p2.executeUpdate();
            if(min(connection,102,amount)){
               connection.commit();
                System.out.println("Transcation successfull");
            }else{
                connection.rollback();
                System.out.println("insufficent balance");
            }


        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    static boolean min(Connection connection,int acc_no,int amount){
        try{
            String query="select balance from accounts where acc_no=?";
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setInt(1,acc_no);
            ResultSet rs=preparedStatement.executeQuery();
            if(rs.next()){
                int cb=rs.getInt("balance");
                if(amount>cb){
                    return false;
                }else{
                    return true;
                }
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
}
