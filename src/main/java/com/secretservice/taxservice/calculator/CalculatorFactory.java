package com.secretservice.taxservice.calculator;

import com.secretservice.taxservice.enums.CityEnum;

public interface CalculatorFactory {
    public CongestionTaxCalculator getCalculator(CityEnum cityEnum);
}
