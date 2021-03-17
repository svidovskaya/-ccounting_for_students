package com.example.classroom.domain;


import javax.persistence.*;
import java.sql.Time;
import java.util.Set;

@Entity
@Table(name = "couples_user")
public class Couples_user {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Time t_start;
    private  Time t_stop;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "coup_id")
    private Couples couples;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Couples getCouples() {
        return couples;
    }

    public void setCouples(Couples couples) {
        this.couples = couples;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
