package com.example.classroom.repos;

import com.example.classroom.domain.Groups;
import com.example.classroom.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupsRepo extends JpaRepository<Groups, Long> {



}
