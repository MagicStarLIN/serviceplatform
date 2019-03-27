package com.lcl.serviceplatform.controller;


import com.lcl.serviceplatform.Dao.DicDao;
import com.lcl.serviceplatform.pojo.Dic;
import com.lcl.serviceplatform.pojo.Result;
import com.lcl.serviceplatform.service.DicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/dic")
public class DicController {
    @Autowired
    DicService dicService;

    @PostMapping
    public Result getDic(@RequestBody ArrayList<String> types) {
        Result result = new Result();
        Map<String, List<Dic>> map = new HashMap<>();
        for (String type : types) {
            map.put(type,dicService.findDicsByType(type));
        }
        result.setData(map);
        return result;
    }



}
