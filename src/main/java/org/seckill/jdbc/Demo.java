package org.seckill.jdbc;

import java.sql.*;

public class Demo {
    public static void main(String[] args) throws ClassNotFoundException,SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/seckill?useUnicode=true&characterEncoding=utf-8";
        String username = "root";
        String password = "1234";

        Connection connect = DriverManager.getConnection(url,username,password);
        System.out.println("connect"+connect);
        Statement  stmt = connect.createStatement();
        System.out.println("stmt"+stmt);
        String sql2 = "select * from seckill";
        stmt.executeQuery(sql2);
        stmt.close();
        connect.close();
    }
}
