/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_crud_mvc.Connection;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.SQLException;
import java.sql.Connection;

/**
 *
 * @author Lenovo
 */
public class DatabaseConnection {
    
    static Connection connection;
    
    public static Connection connection() {
        if (connection == null) {
            MysqlDataSource data = new MysqlDataSource();
            data.setDatabaseName("java_swing_mvc");
            data.setUser("root");
            data.setPassword("root");
            try {
                connection = data.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return connection;
    }
}
