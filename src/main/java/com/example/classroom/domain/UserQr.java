package com.example.classroom.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "usrqr")
public class UserQr {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String qr_name;

    @JsonBackReference
    @OneToOne(mappedBy = "userQr")
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getQr_name() {
        return qr_name;
    }

    public void setQr_name(String qr_name) {
        this.qr_name = qr_name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
