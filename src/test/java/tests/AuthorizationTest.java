package tests;

import model.User;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by a.oreshnikova on 30.01.2018.
 */

public class AuthorizationTest extends TestBase {

    @Test
    public void loginTest() {
        app.login().login(new User().email("").password(""));
        assertThat("Пользователь")
                .as("Авторизация не выполнена!")
                .isEqualToIgnoringCase("Пользователь");
    }
}
