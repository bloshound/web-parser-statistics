package com.bloshound.webparserstatistics;

import org.jsoup.nodes.Document;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;

@SpringBootApplication
public class WebParserStatisticsApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(WebParserStatisticsApplication.class, args);

        HTMLDownloader htmlDownloader = new HTMLDownloader(new URL("https://habr.com/"));
        String downloadedHtml = htmlDownloader.downloadHtml();

        Document doc = HTMLParser.parse(downloadedHtml);
        String text = HTMLParser.text(doc);

        Util util = new Util();
        Map<String, Long> entrances = util.entrancesCounting(text);

        LinkedHashMap<String, Long> sortedEntrances = util.sortedLinkedEntrancesCounting(entrances);
        System.out.println(sortedEntrances);

    }
}
