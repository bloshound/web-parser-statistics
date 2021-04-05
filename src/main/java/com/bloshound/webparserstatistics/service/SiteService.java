package com.bloshound.webparserstatistics.service;

import com.bloshound.webparserstatistics.model.Site;
import com.bloshound.webparserstatistics.repo.SiteRepo;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.logging.Logger;

@Service
public class SiteService {
    private static final Logger logger = Logger.getLogger(SiteService.class.getName());
    private final SiteRepo siteRepo;

    public SiteService(SiteRepo siteRepo) {
        this.siteRepo = siteRepo;
    }

    public boolean addSite(Site site) {
        Objects.requireNonNull(site);

        Site presentInDb = siteRepo.findByUrl(site.getUrl());

        if (presentInDb != null) {
            logger.info("site from: " + site.getUrl() + " preset in database. Not added");
            return false;
        }

        siteRepo.save(site);
        logger.info("site " + site.getUrl() + " added to database");
        return true;

    }


}
