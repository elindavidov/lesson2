package glue.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import pages.*;

import java.util.ArrayList;

public class MyStepdefs extends Browser {


    private static String url;
    private static String endpoint;
    private static Response response;

    @Given("^browser \"([^\"]*)\" with remote address: \"([^\"]*)\"$")
    public void browserWithRemoteAddress(String browserName, String address) throws Throwable {
        openRemoteWebDriver(browserName, address);
    }

    @Given("^browser \"([^\"]*)\"$")
    public void browser(String browserName) throws Throwable {
        openLocalWebDriver(browserName);
    }

    @And("^website loaded this address: \"([^\"]*)\"$")
    public void websiteLoadedThisAddress(String url) throws Throwable {
        driver.get(url);
    }

    @When("^I execute a search for \"([^\"]*)\"$")
    public void iExecuteASearchFor(String textForSearching) throws Throwable {
        Search searchInStore = new Search();
        searchInStore.searchInStore(textForSearching);
    }

    //    @After
    public void tearDown() {
        driver.close();
    }

    @Then("^I should expect there is a result$")
    public void iShouldExpectThereIsAResult() throws Throwable {
        SearchResults searchResults = new SearchResults();
        searchResults.verifyResults();
    }

    @Then("^I should verify all buttons$")
    public void iShouldVerifyAllButtons() throws Throwable {
        HomePage homePage = new HomePage();
        homePage.verifyAllButons();
    }


    @Given("^base url: \"([^\"]*)\"$")
    public void baseUrl(String baseUrl) throws Throwable {
        this.url = baseUrl;
    }

    @And("^endpoint: \"([^\"]*)\"$")
    public void endpoint(String endpoint) throws Throwable {
        this.endpoint = endpoint;
    }

    @When("^I made a call$")
    public void iMadeACall() throws Throwable {
//        https://airtube.info/api/get_data_current.php?location_id=3129
        RestAssured.given().get("https://airtube.info/api/get_data_current.php?location_id=3129");
        response.prettyPrint();
        response = RestAssured.given().get("");
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Then("^I should receive data$")
    public void iShouldReceiveData() throws Throwable {
        ArrayList<ArrayList> spisuk = response.jsonPath().get("sensordatavalues");
        response.prettyPrint();
        /*int i = 0;
        for (ArrayList a : spisuk) {
            Map map = (Map) a.get(i);
            String value = map.get("value").toString();
            String valueType = map.get("value_type").toString();
            System.out.println("Stoinostta na prahovite cahstici "+valueType+": " + value);
            i++;
        }*/
    }

    @Then("^I should receive data for my repos$")
    public void iShouldReceiveDataForMyRepos() throws Throwable {
        response.prettyPrint();
    }

    @Given("^url: \"([^\"]*)\"$")
    public void url(String baseUrl) throws Throwable {
        this.url = baseUrl;
    }

    @When("^I submit get request$")
    public void iSubmitGetRequest() throws Throwable {
        this.response = RestAssured.given().get(this.url + this.endpoint);

    }

    @Then("^I should receive get status (\\d+)$")
    public void iShouldReceiveGetStatus(int statusCode) throws Throwable {
        Assert.assertEquals(response.getStatusCode(), statusCode);
        response.prettyPrint();
////        response.getBody().jsonPath().get("page");
//       ArrayList data = response.getBody().jsonPath().get("data");
//       for (Object map : data) {
//           System.out.println(((Map) map).get("avatar"));
//       }
    }

    @When("^I submit post request$")
    public void iSubmitPostRequest() throws Throwable {
        String body = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";
        response = RestAssured.given().baseUri(this.url + this.endpoint).contentType("aplication/json").when().post(body);
    }


    @And("^I should verify contact title$")
    public void iShouldVerifyContactTitle() throws Throwable {
       Contact contact = new Contact();
        contact.verifyContact();

    }

    @And("^I should verify AboutUs$")
    public void iShouldVerifyAboutUs() throws Throwable {
        AboutUs aboutUs = new AboutUs();
        aboutUs.verifyAboutUs();
    }

    @And("^click on Partners$")
    public void clickOnPartners() throws Throwable {
       Partners partners = new Partners();
       partners.clickOnPartners();
    }

    @And("^Verify Seeburger URL \"([^\"]*)\"$")
    public void verifySeeburgerURL(String url) throws Throwable {
        Partners partners = new Partners();
        partners.findPartnersUrl(url);

    }
}
