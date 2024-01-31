package com.secretservice.taxservice.service;

import com.secretservice.taxservice.calculator.CongestionTaxCalculator;
import com.secretservice.taxservice.utils.DateUtils;
import com.secretservice.taxservice.utils.VehicleUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
public class CongestionCalculationServiceImp implements CongestionCalculationService{

    private final long MILLISECOND_IN_HOUR = TimeUnit.HOURS.toMillis(1);

    private final int MAX_TOLL_A_DAY = 60;

    @Autowired
    private CongestionTaxCalculator congestionTaxCalculator;
    private final String TOTAL = "total";
    @Override
    public Map<String, Integer> getTotalTax(int vehicleCode, Date[] dates) {
        Map<String, Integer> dailyBill = new HashMap<>();
        dailyBill.put(TOTAL, 0);
        if(dates == null || dates.length==0
            || VehicleUtils.isTollFreeVehicle(vehicleCode)){
            return dailyBill;
        }
        dates = Arrays.stream(dates).filter(d->d!=null).sorted((Comparator.naturalOrder())).collect(Collectors.toList()).toArray(new Date[]{});
        int dailySum = 0;
        int total = 0;
        Date currDate;
        Date startDate = null;
        Integer maxTaxInHour = null;
        int currentTax;
        for (int i = 0; i < dates.length ; i++) {
            currDate = dates[i];
            if (DateUtils.isTollFreeTime(currDate)) {
                continue;
            }
            if(startDate == null){
                startDate = currDate;
                maxTaxInHour = congestionTaxCalculator.calculateTax(currDate);
            }else {
                if (currDate.getTime() - startDate.getTime() <= MILLISECOND_IN_HOUR) {
                    currentTax = congestionTaxCalculator.calculateTax(currDate);
                    if (maxTaxInHour < currentTax) {
                        maxTaxInHour = currentTax;
                    }
                } else {
                    dailySum += maxTaxInHour;
                    if (!DateUtils.checkSameDate(startDate,currDate)) {
                        if(dailySum > MAX_TOLL_A_DAY){
                            dailySum = MAX_TOLL_A_DAY;
                        }
//                    Has rolled in a new day, record the tax amount of last billing day and count it
                        dailyBill.put(produceMonthDateKey(startDate), dailySum);
                        total += dailySum;
                        dailySum = 0;
                    }
                    startDate = currDate;
                    maxTaxInHour = congestionTaxCalculator.calculateTax(currDate);
                }
            }
            if(i == dates.length-1){
                dailySum += maxTaxInHour;
                if(dailySum > MAX_TOLL_A_DAY)
                    dailySum = MAX_TOLL_A_DAY;
                dailyBill.put(produceMonthDateKey(startDate),dailySum);
                total +=  dailySum;
                dailySum = 0;
            }
        }
        dailyBill.put(TOTAL, total);
        return dailyBill;
    }

    private String produceMonthDateKey(Date date){
        int m = DateUtils.getMonth(date);
        int d = DateUtils.getDate(date);
        return new StringBuilder().append(m).append(".").append(d).toString();
    }
}
