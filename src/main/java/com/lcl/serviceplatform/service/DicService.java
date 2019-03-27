package com.lcl.serviceplatform.service;

import com.lcl.serviceplatform.Dao.DicDao;
import com.lcl.serviceplatform.pojo.Dic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DicService {
    @Autowired
    DicDao dicDao;
    @Transactional
    public void delete(Dic dic) {
        dicDao.delete(dic);
    }
    @Transactional
    public List<Dic> findDicsByType(String type) {
        return   dicDao.findByType(type);
    }

    @Transactional
    public boolean add(Dic dic) {
        List<Dic> list = dicDao.findByType(dic.getType());
        if (list != null) {
            for (Dic dic1 : list) {
                if (dic.getName().equals(dic1.getName())) {
                    return false;
                }
                if (dic.getValue() == dic1.getValue()) {

                    return false;
                }

            }
        }
        dicDao.add(dic);
        return true;
    }
    @Transactional
    public boolean update(Dic dic) {
        List<Dic> list = dicDao.findByType(dic.getType());
        if (list != null) {
            for (Dic dic1 : list) {
                if (dic.getName().equals(dic1.getName()) && dic.getValue() == dic1.getValue()) {
                    return false;
                }
            }
        }
        dicDao.Update(dic);
        return true;
    }


}
