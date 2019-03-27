package com.lcl.serviceplatform.service;

import com.lcl.serviceplatform.Dao.OrgDao;
import com.lcl.serviceplatform.pojo.Org;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrgService {
    @Autowired
    private OrgDao orgDao;
    @Transactional()
    public boolean addOrg(Org org) {
        List<Org> orgs = orgDao.findOrgByCodeOrName(org);
        if (orgs.size() != 0) {
            return false;
        } else {
            orgDao.add(org);
            return true;
        }
    }
    @Transactional()
    public List<Org> findAll(String keyword){
            return orgDao.findAll(keyword);
    }
    @Transactional()
    public void deleteOrg(String id) {
            orgDao.delete(id);
    }
    @Transactional()
    public boolean updateOrgs(Org org) throws Exception {
        List<Org> orgs = orgDao.findOrgByCodeOrName(org);
        for (Org org1 : orgs) {
            if (!org1.getId().equals(org.getId())) {
                if(org1.getCode().equals(org.getCode()) || org1.getName().equals(org.getName())) {
                    return false;
                }
            }
        }
        orgDao.update(org);
        return true;
    }

    public boolean checkNameorCode(Org org) {
        List<Org> orgs = orgDao.findOrgByCodeOrName(org);
        if (orgs.size() == 0) {
            return true;
        }
        for (Org org1 : orgs) {
            if (!org.getId().equals(org1.getId())) {
                if (org.getCode().equals(org1.getCode()) || org.getName().equals(org1.getName())) {
                    return false;
                }
            }
        }
        return true;
    }

}
