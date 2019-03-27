package com.lcl.serviceplatform.Dao;

import com.lcl.serviceplatform.pojo.Dic;

import java.util.List;

public interface DicDao {
    void add(Dic dic);

    void delete(Dic dic);

    void Update(Dic dic);

    List<Dic> findByType(String type);

}
