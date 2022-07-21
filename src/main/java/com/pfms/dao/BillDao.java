package com.pfms.dao;

import java.util.List;
import java.util.Map;

public interface BillDao {


    List<Map<String, Object>> getCategory();

    List<Map<String, Object>> getMonthBill(String month);

    List<Map<String, Object>> getYearBill(String year);
}
