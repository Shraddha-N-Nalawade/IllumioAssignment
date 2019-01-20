package com.illumio.assignment;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * 
 * @author shraddha
 *
 */

public class UrlSearch {

	private static Map<String, Boolean> map = new HashMap<String, Boolean>();
	private int counter = 0;

	public boolean isValid(String url) throws Exception {
		if (url == null)
			return false;
		String regex = "(^(?:http|ftp)s?:\\/\\/)?(?:(?:[a-z0-9](?:[a-z0-9-]{0,61}[a-z0-9])?\\.)+(?:[a-z]{2,6}\\.?|[a-z0-9-]{2,}\\.?)|localhost|(\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}))(?::\\d+)?(?:/?|[/?]\\S+)$";
		url = url.toLowerCase();
		boolean matches = Pattern.matches(regex, url); //Match Url with Regex
		if (matches) {
			counter = 0; //if Url is valid set counter to zero
			return matches;
		}

		if (++counter == 3) //if 3 consecutive Urls are invalid then throw an exception to close session
			throw new Exception("You have reached maximum attempt.Session is terminated");

		return matches;
	}
}
