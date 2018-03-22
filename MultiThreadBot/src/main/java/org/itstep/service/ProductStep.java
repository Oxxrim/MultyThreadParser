package org.itstep.service;

import java.io.IOException;

import org.itstep.dao.ItemDAO;
import org.itstep.model.Item;
import org.itstep.model.Keyword;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class ProductStep extends Thread{

	private final Keyword key;
	
	private final String url;
	
	private final String parentUrl;
	
	public ProductStep(Keyword key, String parentUrl, String url) {
		this.key = key;
		this.url = url;
		this.parentUrl = parentUrl;
	}
	
	@Override
	public void run() {
		
		System.out.println("Start product parsing with url " + url);
		Document content = null;
		
		Item item = new Item();
		item.setItemUrl(url);
		item.setParentUrl(parentUrl);
		item.setKeyword(key);
		
				
		try {
			content = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// extract name
		Element skuElement = content.getElementsByAttributeValue("itemprop", "sku").first();
		if(skuElement.attr("content") != null) {
			item.setName(skuElement.text());
		}
		
		ItemDAO itemDAO = new ItemDAO();
		itemDAO.save(item);
		
		System.out.println("Finish product parsing from url " + url);
		
	}
	
}