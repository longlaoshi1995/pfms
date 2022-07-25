package com.pfms.controller;


import com.pfms.service.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.support.AbstractMultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/bill")
public class BillController {
    @Autowired
    IBillService billService;

    /**
    * 获取账单类别
    * */
    @RequestMapping(method = RequestMethod.POST, value = "/getCategory")
    @ResponseBody
    public Map<String,Object>  getCategory(HttpServletRequest request){
        Map<String,Object>  map = new HashMap<String, Object>();
        map = billService.getCategory();
        return map;
    }

    /**
     * 获取某月账单
     * */
    @RequestMapping(method = RequestMethod.GET, value = "/getMonthBill")
    @ResponseBody
    public Map<String,Object>    getMonthBill(HttpServletRequest request){
        Map<String,Object>  map = new HashMap<String, Object>();
        String month = request.getParameter("month");
        map = billService.getMonthBill(month);
        return map;
    }

    /**
     *
    * 月份账单对比
    * */
    @RequestMapping(method = RequestMethod.GET, value = "/getYearBill")
    @ResponseBody
    public Map<String,Object>    getYearBill(HttpServletRequest request){
        Map<String,Object>  map = new HashMap<String, Object>();
        String year = request.getParameter("year");
        map = billService.getYearBill(year);
        return map;
    }



}
