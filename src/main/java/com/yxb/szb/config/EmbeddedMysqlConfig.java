package com.yxb.szb.config;

import com.wix.mysql.ScriptResolver;
import com.wix.mysql.config.MysqldConfig;
import com.wix.mysql.EmbeddedMysql;


import java.util.concurrent.TimeUnit;

import static com.wix.mysql.config.MysqldConfig.aMysqldConfig;
import static com.wix.mysql.EmbeddedMysql.anEmbeddedMysql;
import static com.wix.mysql.distribution.Version.v5_6_23;
import static com.wix.mysql.config.Charset.UTF8;
import java.sql.Connection;
import java.util.Properties;
public class EmbeddedMysqlConfig {

    private EmbeddedMysql mysqld;

    public void launchDb(){
        //mysql版本
        MysqldConfig config = aMysqldConfig(v5_6_23)
                .withCharset(UTF8)
                //端口号
                .withPort(13306)
                //用户名密码
                .withUser("admin", "123456")
                //时区
                .withTimeZone("Asia/Shanghai")
                .withTimeout(2, TimeUnit.MINUTES)
                .withServerVariable("max_connect_errors", 666)
                .withTempDir("data/")
                .build();


        mysqld = anEmbeddedMysql(config)
                //初始化数据表结构
                .addSchema("yxb", ScriptResolver.classPathScript("db/user.sql"))
                //.addSchema("aschema2", ScriptResolver.classPathScripts("db/*.sql"))
                .start();

    }

    public void stopDb(){

        mysqld.stop();
    }
}
