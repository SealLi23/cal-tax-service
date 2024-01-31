package com.secretservice.taxservice.service;


import com.secretservice.taxservice.enums.CityEnum;

import java.util.Date;
import java.util.Map;

public interface CongestionCalculationService {
    Map<String, Integer> getTotalTax(int vehicleCode, Date[] dates, CityEnum cityEnum);
}
