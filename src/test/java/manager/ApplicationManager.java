package manager;

import manager.pages.LoginPage;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by a.oreshnikova on 30.01.2018.
 */

public class ApplicationManager {

    private static Properties properties;
    private DriverConfiguration driverConfiguration;
    private ApplicationManager app;

    private LoginPage login;

    public ApplicationManager() {
        init();
    }

    private void init(){
        properties = new Properties();
        loadProperties();
    }

    private void loadProperties(){
        try {
            properties.load(new FileReader(new File("src/test/resources/local.properties")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperties(String prop) {
        return properties.getProperty(prop);
    }

    public DriverConfiguration driver() {
        if(driverConfiguration == null) {
            driverConfiguration = new DriverConfiguration(app);
        }
        return driverConfiguration;
    }

    //___________________________________________ PAGES _______________________________________________

    public LoginPage login() {
        if(login == null) {
            login = new LoginPage(app);
        }
        return login;
    }
}
