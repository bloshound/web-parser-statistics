package com.bloshound.webparserstatistics.service;

import com.bloshound.webparserstatistics.utils.HTMLDownloader;
import com.bloshound.webparserstatistics.utils.HTMLParser;
import com.bloshound.webparserstatistics.utils.HTMLUtil;
import com.bloshound.webparserstatistics.model.Site;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class MainService {

    private final HTMLUtil util;

    private final HTMLDownloader htmlDownloader;

    private final SiteService siteService;

    public MainService(HTMLUtil util, HTMLDownloader htmlDownloader, SiteService siteService) {
        this.util = util;
        this.htmlDownloader = htmlDownloader;
        this.siteService = siteService;
    }


    /**
     * execute main logic of application
     *
     * @throws MalformedURLException, IOException
     */
    public void execute() throws MalformedURLException, IOException {


        HTMLDownloader htmlDownloader = new HTMLDownloader(new URL("https://yandex.ru/"));
        String downloadedHtml = htmlDownloader.downloadHtml();

        Document doc = HTMLParser.parse(downloadedHtml);
        String text = HTMLParser.text(doc);

        Map<String, Long> entrances = util.entrancesCounting(text);

        LinkedHashMap<String, Long> sortedEntrances = util.sortedLinkedEntrancesCounting(entrances);
        System.out.println(sortedEntrances);

        siteService.addSite(new Site(htmlDownloader.getUrl(), sortedEntrances));
    }

}
