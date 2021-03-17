package com.example.classroom.repos;

import com.example.classroom.domain.CoupQr;
import com.example.classroom.domain.Couples;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoupQrRepo extends JpaRepository<CoupQr, Long> {

    CoupQr findByCouples(Couples couples);



}
