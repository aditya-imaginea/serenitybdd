package com.insideview.training.webservices.jbehave.stepdefinitions;

import com.insideview.training.webservices.jbehave.steps.UrlShortenerSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.json.JSONException;

public class ProcessingUrls {
    String providedUrl;
    String returnedMessage;

    @Steps
    UrlShortenerSteps urlShortener;


    @Given("a url <providedURL>")
    public void givenAUrlprovidedURL(String providedURL) {
        this.providedUrl = providedURL;
    }

    @When("I request the expanded form of this url")
    public void whenIRequestTheExpandedFormOfThisUrl() {
        System.out.println(providedUrl);
        returnedMessage = urlShortener.expand(providedUrl);
    }

    @Then("the long form should be <expectedURL>")
    public void thenTheLongFormShouldBeexpectedURL(String expectedURL) throws JSONException {
        urlShortener.response_should_contain_long_url(returnedMessage, expectedURL);
    }

}
