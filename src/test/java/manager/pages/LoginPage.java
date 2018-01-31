package manager.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import manager.ApplicationManager;
import manager.PageHelper;
import model.User;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by a.oreshnikova on 30.01.2018.
 */
public class LoginPage extends PageHelper{

    public LoginPage(ApplicationManager app) {
        super(app);
    }

    private SelenideElement fillEmail = $("");
    private SelenideElement fillPassword = $("");

    private SelenideElement buttonEnter = $("");

    public void login(User user) {
        fillField(fillEmail, user.email());
        fillField(fillPassword, user.password());
        buttonEnter.shouldBe(Condition.visible).click();
    }
}
