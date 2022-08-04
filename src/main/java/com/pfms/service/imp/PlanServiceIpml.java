package com.pfms.service.imp;

import com.pfms.dao.IPlanDao;
import com.pfms.service.IPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PlanServiceIpml implements IPlanService {
    @Autowired
    IPlanDao dao;

    @Override
    public Map<String, Object> getMonthPlan(String month) {
        Map<String, Object> map = new HashMap<>();
        List<Map<String, Object>>  list = dao.getMonthPlan(month);
        map.put("data",list);
        return map;
    }
}
