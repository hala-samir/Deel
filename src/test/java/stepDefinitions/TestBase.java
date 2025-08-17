package stepDefinitions;

import factories.PlaywrightFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.PropertiesHandler;

import java.util.Properties;

public class TestBase {
    Properties prop;

    @Before
    public void openTheApp(){
        prop = PropertiesHandler.initializeTestConfigurations();
        PlaywrightFactory.initBrowser(prop);
    }

    @After
    public void tearDown() {
        PlaywrightFactory.tearDown();
    }
}
