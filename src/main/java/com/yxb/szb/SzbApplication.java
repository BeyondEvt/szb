package com.yxb.szb;

//import com.mysql.management.MysqldResource;
import com.wix.mysql.config.MysqldConfig;
import com.yxb.szb.config.EmbeddedMysqlConfig;
import com.yxb.szb.utils.JdbcUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@SpringBootApplication
public class SzbApplication {

    public static void main(String[] args) {
        //File file = new File("data");
        //System.out.println(file.list().length);
        //if (file.list().length  > 0) {
        //    System.out.println("数据库已存在，直接启动原数据库...");
        //    // 判断本地是否已存在数据库
        //    try {
        //        // 建立数据库连接
        //        JdbcUtils jdbcUtils = new JdbcUtils();
        //        Connection connection = jdbcUtils.getConnection();
        //
        //        // 执行SQL语句
        //        Statement statement = connection.createStatement();
        //        ResultSet resultSet = statement.executeQuery("SELECT VERSION()");
        //
        //        // 处理查询结果
        //        if (resultSet.next()) {
        //            String version = resultSet.getString(1);
        //            System.out.println("数据库版本号： " + version);
        //        }
        //
        //        // 关闭数据库连接
        //        resultSet.close();
        //        statement.close();
        //        connection.close();
        //    } catch (SQLException e) {
        //        System.err.println("数据库连接失败：" + e.getMessage());
        //    }
        //
        //
        //
        //    System.out.println(file.list());
        //} else {
        //    System.out.println("新建内嵌数据库...");
        //    EmbeddedMysqlConfig embeddedMysqlConfig = new EmbeddedMysqlConfig();
        //    embeddedMysqlConfig.launchDb();
        //}
        EmbeddedMysqlConfig embeddedMysqlConfig = new EmbeddedMysqlConfig();
        embeddedMysqlConfig.launchDb();


        System.out.println("Mysql启动成功...");
        SpringApplication.run(SzbApplication.class, args);
        System.out.println("spring 初始化成功");

    }

}
