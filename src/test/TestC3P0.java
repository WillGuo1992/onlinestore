package test;

import org.apache.commons.dbutils.QueryRunner;
import utils.JDBCUtil;

import java.sql.SQLException;

/**
 * @description: 测试c3p0数据库连接池和dbutils数据库操作组件
 * @author: Will.Guo
 * @create: 2018-06-10 15:48
 **/
public class TestC3P0 {
    public static void main(String args[]) throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "update user set password=? where username=?";
        qr.update(sql,"aaaa","aaa");
        System.out.println("ccccc");
    }
}
