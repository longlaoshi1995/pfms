package com.pfms.dao;

import java.util.List;
import java.util.Map;

public interface BillDao {

    List<Map<String, Object>> listYearBill(String year);

    List<Map<String, Object>> getCategory();
}
