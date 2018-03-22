package org.itstep.service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import org.itstep.model.Keyword;

public class StartupStep {

	private final List<Keyword> keywords;

	public StartupStep(List<Keyword> keywords) {
		this.keywords = keywords;
	}

	public void runParsing() {
		for (Keyword keyword : keywords) {

			String url = "https://www.zootovary.com/advanced_search_result.php?inc_subcat=1&keywords=";
			String encodedKey = null;
			try {
				encodedKey = URLEncoder.encode(keyword.getKey(), "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}

			if (encodedKey != null) {
				url += encodedKey;

				NavigationStep nextStep = new NavigationStep(keyword, url);
				
				nextStep.start();
			}
		}
	}
}