package org.seckill.jdbc;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.ResultSetMetaData;


public class Test{
    private static Connection conn=null;
    private static PreparedStatement pstmt=null;
    private static ResultSet rs=null;
    public static void main(String[] args) throws Exception{
        String url="jdbc:mysql://localhost:3306/seckill";
        String user="root";
        String password="1234";
        String sql=" SELECT * FROM seckill";
        try{

            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection(url,user,password);
            pstmt=conn.prepareStatement(sql);
            rs=pstmt.executeQuery(sql);
            ResultSetMetaData data=rs.getMetaData();
            int columnCount=data.getColumnCount();


            while(rs.next()){
                for(int i=1;i<=columnCount;i++){
                    System.out.print(rs.getString(i)+"   ");
                }
                System.out.println();
            }
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            rs.close();
            pstmt.close();
            conn.close();
        }
    }
}
