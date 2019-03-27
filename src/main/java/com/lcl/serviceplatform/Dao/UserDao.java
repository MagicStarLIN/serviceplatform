package com.lcl.serviceplatform.Dao;

import com.lcl.serviceplatform.pojo.User;

import java.util.List;

public interface UserDao {
    void add(User user);

    void delete(String id);

    void update(User user);

    List<User> findAll(User user);

    List<User> findByName(String name);


}
