package cn.damonzzz.JDBC;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfManager {
    Properties properties = new Properties();
    InputStream is = null;
    private static ConfManager confManager = null;

    private ConfManager(){
        is = ConfManager.class.getClassLoader().getResourceAsStream("database.properties");
        if(is == null){
            System.out.println("fail!");
        }
        try {
            properties.load(is);
            is.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static ConfManager getInstance(){
        if(confManager == null){
            confManager = new ConfManager();
        }
        return  confManager;
    }

    public String getValue(String key){
        return properties.getProperty(key);
    }
}
