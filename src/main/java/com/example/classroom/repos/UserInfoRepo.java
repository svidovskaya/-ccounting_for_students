package com.example.classroom.repos;


import com.example.classroom.domain.UserInfo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserInfoRepo extends CrudRepository<UserInfo, Long> {

  List<UserInfo> findAll();



}
