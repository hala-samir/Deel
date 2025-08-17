package factories;

import com.microsoft.playwright.*;
import utilities.PropertiesHandler;

import java.io.IOException;
import java.util.Properties;

public class PlaywrightFactory {
    private static ThreadLocal<Playwright> playwrightThread = new ThreadLocal<>();
    private static ThreadLocal<Browser> browserThread = new ThreadLocal<>();
    private static ThreadLocal<BrowserContext> contextThread = new ThreadLocal<>();
    private static ThreadLocal<Page> pageThread = new ThreadLocal<>();

    // Initialize browser and page
    public static void initBrowser(Properties prop) {
        String browserName= prop.getProperty("browser");
        try {
            playwrightThread.set(Playwright.create());
            switch (browserName.toLowerCase().trim()){
                case "chrome":
                    browserThread.set(playwrightThread.get().chromium().launch(
                    new BrowserType.LaunchOptions()
                            .setHeadless(Boolean.parseBoolean(PropertiesHandler.getProperty("headless")))
                    ));
                break;
                case "firefox":
                    browserThread.set(playwrightThread.get().firefox().launch(
                            new BrowserType.LaunchOptions()
                                    .setHeadless(Boolean.parseBoolean(PropertiesHandler.getProperty("headless")))
                    ));
                    break;
                default:
                    System.out.println("Please, add a valid browser name");
                    break;
            }

            contextThread.set(browserThread.get().newContext());
            pageThread.set(contextThread.get().newPage());
            pageThread.get().navigate(PropertiesHandler.getProperty("url"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Getters for ThreadLocal objects
    public static Page getPage() {
        return pageThread.get();
    }

    public static Browser getBrowser() {
        return browserThread.get();
    }

    public static BrowserContext getContext() {
        return contextThread.get();
    }

    // Close everything
    public static void tearDown() {
        if (pageThread.get() != null) pageThread.get().close();
        if (contextThread.get() != null) contextThread.get().close();
        if (browserThread.get() != null) browserThread.get().close();
        if (playwrightThread.get() != null) playwrightThread.get().close();

        pageThread.remove();
        contextThread.remove();
        browserThread.remove();
        playwrightThread.remove();
    }

}
