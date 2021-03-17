package com.example.classroom.domain;


import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "couples")
public class Couples {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate date;
    private Time t_start;
    private Time t_stop;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sbjct_id")
    private Sbjct sbjct;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "group_id")
    private Groups groups;

    @OneToMany(mappedBy = "couples", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<CoupQr> coupQrs;

    @OneToMany(mappedBy = "couples", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Couples_user> couples_users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Sbjct getSbjct() {
        return sbjct;
    }

    public void setSbjct(Sbjct sbjct) {
        this.sbjct = sbjct;
    }

    public Groups getGroups() {
        return groups;
    }

    public void setGroups(Groups groups) {
        this.groups = groups;
    }

    public Set<CoupQr> getCoupQrs() {
        return coupQrs;
    }

    public void setCoupQrs(Set<CoupQr> coupQrs) {
        this.coupQrs = coupQrs;
    }

    public Set<Couples_user> getCouples_users() {
        return couples_users;
    }

    public void setCouples_users(Set<Couples_user> couples_users) {
        this.couples_users = couples_users;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Time getT_start() {
        return t_start;
    }

    public void setT_start(Time t_start) {
        this.t_start = t_start;
    }

    public Time getT_stop() {
        return t_stop;
    }

    public void setT_stop(Time t_stop) {
        this.t_stop = t_stop;
    }
}
