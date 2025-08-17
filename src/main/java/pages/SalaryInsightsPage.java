package pages;

import factories.PlaywrightFactory;

public class SalaryInsightsPage extends PageManager {
    public SalaryInsightsPage() {
        super(PlaywrightFactory.getPage());
    }

    private String singleJobOptionGenericLocator = "//li[normalize-space()='%s']";
    private String jobTextField = "//input[@name='role']";
    private String countryDropDownList = "//div[@data-text='Country']//button//div";
    private String optionsList = "//div[contains(@class,'MuiPaper-elevation')]";
    private String singleCountryOptionGerenricLocator = "//p[normalize-space()='%s']";
    private String resultHeadingText = "//h2[contains(@class, 'css-96d55p')]";
    private String searchButton = "//button[@type='submit']";

    public void selectJobFromDropDownMenu(String roleName) {
        fillTextBox(jobTextField, roleName);
        //wait for menu loading
        waitFor(2000);
        pressButtonFromKeyBoard("ArrowDown");
        waitFor(2000);
        waitForVisibilityOfElement(optionsList);
        String optionLocator = String.format(singleJobOptionGenericLocator, roleName);
        clickElement(optionLocator);
    }

    public void selectCountryFromDropDownMenu(String countryName) {
        clickElement(countryDropDownList);
        waitForVisibilityOfElement(optionsList);
        String optionLocator = String.format(singleCountryOptionGerenricLocator, countryName);
        clickElement(optionLocator);
    }

    public void clickSearchButton() {
        clickElement(searchButton);
    }

    public String getResultHeadingText() {
        System.out.println("Text of resultHeadingText=> " + getTextValue(resultHeadingText));
        return getTextValue(resultHeadingText);
    }
}
