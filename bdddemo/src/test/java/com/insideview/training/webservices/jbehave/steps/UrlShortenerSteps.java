package com.insideview.training.webservices.jbehave.steps;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.springframework.web.client.RestTemplate;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class UrlShortenerSteps extends ScenarioSteps {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5456019235449118705L;
	RestTemplate restTemplate;

	public UrlShortenerSteps() {
		restTemplate = new RestTemplate();
	}

	@Step("longUrl={0}")
	public String shorten(String providedUrl) {
		Map<String, String> urlForm = new HashMap<String, String>();
		urlForm.put("longUrl", providedUrl);
		return restTemplate.postForObject("https://www.googleapis.com/urlshortener/v1/url", urlForm, String.class);
	}

	@Step("shortUrl={0}")
	public String expand(String providedUrl) {

		return restTemplate.getForObject("https://www.googleapis.com/urlshortener/v1/url?shortUrl={shortUrl}",
				String.class, providedUrl);
	}

	@Step
	public void response_should_contain_shortened_url(String returnedMessage, String expectedUrl) throws JSONException {
		String expectedJSONMessage = "{'id':'" + expectedUrl + "'}";
		JSONAssert.assertEquals(expectedJSONMessage, returnedMessage, JSONCompareMode.LENIENT);
	}

	@Step
	public void response_should_contain_long_url(String returnedMessage, String expectedUrl) throws JSONException {
		String expectedJSONMessage = "{'longUrl':'" + expectedUrl + "'}";
		JSONAssert.assertEquals(expectedJSONMessage, returnedMessage, JSONCompareMode.LENIENT);
	}
}
