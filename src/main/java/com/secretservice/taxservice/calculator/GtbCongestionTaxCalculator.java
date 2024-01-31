package com.secretservice.taxservice.calculator;

import com.secretservice.taxservice.enums.CityEnum;
import com.secretservice.taxservice.utils.DateUtils;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

@Component
public class GtbCongestionTaxCalculator implements CongestionTaxCalculator{

    @Override
    public int calculateTax(Date date){
        if(DateUtils.isTollFreeTime(date))
            return 0;
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);

        if (hour == 6){
            if(minute >= 0 && minute <= 29){
                return 8;
            }else{
                return 13;
            }
        }
        if(hour == 7){
            return 18;
        }
        if(hour == 8){
            if(minute >= 0 && minute <= 29)
                return 13;
            else
                return 8;
        }
        if(hour < 15){
            return 8;
        }
        if(hour == 15){
            if(minute >= 0 && minute <= 29)
                return 13;
        }
        if(hour < 17){
            return 18;
        }
        if(hour == 17){
            return 13;
        }
        if(hour == 18){
            if(minute >= 0 && minute <= 29)
                return 8;
        }
        return 0;
    }

    @Override
    public CityEnum getCity() {
        return CityEnum.GOTHENBURG;
    }
}
