package by;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class App {

    public static void main(String[] args) {
        String url = "https://cars.av.by/";
        Document document;
        try {
            document = Jsoup.connect(url).get();
            Elements elements = document.select("div h4 a");
            String cars = elements.text();

            System.out.println(cars);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
