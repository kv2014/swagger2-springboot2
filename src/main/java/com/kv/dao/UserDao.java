package com.kv.dao;

import java.util.List;

import com.kv.model.UserDomain;

public interface UserDao {

    int insert(UserDomain record);

    List<UserDomain> selectUsers();

    void insertMybatisBatch(List<UserDomain> userDomains);
}