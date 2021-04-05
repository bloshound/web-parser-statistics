package com.bloshound.webparserstatistics.service;

import com.bloshound.webparserstatistics.model.Site;
import com.bloshound.webparserstatistics.utils.HTMLDownloader;
import com.bloshound.webparserstatistics.utils.HTMLParser;
import com.bloshound.webparserstatistics.utils.HTMLUtil;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

@Service
public class MainService {

    private static final Logger logger = Logger.getLogger(MainService.class.getName());

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
    public void execute(String urlName) throws MalformedURLException, IOException {

        HTMLDownloader htmlDownloader = new HTMLDownloader(new URL(urlName));
        String downloadedHtml = htmlDownloader.downloadHtml();

        Document doc = HTMLParser.parse(downloadedHtml);
        String text = HTMLParser.text(doc);

        Map<String, Long> entrances = util.entrancesCounting(text);

        LinkedHashMap<String, Long> sortedEntrances = util.sortedLinkedEntrancesCounting(entrances);

        sortedEntrances.forEach((key, value) -> {
            System.out.println(key + " - " + value);
        });

        siteService.addSite(new Site(htmlDownloader.getUrl(), sortedEntrances));
    }

}
