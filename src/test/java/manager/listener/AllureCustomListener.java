package manager.listener;

import io.qameta.allure.junit4.AllureJunit4;
import org.junit.runner.notification.Failure;

/**
 * Created by a.oreshnikova on 31.01.2018.
 */
public class AllureCustomListener  extends AllureJunit4 {

    @Override
    public void testFailure(Failure failure) throws Exception {
        super.testFailure(failure);
    }
}
