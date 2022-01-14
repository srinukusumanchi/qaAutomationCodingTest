package gui.steps;

import gui.basePage.BaseClass;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import gui.pageClasses.CareerSiteSelfService;
import gui.pageClasses.Labcorp;
import gui.pageClasses.SearchOurJobOpportunitiesatLabcorp;
import gui.pageClasses.WorkingAtLabCorp;

public class StepDefinition extends BaseClass {

    @Given("^open the browser$")
    public void openTheBrowser() {
        openBrowser();
    }

    @Given("^navigate to the url \"([^\"]*)\"$")
    public void navigate_to_the_url(String url) throws Throwable {
        navigateToURL(url);
    }

    @When("^click on careers link$")
    public void click_on_careers_link() throws Throwable {
        Labcorp labcorp = new Labcorp();
        labcorp.clickOnCareers();
    }

    @When("^search for a position \"([^\"]*)\"$")
    public void search_for_a_position(String postingValue) throws Throwable {
        WorkingAtLabCorp workingAtLabCorp = new WorkingAtLabCorp();
        workingAtLabCorp.enterKeyWordSearch(postingValue);
    }

    @When("^click on submit button$")
    public void click_on_submit_button() throws Throwable {
        WorkingAtLabCorp workingAtLabCorp = new WorkingAtLabCorp();
        workingAtLabCorp.clickOnSubmitButton();
    }

    @When("^browse to the position$")
    public void browse_to_the_position() throws Throwable {
        WorkingAtLabCorp workingAtLabCorp = new WorkingAtLabCorp();
        workingAtLabCorp.clickOnJobPost();
    }

    @And("^enter \"([^\"]*)\" into city,state or zip$")
    public void enterIntoCityStateOrZip(String cityStateZipValue) throws Throwable {
        WorkingAtLabCorp workingAtLabCorp = new WorkingAtLabCorp();
        workingAtLabCorp.enterCityStateOrZip(cityStateZipValue);
    }

    @Then("^verify job title$")
    public void verify_job_title() throws Throwable {
        CareerSiteSelfService careerSiteSelfService = new CareerSiteSelfService();
        String jobTitleActual = careerSiteSelfService.getJobTitle();
        Assert.assertEquals(jobTitleActual, SearchOurJobOpportunitiesatLabcorp.getJobPostingValue());
    }

    @And("^verify job location label$")
    public void verifyJobLocationLabel() {
        SearchOurJobOpportunitiesatLabcorp searchOurJobOpportunitiesatLabcorp = new SearchOurJobOpportunitiesatLabcorp();
        searchOurJobOpportunitiesatLabcorp.verifyJobLocationField();
    }

    @And("^verify job id label$")
    public void verifyJobIdLabel() {
        SearchOurJobOpportunitiesatLabcorp searchOurJobOpportunitiesatLabcorp = new SearchOurJobOpportunitiesatLabcorp();
        searchOurJobOpportunitiesatLabcorp.verifyJobIdField();
        // verify Job Id having only Integers with - hipen after 2 digits
        boolean jobIdPattern = regularExpressionPatternVerification("[0-9]{2}-[0-9]{5}", searchOurJobOpportunitiesatLabcorp.getJobId().split("\\s")[2]);
        Assert.assertTrue("Job Id pattern is digits with \"-\"", jobIdPattern);
    }


    @And("^capture job details$")
    public void captureJobDetails() {
        SearchOurJobOpportunitiesatLabcorp searchOurJobOpportunitiesatLabcorp = new SearchOurJobOpportunitiesatLabcorp();
        searchOurJobOpportunitiesatLabcorp.getJobDescription();
        SearchOurJobOpportunitiesatLabcorp.getJobPostingValue();

        SearchOurJobOpportunitiesatLabcorp.getJobIdValue();

        searchOurJobOpportunitiesatLabcorp.getJobLocation();
        SearchOurJobOpportunitiesatLabcorp.getJobLocationValue();
    }

    @Then("^click on apply now$")
    public void clickOnApplyNow() {
        SearchOurJobOpportunitiesatLabcorp searchOurJobOpportunitiesatLabcorp = new SearchOurJobOpportunitiesatLabcorp();
        searchOurJobOpportunitiesatLabcorp.clickOnApplyNowButton();
    }

    @Then("^verify job location$")
    public void verifyJobLocation() {
        CareerSiteSelfService careerSiteSelfService = new CareerSiteSelfService();
        String jobLocationActual = careerSiteSelfService.getJobLocation();
        Assert.assertThat(SearchOurJobOpportunitiesatLabcorp.getJobLocationValue().split("\\n")[1],CoreMatchers.containsString(jobLocationActual.split(",")[0]));

    }

    @Then("^verify posting id$")
    public void verifyPostingId() {
        CareerSiteSelfService careerSiteSelfService = new CareerSiteSelfService();
        String postingIdActual = careerSiteSelfService.getPostingId().replace("#","");
        Assert.assertEquals(postingIdActual, SearchOurJobOpportunitiesatLabcorp.getJobIdValue().split("\\s")[2]);
    }

    @Then("^click on return to job search$")
    public void clickOnReturnToJobSearch() {
        CareerSiteSelfService careerSiteSelfService = new CareerSiteSelfService();
        careerSiteSelfService.clickOnReturnToJobSearch();
    }
}
