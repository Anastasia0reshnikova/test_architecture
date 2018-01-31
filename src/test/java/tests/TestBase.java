package tests;

import manager.ApplicationManager;
import manager.watcher.SelenideTestWatcher;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestWatcher;

import java.sql.SQLException;

/**
 * Created by a.oreshnikova on 30.01.2018.
 */
public class TestBase {

    public static ApplicationManager app;

    @Rule
    public TestWatcher watcher = new SelenideTestWatcher();

    @BeforeClass
    public static void setUp(){
        app = new ApplicationManager();
        app.driver().goToUrl();
    }

    @AfterClass
    public static void tearDown() throws SQLException {
        if (app.driver() != null) {
            app.driver().stopDriver();
        }
    }
}
