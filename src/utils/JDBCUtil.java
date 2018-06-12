package utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @description: JDBC工具类，此处应用C3P0
 * @author: Will.Guo
 * @create: 2018-06-10 15:11
 **/
public class JDBCUtil {
    private static ComboPooledDataSource dataSource;
    static {
        dataSource = new ComboPooledDataSource();
    }

    public static DataSource getDataSource (){
        return dataSource;
    }

    public  static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public  static void release(Connection conn) throws SQLException {
        conn.close();

    }
}
