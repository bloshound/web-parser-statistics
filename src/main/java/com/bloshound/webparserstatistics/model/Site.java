package com.bloshound.webparserstatistics.model;

import javax.persistence.*;
import java.net.URL;
import java.util.Map;

@Entity
@Table(name = "site")
public class Site {

    @Version
    int version;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column()
    private URL url;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "site_entrances", joinColumns = @JoinColumn(name = "site_id"))
    private Map<String, Long> entrances;

    public Site() {
    }

    public Site(URL url, Map<String, Long> entrances) {
        this.url = url;
        this.entrances = entrances;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL fromUrl) {
        this.url = fromUrl;
    }

    public Map<String, Long> getEntrances() {
        return entrances;
    }

    public void setEntrances(Map<String, Long> entrances) {
        this.entrances = entrances;
    }
}
