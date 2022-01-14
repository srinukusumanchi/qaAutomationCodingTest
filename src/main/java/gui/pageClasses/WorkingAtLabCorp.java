package gui.pageClasses;

import gui.basePage.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

public class WorkingAtLabCorp extends BaseClass {
    private static String jobPostingValue = null;

    @FindBy(css = ".search-keyword")
    private WebElement keywordSearch;

    @FindBy(css = ".search-location")
    private WebElement cityStateZip;

    @FindBy(css = ".search-form__submit")
    private WebElement submit;

    @FindBy(xpath = "//section[@id='search-results-list']/ul/li")
    private List<WebElement> jobPostsHeaders;

    public WorkingAtLabCorp() {
        switchToBrowser("Working at Labcorp | Jobs and Careers at Labcorp");
        implicitWait(30);
        PageFactory.initElements(getDriver(), this);
    }

    public static String getJobPostingValue() {
        return jobPostingValue;
    }

    public static void setJobPostingValue(String jobPostingValue) {
        WorkingAtLabCorp.jobPostingValue = jobPostingValue;
    }

    public void enterKeyWordSearch(String keyWordToSearchValue) {
        setJobPostingValue(keyWordToSearchValue);
        type(keywordSearch, keyWordToSearchValue);
    }


    public void clickOnSubmitButton() {
        clickUsingJavaScriptExecutor(submit);
    }

    public void clickOnJobPost() {
        List<String> postingValues = Arrays.asList(getJobPostingValue().split("\\s"));
        boolean jobTitleExists = false;
        // As of now dynamically clicking any posting based on keywords passed in the BDD
        for (WebElement jobPostHeader : jobPostsHeaders) {
            String jobPostValue = getElementValue(jobPostHeader.findElement(By.xpath("//a/h2")));
            List<String> applicationPostingValues = Arrays.asList(jobPostValue.split("\\s"));
            for (String keyword : postingValues) {
                if (applicationPostingValues.contains(keyword)) {
                    setJobPostingValue(jobPostValue);
                    clickOnWebElement(jobPostHeader);
                    jobTitleExists = true;
                    break;
                }
            }
            if(jobTitleExists){
                break;
            }
        }
    }

    public void enterCityStateOrZip(String cityStateZipValue) {
        clear(cityStateZip);
        type(cityStateZip, cityStateZipValue);
    }

}
