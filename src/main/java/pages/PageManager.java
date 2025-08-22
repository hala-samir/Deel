package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitForSelectorState;

import java.nio.file.Paths;



public class PageManager {
    private Page page;

    public PageManager(Page page) {
        this.page = page;
    }

    // method for clicking an element
    public void clickElement(String element) {
        Locator locator = page.locator(element);
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
        locator.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        locator.click();
    }

    //method for pressing a keyboard button
    public void pressButtonFromKeyBoard(String buttonName) {
        page.keyboard().press(buttonName);
    }

    //method returns a text of an element
    public String getTextValue(String locator) {
        page.waitForLoadState(LoadState.NETWORKIDLE);
        return page.locator(locator).first().textContent().trim();
    }

    // enter text in a text field
    public void fillTextBox(String textBoxLocator, String textValue) {
        page.fill(textBoxLocator, textValue);
    }

    // wait for element to be visible
    public void waitForVisibilityOfElement(String element) {
        page.waitForSelector(element,
                new Page.WaitForSelectorOptions().setState(WaitForSelectorState.VISIBLE));
    }

    public void waitFor(int milliseconds){
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String takeScreenshot(){
        String path = System.getProperty("user.dir")+"\\screenshots\\"+ System.currentTimeMillis()+".png";
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));
        return path;

    }
}