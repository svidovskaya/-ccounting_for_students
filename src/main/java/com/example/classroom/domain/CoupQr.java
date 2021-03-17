package com.example.classroom.domain;


import javax.persistence.*;

@Entity
@Table(name = "coup_qr")
public class CoupQr {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name_start;
    private String name_stop;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "coup_id")
    private Couples couples;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName_start() {
        return name_start;
    }

    public void setName_start(String name_start) {
        this.name_start = name_start;
    }

    public String getName_stop() {
        return name_stop;
    }

    public void setName_stop(String name_stop) {
        this.name_stop = name_stop;
    }

    public Couples getCouples() {
        return couples;
    }

    public void setCouples(Couples couples) {
        this.couples = couples;
    }
}
