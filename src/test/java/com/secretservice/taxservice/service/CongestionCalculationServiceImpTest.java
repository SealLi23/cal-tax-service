package com.secretservice.taxservice.service;

import com.secretservice.taxservice.enums.CityEnum;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CongestionCalculationServiceImpTest {

    @Rule
    public TestName name = new TestName();
    @Autowired
    private CongestionCalculationService congestionCalculationService;

    private final String DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";
    private SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);

    private Date[] dates;

    @Before
    public void setup() throws ParseException, IOException {
        System.out.println(name.getMethodName());
        String fileName = name.getMethodName()+".txt";
        InputStream is = this.getClass().getResourceAsStream(fileName);
        if(is == null)
            return;
        String[] dateStrings = null;
        List<String> l = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new InputStreamReader(is))){
            while(br.ready()){
                l.add(br.readLine());
            }
            dateStrings = l.toArray(new String[]{});
        }catch (Exception e){
            e.printStackTrace();
        }
        dates = new Date[dateStrings.length];
        Date d;
        for(int i=0; i<dates.length; i++){
            d = sdf.parse(dateStrings[i]);
            dates[i] = d;
        }
    }

    @Test
    public void getTotalTaxTestWithSampleCase() {
        Map<String,Integer> result = congestionCalculationService.getTotalTax(9,dates, CityEnum.GOTHENBURG);
        Assert.assertEquals(97, result.get("total").intValue());
    }

    @Test
    public void getTotalTaxTestWithNULLDates() {
        Map<String,Integer> result = congestionCalculationService.getTotalTax(9,null,CityEnum.GOTHENBURG);
        Assert.assertEquals(0, result.get("total").intValue());
    }

    @Test
    public void getTotalTaxTestWithEmptyDates() {
        Map<String,Integer> result = congestionCalculationService.getTotalTax(9,new Date[]{},CityEnum.GOTHENBURG);
        Assert.assertEquals(0, result.get("total").intValue());
    }

    @Test
    public void getTotalTaxTestWithTollFreeVehicle() {
        for(int i=0;i<=5;i++) {
            Map<String, Integer> result = congestionCalculationService.getTotalTax(i, dates,CityEnum.GOTHENBURG);
            Assert.assertEquals(0, result.get("total").intValue());
        }
    }
//    @Test
//    public void getTotalTaxTestWithAllHoliday() {
//
//        for(int i=0;i<=5;i++) {
//            Map<String, Integer> result = congestionCalculationService.getTotalTax(i, dates);
//            Assert.assertEquals(0, result.get("total").intValue());
//        }
//    }
}
