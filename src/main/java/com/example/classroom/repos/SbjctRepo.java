package com.example.classroom.repos;

import com.example.classroom.domain.Sbjct;
import com.example.classroom.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SbjctRepo extends JpaRepository<Sbjct, Long> {

    List<Sbjct> findByUser(User user);


}
