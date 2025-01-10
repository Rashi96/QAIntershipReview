package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

    Properties pro;

    public ReadConfig() {
        File src = new File("./Configurations/config.properties");
        try {
            FileInputStream fis = new FileInputStream(src);
            pro = new Properties();
            pro.load(fis);
        } catch (Exception e) {
            System.out.println("Exception is" + e.getMessage());
        }

    }

    public String getUrl() {
        String url = pro.getProperty("url");
        return url;
    }

    public String getEmail() {
        String email = pro.getProperty("email");
        return email;
    }

    public String getPassword() {
        String password = pro.getProperty("password");
        return password;
    }


}
