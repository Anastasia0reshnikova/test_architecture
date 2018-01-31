package manager.watcher;

import com.codeborne.selenide.Selenide;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

/**
 * Created by a.oreshnikova on 31.01.2018.
 */
public class SelenideTestWatcher extends TestWatcher {

    @Override
    protected void starting(Description description) {
        System.out.println("Test " + description.getMethodName() + " starting.");
    }

    @Override
    protected void failed(Throwable e, Description description) {
        Selenide.refresh();
    }

    @Override
    protected void finished(Description description) {
        System.out.println("Test finished.");
    }
}
