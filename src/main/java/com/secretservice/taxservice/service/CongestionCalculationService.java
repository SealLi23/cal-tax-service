package com.secretservice.taxservice.service;


import java.util.Date;
import java.util.Map;

public interface CongestionCalculationService {
    Map<String, Integer> getTotalTax(int vehicleCode, Date[] dates);
}
