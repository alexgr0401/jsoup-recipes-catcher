package aca;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MyThread extends Thread {

	String url;

	public MyThread(String url) {
		this.url = url;
	}

	@Override
	public void run() {
		Document doc = null;
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (doc == null) {
			System.out.println("Program exiting...");
			return;
		}

		System.out.println("RecipeUrl: " + url + "\n");

		Elements elTitle = doc.getElementsByClass("title-main title-big");
		String title = elTitle.text();
		System.out.println("Title: " + title);

		Elements texts = doc.getElementsByClass("prep-item clearfix");

		for (Element elText : texts) {
			String text = elText.text();
			System.out.println(text);
		}
		System.out.print("\n\n");
	}
}
