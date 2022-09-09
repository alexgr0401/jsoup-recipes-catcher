package aca;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		List<String> urls = new ArrayList<String>();

		String url = "http://www.recepti.com/";
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

		Elements elements = doc.getElementsByClass("recipe-l-item");

		Element el = elements.get(5);
		Element h4 = el.getElementsByTag("h4").first();
		Element a = h4.getAllElements().get(1);
		String href = a.attr("href");
		String recipeUrl1 = url + href;

		Element el2 = elements.get(6);
		Element h42 = el2.getElementsByTag("h4").first();
		Element a2 = h42.getAllElements().get(1);
		String href2 = a2.attr("href");
		String recipeUrl2 = url + href2;

		Element el3 = elements.get(7);
		Element h43 = el3.getElementsByTag("h4").first();
		Element a3 = h43.getAllElements().get(1);
		String href3 = a3.attr("href");
		String recipeUrl3 = url + href3;

		Element el4 = elements.get(8);
		Element h44 = el4.getElementsByTag("h4").first();
		Element a4 = h44.getAllElements().get(1);
		String href4 = a4.attr("href");
		String recipeUrl4 = url + href4;

		Element el5 = elements.get(9);
		Element h45 = el5.getElementsByTag("h4").first();
		Element a5 = h45.getAllElements().get(1);
		String href5 = a5.attr("href");
		String recipeUrl5 = url + href5;

		urls.add(recipeUrl1);
		urls.add(recipeUrl2);
		urls.add(recipeUrl3);
		urls.add(recipeUrl4);
		urls.add(recipeUrl5);

		List<MyThread> threadList = new ArrayList<MyThread>();

		for (String rUrl : urls) {
			threadList.add(new MyThread(rUrl));
		}

		for (MyThread myThread : threadList) {
			myThread.start();
			Thread.sleep(800);
		}

		for (MyThread myThread : threadList) {
			myThread.join();

		}		
	}
}
