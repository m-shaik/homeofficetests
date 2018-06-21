package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static common.Driver.driver;

public class VehicleEnquiryPage {

    @FindBy(how = How.CSS, using = ".button")
    private WebElement ContinueButton;

    @FindBy(how = How.CSS, using = "#Vrm")
    private WebElement RegistrationNumberTextBox;

    public VehicleEnquiryPage(){
        PageFactory.initElements(driver, this);
    }

    public void navigate(){
        driver.get("https://vehicleenquiry.service.gov.uk/");
    }

    public String getTitle(){
        WebElement myDynamicElement =
                (new WebDriverWait(driver, 15)).until(ExpectedConditions.visibilityOf(RegistrationNumberTextBox));
        String title =  driver.getTitle();
        System.out.println(title);
        return title;
    }

    public void enterRegistrationNumber(String registrationNumber){
        WebElement myDynamicElement =
                (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(RegistrationNumberTextBox));

        RegistrationNumberTextBox.sendKeys(registrationNumber);
    }

    public void clickContinue(){

        ContinueButton.click();

    }
}
