package ir.znu.sad.data.mysql;

import ir.znu.sad.data.datatype.Table;
import ir.znu.sad.utils.datatype.Pair;

import java.sql.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class MySQlTools {

    static Connection mysqlDbConn = null;
    static PreparedStatement mysqlPrepareStat = null;

    static String dbBaseUrl="jdbc:mysql://localhost:3306/";
    static String dbName = "znu_sad";
    static String dbUser = "root";//""nil";//"root";
    static String dbPass = "my-root";//"password";//"my-root";

    private static void makeJDBCConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Congrats - Seems your MySQL JDBC Driver Registered!");
        } catch (ClassNotFoundException e) {
            System.out.println("Sorry, couldn't found JDBC driver. Make sure you have added JDBC Maven Dependency Correctly");
            e.printStackTrace();
            return;
        }
        try {
            // DriverManager: The basic service for managing a set of JDBC drivers.
            mysqlDbConn = DriverManager.getConnection(dbBaseUrl+dbName, dbUser, dbPass);
            if (mysqlDbConn != null) {
                System.out.println("Connection Successful! Enjoy. Now it's time to push data");
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException e) {
            System.out.println("MySQL Connection Failed!");
            e.printStackTrace();
            return;
        }
    }

    public static int selectCount(String sqlQuery) {
        return Integer.parseInt(selectTable(sqlQuery,new String[]{"count"}).getRows().get(0)[0]);
    }
    public static Table selectTable(String sqlQuery, String[] columnNames) {
        Table result = new Table(sqlQuery,
                Arrays.stream(columnNames).map(s -> new Pair<>(s,Table.ColumnType.STRING)).collect(Collectors.toList()));
        // Open a connection
        try(Connection conn = DriverManager.getConnection(dbBaseUrl+dbName, dbUser, dbPass);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sqlQuery);
        ) {
            while (rs.next()) {
                String[] row = new String[result.getColumns().length];
                for (int i = 0; i < result.getColumns().length; i++) {
                    row[i]=rs.getString(result.getColumns()[i].getKey());
                }
                result.addRowValue(row);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}