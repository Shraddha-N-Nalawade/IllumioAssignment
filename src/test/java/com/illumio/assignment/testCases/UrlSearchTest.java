package com.illumio.assignment.testCases;

import static org.junit.Assert.*;
import org.junit.Test;
import com.illumio.assignment.UrlSearch;
import junit.framework.Assert;

/**
 * @author shraddha
 */

public class UrlSearchTest {
	UrlSearch urlSearch = new UrlSearch();
	private boolean isUrlValid;

	@Test
	public void verifyWithCorrectUrlUsingHttp() throws Exception {
		isUrlValid = urlSearch.isValid("http://Google.com");
		assertTrue(isUrlValid);

	}

	@Test
	public void verifyWithCorrectUrlUsingHttps() throws Exception {
		isUrlValid = urlSearch.isValid("http://Gmail.com");
		assertTrue(isUrlValid);

	}

	@Test
	public void verifyWithCorrectUrlUsingFtp() throws Exception {
		isUrlValid = urlSearch.isValid("ftp://shraddhaillumio.com");
		assertTrue(isUrlValid);

	}

	@Test
	public void verifyWithCorrectUrlUsingFtps() throws Exception {
		isUrlValid = urlSearch.isValid("ftps://shraddhaillumio.com");
		assertTrue(isUrlValid);

	}

	@Test
	public void verifyWithCorrectUrlUsingLocalHost() throws Exception {
		isUrlValid = urlSearch.isValid("http://localhost:8080/admin");
		assertTrue(isUrlValid);

	}

	@Test
	public void verifyWithCorrectUrlUsingIPAddress() throws Exception {
		isUrlValid = urlSearch.isValid("172.213.75.09");
		assertTrue(isUrlValid);

	}

	@Test
	public void verifyWithInvalidProtocol() throws Exception {
		isUrlValid = urlSearch.isValid("rmtp://Walmart.com");
		assertFalse(isUrlValid);

	}

	@Test
	public void verifyByExcludingProtocol() throws Exception {
		isUrlValid = urlSearch.isValid("facebook.com");
		assertTrue(isUrlValid);

	}

	@Test
	public void verifyWithoutColon() throws Exception {
		isUrlValid = urlSearch.isValid("http//amazon.com");
		assertFalse(isUrlValid);

	}

	@Test
	public void verifyWithoutForwordSlash() throws Exception {
		isUrlValid = urlSearch.isValid("http:google.com");
		assertFalse(isUrlValid);

	}

	@Test
	public void verifyWithoutPeriod() throws Exception {
		isUrlValid = urlSearch.isValid("http://amazon com");
		assertFalse(isUrlValid);

	}

	@Test
	public void verifyUrlWithAllCaptialLetters() throws Exception {
		isUrlValid = urlSearch.isValid("HTTP://AMAZON.COM");
		assertTrue(isUrlValid);

	}

	@Test
	public void verifyByUsingSmallLettersInDomainNames() throws Exception {
		isUrlValid = urlSearch.isValid("http://amazon.com");
		assertTrue(isUrlValid);

	}

	@Test
	public void verifyByUsingCaptialLettersInDomainName() throws Exception {
		isUrlValid = urlSearch.isValid("http://AMAZON.COM");
		assertTrue(isUrlValid);

	}

	@Test
	public void verifyByUsingDigitsInDomainName() throws Exception {
		isUrlValid = urlSearch.isValid("http://123.com");
		assertTrue(isUrlValid);

	}

	@Test
	public void verifyByUsingSpecialCharactersInDomainName() throws Exception {
		isUrlValid = urlSearch.isValid("http://www.%mer*zon.com");
		assertFalse(isUrlValid);

	}

	@Test
	public void verifyByUsingDifferentCombinationsInDomainName() throws Exception {
		isUrlValid = urlSearch.isValid("http://www.St2-hj_3+u.com");
		assertFalse(isUrlValid);

	}

	@Test
	public void verifyByUsingCountrySpecificDomainName() throws Exception {
		isUrlValid = urlSearch.isValid("http://Reliance.in");
		assertTrue(isUrlValid);

	}

	@Test
	public void verifyWithOutPort() throws Exception {
		isUrlValid = urlSearch.isValid("http://localhost:/User");
		assertFalse(isUrlValid);

	}

	@Test
	public void verifyWithOnlyPartialDomainName() throws Exception {
		isUrlValid = urlSearch.isValid("Ebay");
		assertFalse(isUrlValid);

	}

	@Test
	public void verifyWithUrlParameters() throws Exception {
		isUrlValid = urlSearch.isValid("http://www.EZ.com?pageid=56&testid=56");
		assertTrue(isUrlValid);

	}

	@Test
	public void verifyWithLongUrl() throws Exception {
		isUrlValid = urlSearch.isValid("http://www.Reliance.com/test1/test2/test3/test4/test5/assignment.html");
		assertTrue(isUrlValid);

	}

	@Test
	public void verifyByUsingWhiteSpaces() throws Exception {
		isUrlValid = urlSearch.isValid("http : // www. google . com ");
		assertFalse(isUrlValid);

	}

	@Test
	public void verifyByUsingWhiteSpacesOnlyInDomainName() throws Exception {
		isUrlValid = urlSearch.isValid("http://www. google .com ");
		assertFalse(isUrlValid);

	}

	@Test
	public void verifyWithBlankUrl() throws Exception {
		isUrlValid = urlSearch.isValid(" ");
		assertFalse(isUrlValid);

	}

	@Test(expected = Exception.class)
	public void verifyByPassingInvalidInputs() throws Exception {
		urlSearch.isValid(" ");
		urlSearch.isValid("shr ");
		urlSearch.isValid("ebay ");

	}

	@Test
	public void verifyByPassingCombinationOfValidInvalidInputs() throws Exception {
		isUrlValid = urlSearch.isValid(" ");
		isUrlValid = urlSearch.isValid("http://google.com");
		isUrlValid = urlSearch.isValid("ebay ");
		assertFalse(isUrlValid);

	}

	@Test
	public void verifyByPassingCombinationOfValidInputs() throws Exception {
		isUrlValid = urlSearch.isValid("http://Amazon.com");
		isUrlValid = urlSearch.isValid("172.25.102.45");
		isUrlValid = urlSearch.isValid("ftp://shraddhaillumio.com");
		assertTrue(isUrlValid);

	}

}
