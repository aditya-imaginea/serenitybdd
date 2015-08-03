package com.insideview.training.webservices.jbehave.stepdefinitions;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.json.JSONException;

import com.insideview.training.webservices.jbehave.steps.UrlShortenerSteps;

import net.thucydides.core.annotations.Steps;

public class ProcessingUrls {
	String providedUrl;
	String returnedMessage;

	@Steps
	UrlShortenerSteps urlShortener;

	@Given("a url <providedUrl>")
	public void givenAUrl(String providedUrl) {
		this.providedUrl = providedUrl;
	}

	@When("I request the shortened form of this url")
	public void shortenUrl() {
		returnedMessage = urlShortener.shorten(providedUrl);
	}

	@When("I request the expanded form of this url")
	public void expandUrl() {
		returnedMessage = urlShortener.expand(providedUrl);
	}

	@Then("the shortened form should be <expectedUrl>")
	public void shortenedFormShouldBe(String expectedUrl) throws JSONException {
		urlShortener.response_should_contain_shortened_url(returnedMessage, expectedUrl);
	}
}
