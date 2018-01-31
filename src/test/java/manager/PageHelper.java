package manager;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.sleep;

/**
 * Created by a.oreshnikova on 30.01.2018.
 */
public class PageHelper {

    protected ApplicationManager app;

    public PageHelper(ApplicationManager app){
        this.app = app;
    }

    protected void fillField(SelenideElement locator, String text) {
        locator.click();
        if (text != null) {
            locator.setValue(text);
        }
    }

    protected void fillFieldWithClear(SelenideElement element, String text) {
        element.click();
        element.clear();
        element.sendKeys(text);
        sleep(500);
    }

    //Заполнять поле по буквам
    public void fillFieldSpellOut(SelenideElement element, String value)
    {
        element.click();
        sleep(50);
        if(value != null) {
            element.clear();
            for (int i = 0; i < value.length(); i++){
                char c = value.charAt(i);
                String s = String.valueOf(c);
                element.sendKeys(s);
            }
        }
    }
}
