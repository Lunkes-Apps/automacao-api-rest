package base;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.enableLoggingOfRequestAndResponseIfValidationFails;
import static utils.Utils.getProperty;

public class BaseTest {

    @BeforeMethod
    @Parameters({"env"})
    public void setup(@Optional("dev") String environment){
        baseURI = getProperty("api.uri." + environment);
        enableLoggingOfRequestAndResponseIfValidationFails();
    }

}
