package pageObjects;

import com.java.dataservice.ReadData;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;

import static common.Driver.driver;

public class ViewVehiclePage {

    private List<HashMap<String,String>> vehicleDetailsList;
    private HashMap<String,String> vehicleDetails;

    @FindBy(how = How.CSS, using = ".list-summary li:nth-child(1)>span>strong")
    private WebElement Make;

    @FindBy(how = How.CSS, using = ".list-summary li:nth-child(9)>span>strong")
    private WebElement Colour;

    @FindBy(how = How.CSS, using = ".reg-mark")
    private WebElement RegistrationNumber;

    public ViewVehiclePage(){
        PageFactory.initElements(driver, this);
    }

    private void getData()
    {
        if (vehicleDetailsList == null) {
            vehicleDetailsList = ReadData.getDataFromExcel("src/test/testdata/VehicleInformation.xlsx","VehicleDetails");
        }


    }

    private HashMap<String,String> getRow(List<HashMap<String,String>> vehicleDetailsList, String registrationNumber){

        for (HashMap<String, String> vehicleDetails : vehicleDetailsList
                ) {

            String regNum = vehicleDetails.get("RegistrationNumber").toLowerCase().trim();

            if (regNum.equals(registrationNumber.toLowerCase().trim())){
                return vehicleDetails;
            }
        }

        return null;

    }

    public String getTitle(){
        WebElement myDynamicElement =
                (new WebDriverWait(driver, 15)).until(ExpectedConditions.visibilityOf(RegistrationNumber));
        String title =  driver.getTitle();
        System.out.println(title);
        return title;
    }


    public boolean assertVehicleDetails(String registrationNumber){
        getData();
        vehicleDetails = getRow(vehicleDetailsList, registrationNumber);

        if (vehicleDetails == null){
            Assert.fail("No Data in Excel for Reg Number");
        }else {
            Assert.assertEquals(vehicleDetails.get("RegistrationNumber").toLowerCase().trim(), RegistrationNumber.getText().toLowerCase().trim());
            Assert.assertEquals(vehicleDetails.get("Make").toLowerCase().trim(), Make.getText().toLowerCase().trim());
            Assert.assertEquals(vehicleDetails.get("Colour").toLowerCase().trim(), Colour.getText().toLowerCase().trim());
        }

        return true;
    }


}
