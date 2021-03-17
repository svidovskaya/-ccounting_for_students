package com.example.classroom.repos;

import com.example.classroom.domain.Couples;
import com.example.classroom.domain.Groups;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoupRepo extends JpaRepository<Couples, Long> {



}
