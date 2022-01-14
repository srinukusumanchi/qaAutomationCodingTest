package gui.pageClasses;

import gui.basePage.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CareerSiteSelfService extends BaseClass {


    @FindBy(css = ".jobTitle.job-detail-title")
    private WebElement jobTitle;

    @FindBy(css = ".jobnum")
    private WebElement postingId;

    @FindBy(css = ".fa.fa-map-marker+span[class='resultfootervalue']")
    private WebElement jobLocation;

    @FindBy(css = ".btn.btn-secondary.ae-button")
    private WebElement returnToJobSearch;

    public CareerSiteSelfService() {
        switchToBrowser("Career Site - Self Service");
        implicitWait(30);
        PageFactory.initElements(getDriver(), this);
    }

    public String getJobTitle() {
        return getElementValue(jobTitle);
    }

    public String getPostingId() {
        return getElementValue(postingId);
    }

    public String getJobLocation() {
        return getElementValue(jobLocation);
    }

    public void clickOnReturnToJobSearch() {
        clickOnWebElement(returnToJobSearch);
    }


}
