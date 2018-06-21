package stepDefs;


import common.Driver;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

    @RunWith(Cucumber.class)
    @CucumberOptions(
            tags = "@vehicleDetails",
            features = "classpath:features",
            format = {"pretty","html:target/Destination"} )
    public class TestRunner {

        @BeforeClass
        public static void setup(){

            Driver.initialiseDriver();

        }

        @AfterClass
        public static void teardown(){

            Driver.driver.quit();
        }
}
