package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import static common.Driver.driver;

public class GetVehicleInformationPage {


    @FindBy(how = How.CSS, using = "#get-started > a")
    private WebElement StartNowButton;

    public GetVehicleInformationPage(){
        PageFactory.initElements(driver, this);
    }

    public void navigate(){
        driver.get("https://www.gov.uk/get-vehicle-information-from-dvla");
    }

    public void clickStartNow(){

        StartNowButton.click();

    }
}
