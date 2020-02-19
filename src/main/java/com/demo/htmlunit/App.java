package com.demo.htmlunit;

import java.util.List;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlHeading1;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class App {

	public static void main(String[] args) {

		WebClient client = new WebClient();
		client.getOptions().setCssEnabled(false);
		client.getOptions().setJavaScriptEnabled(false);
		try {

			HtmlPage page = client
					.getPage(" https://www.mirror.co.uk/news/politics/lisa-nandy-councils-must-power-21262464");

			HtmlHeading1 item = ((HtmlHeading1) page.getFirstByXPath("//article//h1"));
			System.out.println(item.asText());

			List<HtmlElement> items = (List<HtmlElement>) page.getByXPath("//article//p");
			for (HtmlElement ele : items) {
				System.out.println(ele.asText());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
