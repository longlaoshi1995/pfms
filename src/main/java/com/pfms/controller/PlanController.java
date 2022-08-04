package com.pfms.controller;



import com.pfms.service.IPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/plan")
public class PlanController {

    @Autowired
    IPlanService  planService;

    @GetMapping("/getMonthPlan")
    @ResponseBody
    public Map<String,Object> getMonthPlan(HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        String month = request.getParameter("month");
        map = planService.getMonthPlan(month);
        return  map;

    }

}
