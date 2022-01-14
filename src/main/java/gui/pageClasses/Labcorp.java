package gui.pageClasses;

import gui.basePage.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Labcorp extends BaseClass {

    public Labcorp(){
        implicitWait(30);
        PageFactory.initElements(getDriver(),this);
    }
    @FindBy(xpath = "//li[@class='menu-item menu-item--level-1']/a[text()='Careers']")
    private WebElement careers;


    public void clickOnCareers() {
        clickUsingJavaScriptExecutor(careers);
    }



}
