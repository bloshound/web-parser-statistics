package com.bloshound.webparserstatistics;


import org.jsoup.internal.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.logging.Logger;


@Component
public class HTMLDownloader {
    public static final String downloadedDirPathName = ".\\downloaded";
    private static final Logger logger = Logger.getLogger(HTMLDownloader.class.getName());

    private URL url;

    public HTMLDownloader(URL inputUrl) throws MalformedURLException {
        this.url = inputUrl;
    }

    public String downloadHtml() throws IOException {
        long count;
        Path downloadedSitePath = Paths.get(downloadedDirPathName, url.getHost(), url.getPath(), "page.html");

        if (Files.notExists(downloadedSitePath)) Files.createDirectories(downloadedSitePath);

        count = Files.copy(url.openStream(), downloadedSitePath, StandardCopyOption.REPLACE_EXISTING);
        logger.info(count + " bytes copied from: " + url + " to: " + downloadedSitePath.toFile().getCanonicalFile().getAbsolutePath());

        return String.valueOf(downloadedSitePath);
    }


}
