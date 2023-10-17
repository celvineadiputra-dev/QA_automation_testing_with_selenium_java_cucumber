package stepDef;

import config.SetupDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook extends SetupDriver {
    @Before
    public void startHook() {
        startDriver();
    }

    @After(order = 0)
    public void closeBrowser() {
        this.getWebDriver().close();
    }
}
