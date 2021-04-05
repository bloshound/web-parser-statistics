package com.bloshound.webparserstatistics.repo;

import com.bloshound.webparserstatistics.model.Site;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.net.URL;

public interface SiteRepo extends CrudRepository<Site, Long> {

    Site findByUrl(URL url);
}
