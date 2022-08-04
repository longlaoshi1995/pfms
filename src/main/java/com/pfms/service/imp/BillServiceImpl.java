package com.pfms.service.imp;


import com.pfms.dao.BillDao;
import com.pfms.service.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        Map<String, Object> result = new HashMap<String, Object>();
        List<Integer> listTime = new ArrayList<Integer>();
        List<Double> listMoney = new ArrayList<Double>();
        for(int i= 0; i < 12; i++){
            listTime.add(i);
            listMoney.add(0d);
        }
        List<Map<String, Object>> list =  billDao.getYearBill(year);
        for(Map<String,Object> monthMoney : list){
            int month = Integer.valueOf(monthMoney.get("month").toString().substring(4));
            Double money = Double.valueOf(monthMoney.get("num").toString());
            listMoney.set(month - 1, money);
        }
        result.put("monthList",listTime);
        result.put("listMoney",listMoney);
        return result;
    }
}
