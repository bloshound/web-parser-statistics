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


}
