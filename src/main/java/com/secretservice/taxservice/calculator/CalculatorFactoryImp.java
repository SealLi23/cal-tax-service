package com.secretservice.taxservice.calculator;

import com.secretservice.taxservice.enums.CityEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CalculatorFactoryImp implements CalculatorFactory{
    private Map<CityEnum, CongestionTaxCalculator> cityToCalculator;

    @Autowired
    public CalculatorFactoryImp(List<CongestionTaxCalculator> calculatorList){
        cityToCalculator = new HashMap<>();
        for(CongestionTaxCalculator c : calculatorList){
            cityToCalculator.put(c.getCity(),c);
        }
    }

    public CongestionTaxCalculator getCalculator(CityEnum cityEnum){
        return cityToCalculator.get(cityEnum);
    }
}
