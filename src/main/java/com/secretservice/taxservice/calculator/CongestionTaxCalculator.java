package com.secretservice.taxservice.calculator;

import com.secretservice.taxservice.enums.CityEnum;
import com.secretservice.taxservice.model.city.City;

import java.util.Date;

public interface CongestionTaxCalculator {
    public int calculateTax(Date date);

    public CityEnum getCity();
}
