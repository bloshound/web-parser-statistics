package com.bloshound.webparserstatistics;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;


@Service
public final class HTMLParser {

    public static final String charSet = "UTF-8";

    public static Document parse(String filename) throws IOException {
        return parse(new File(filename));
    }

    public static Document parse(File file) throws IOException {
        return Jsoup.parse(file, charSet);
    }

    public static String text(Document document) {
        return document.text();
    }
}
