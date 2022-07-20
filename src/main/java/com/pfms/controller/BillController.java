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
    @RequestMapping(method = RequestMethod.GET, value = "/getCategory")
    @ResponseBody
    public Map<String,Object>  getCategory(HttpServletRequest request){
        Map<String,Object>  map = new HashMap<String, Object>();
        map = billService.getCategory();
        return map;
    }

}
