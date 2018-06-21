package stepDefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pageObjects.ConfirmVehiclePage;
import pageObjects.GetVehicleInformationPage;
import pageObjects.VehicleEnquiryPage;
import pageObjects.ViewVehiclePage;

public class GetVehicleInformationSteps {

    GetVehicleInformationPage getVehicleInformationPage = new GetVehicleInformationPage();
    VehicleEnquiryPage vehicleEnquiryPage = new VehicleEnquiryPage();
    ConfirmVehiclePage confirmVehiclePage = new ConfirmVehiclePage();
    ViewVehiclePage viewVehiclePage = new ViewVehiclePage();
    
    @When("^I click on Start Now button$")
    public void iClickOnStartNowButton() throws Throwable {

       getVehicleInformationPage.clickStartNow();
    }

    @Given("^I navigate to DVLA get vehicle information page$")
    public void iNavigateToDVLAGetVehicleInformationPage() throws Throwable {

       getVehicleInformationPage.navigate();
    }

    @Then("^I am redirected to vehicle enquiry service page$")
    public void iAmRedirectedToVehicleEnquiryServicePage() throws Throwable {

        Assert.assertEquals("Check if a vehicle is taxed and has an MOT", vehicleEnquiryPage.getTitle());
    }

    @Given("^I navigate to vehicle enquiry service page$")
    public void iNavigateToVehicleEnquiryServicePage() throws Throwable {

        vehicleEnquiryPage.navigate();
    }

    @And("^I enter registration number (.*)$")
    public void iEnterRegistrationNumberRegistrationNumber(String regNumber) throws Throwable {

      vehicleEnquiryPage.enterRegistrationNumber(regNumber);
    }

    @When("^I click on continue button$")
    public void iClickOnContinueButton() throws Throwable {

      vehicleEnquiryPage.clickContinue();
    }

    @And("^I confirm vehicle details RegNum (.*) Make (.*) Colour (.*)$")
    public void iConfirmVehicleDetailsRegNumRegistrationNumberMakeMakeColourColour(String regNumber, String make, String color) throws Throwable {

        boolean detailsMatch = confirmVehiclePage.assertVehicleDetails(regNumber, make, color);

        if (detailsMatch){
            confirmVehiclePage.setSelectYes();
            confirmVehiclePage.continueButton();
        }
    }

    @Then("^vehicle details are displayed (.*)$")
    public void vehicleDetailsAreDisplayedRegistrationNumber(String regNumber) throws Throwable {
        Assert.assertEquals("Check if a vehicle is taxed and has an MOT", viewVehiclePage.getTitle());
        viewVehiclePage.assertVehicleDetails(regNumber);
    }

    @And("^I select vehicle details does not match$")
    public void iSelectVehicleDetailsDoesNotMatch() throws Throwable {

        confirmVehiclePage.setSelectNo();
    }

    @When("^I click on continue$")
    public void iClickOnContinue() throws Throwable {

        confirmVehiclePage.continueButton();
    }
}
