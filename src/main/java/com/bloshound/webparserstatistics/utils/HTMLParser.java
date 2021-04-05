package com.bloshound.webparserstatistics.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;


/**
 * use {@link org.jsoup.Jsoup} for most utility methods for html working in application
 */
@Component
public final class HTMLParser {
    /**
     * default charset {@code UTF-8} for use.
     */
    public static final String charSet = "UTF-8";

    /**
     * @param filename is path name of html file for parsing, wrapped to {@link java.io.InputStream} and use buffer.
     * @return {@link Document} from parser.
     * @throws IOException if the file could not be found, or read.
     */
    public static Document parse(String filename) throws IOException {
        return parse(new File(filename));
    }

    /**
     * @param file is a html file for parsing, wrapped to {@link java.io.InputStream} and use buffer.
     * @return {@link Document} from parser.
     * @throws IOException if the file could not be found, or read.
     */
    public static Document parse(File file) throws IOException {
        return Jsoup.parse(file, charSet);
    }

    /**
     * use for get whole text from html page
     *
     * @param document is {@link Document} for text
     * @return String of html text;
     */
    public static String text(Document document) {
        return document.wholeText();
    }
}
