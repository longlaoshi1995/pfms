package com.pfms.service.imp;


import com.pfms.dao.BillDao;
import com.pfms.service.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BillServiceImpl implements IBillService {
    @Autowired
    BillDao billDao;


    public Map<String, Object> getCategory() {
        Map<String, Object>  map = new HashMap<String, Object>();
        List<Map<String, Object>>  list =   billDao.getCategory();
        map.put("data",list);
        return map;
    }

    public Map<String, Object> getMonthBill(String month) {
        Map<String, Object>  map = new HashMap<String, Object>();
        List<Map<String, Object>>  list =   billDao.getMonthBill(month);
        map.put("data",list);
        return map;
    }

    public Map<String, Object> getYearBill(String year) {
        Map<String, Object>  map = new HashMap<String, Object>();
        List<Map<String, Object>>  list =   billDao.getYearBill(year);
        map.put("data",list);
        return map;
    }
}
