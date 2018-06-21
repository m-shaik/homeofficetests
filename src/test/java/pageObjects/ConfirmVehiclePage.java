package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static common.Driver.driver;

public class ConfirmVehiclePage {

    @FindBy(how = How.CSS, using = "label[for='Correct_True']")
    private WebElement SelectYes;

    @FindBy(how = How.CSS, using = "label[for='Correct_False']")
    private WebElement SelectNo;

    @FindBy(how = How.CSS, using = ".button")
    private WebElement Continue;

    @FindBy(how = How.CSS, using = ".reg-mark")
    private WebElement RegistrationNumber;

    @FindBy(how = How.CSS, using = ".list-summary li:nth-child(2)>span>strong")
    private WebElement Make;

    @FindBy(how = How.CSS, using = ".list-summary li:nth-child(3)>span>strong")
    private WebElement Colour;

    public ConfirmVehiclePage(){
        PageFactory.initElements(driver,this);
    }

    public void setSelectNo(){
        WebElement myDynamicElement =
                (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(SelectNo));
        SelectNo.click();
    }

    public void setSelectYes(){
        WebElement myDynamicElement =
                (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(SelectYes));
        SelectYes.click();
    }

    public void continueButton(){

        Continue.click();

    }

    public boolean assertVehicleDetails(String registrationNumber, String make, String colour){
        WebElement myDynamicElement =
                (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(RegistrationNumber));
        Assert.assertEquals(registrationNumber.toLowerCase().trim(), RegistrationNumber.getText().toLowerCase().trim());
        Assert.assertEquals(make.toLowerCase().trim(), Make.getText().toLowerCase().trim());
        Assert.assertEquals(colour.toLowerCase().trim(), Colour.getText().toLowerCase().trim());
        return true;
    }

}
