package com.lcl.serviceplatform.Dao;

import com.lcl.serviceplatform.pojo.Org;

import java.util.List;

public interface OrgDao {
    void add(Org org);

    void delete(String id);

    void update(Org org);

    List<Org> findAll(String keyword);

    List<Org> findOrgByCodeOrName(Org org);

    Org findById(String id);

}
