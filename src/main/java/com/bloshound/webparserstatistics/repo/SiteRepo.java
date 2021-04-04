package com.bloshound.webparserstatistics.repo;

import com.bloshound.webparserstatistics.model.Site;
import org.springframework.data.jpa.repository.JpaRepository;

import java.net.URL;

public interface SiteRepo extends JpaRepository<Site, Long> {

    Site findByUrl(URL url);
}
