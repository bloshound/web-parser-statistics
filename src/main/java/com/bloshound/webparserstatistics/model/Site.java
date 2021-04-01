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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column()
    private URL fromUrl;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "site_entrances", joinColumns = @JoinColumn(name = "site_id"))
    private Map<String, Long> entranses;

    public Site() {
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

    public URL getFromUrl() {
        return fromUrl;
    }

    public void setFromUrl(URL fromUrl) {
        this.fromUrl = fromUrl;
    }

    public Map<String, Long> getEntranses() {
        return entranses;
    }

    public void setEntranses(Map<String, Long> entranses) {
        this.entranses = entranses;
    }
}
