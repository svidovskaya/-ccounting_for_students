package com.example.classroom.repos;

import com.example.classroom.domain.Couples;
import com.example.classroom.domain.Couples_user;
import com.example.classroom.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoupUsrRepo extends JpaRepository<Couples_user, Long> {

List<Couples_user> findByCouples(Couples couples);
Couples_user findByCouplesAndUser(Couples couples, User user);

}
