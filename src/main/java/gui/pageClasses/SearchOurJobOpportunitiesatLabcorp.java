package gui.pageClasses;

import gui.basePage.BaseClass;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchOurJobOpportunitiesatLabcorp extends BaseClass {
    private static String jobLocationValue = null;
    private static String jobPostingValue = null;

    private static String jobIdValue = null;
    @FindBy(css = ".job-description__heading")
    private WebElement jobDescription;

    @FindBy(css = ".job-location.job-info")
    private WebElement jobLocation;

    @FindBy(css = ".job-id.job-info")
    private WebElement jobId;

    @FindBy(css = ".button.job-apply.top")
    private WebElement applyNow;

    public static String getJobLocationValue() {
        return jobLocationValue;
    }

    public static void setJobLocationValue(String jobLocation) {
        SearchOurJobOpportunitiesatLabcorp.jobLocationValue = jobLocation;
    }

    public static String getJobPostingValue() {
        return jobPostingValue;
    }

    public static void setJobPostingValue(String jobPostingValue) {
        SearchOurJobOpportunitiesatLabcorp.jobPostingValue = jobPostingValue;
    }

    public static String getJobIdValue() {
        return jobIdValue;
    }

    public static void setJobIdValue(String jobIdValue) {
        SearchOurJobOpportunitiesatLabcorp.jobIdValue = jobIdValue;
    }

    public SearchOurJobOpportunitiesatLabcorp() {
        switchToBrowser(WorkingAtLabCorp.getJobPostingValue());
        implicitWait(30);
        PageFactory.initElements(getDriver(), this);
    }

    public String getJobDescription() {
        setJobPostingValue(getElementValue(jobDescription));
        return getElementValue(jobDescription);
    }

    public String getJobLocation() {
        setJobLocationValue(getElementValue(jobLocation));
        return getElementValue(jobLocation);
    }

    public String getJobId() {
        setJobIdValue(getElementValue(jobId));
        return getElementValue(jobId);
    }

    public void verifyJobLocationField() {
        Assert.assertEquals(getElementValue(jobLocation).split("\\n")[0], "Location");
    }

    public void verifyJobIdField() {
        Assert.assertEquals(getElementValue(jobId).split("\\s")[0] + " "
                + getElementValue(jobId).split("\\s")[1], "Job ID");
    }

    public void clickOnApplyNowButton() {
        clickOnWebElement(applyNow);
    }

}
