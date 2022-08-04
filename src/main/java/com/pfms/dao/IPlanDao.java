package com.pfms.dao;

import java.util.List;
import java.util.Map;

public interface IPlanDao {

    List<Map<String, Object>> getMonthPlan(String month);
}
