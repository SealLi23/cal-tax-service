package com.secretservice.taxservice.service;

import java.util.Date;

public class HolidayServiceImp implements HolidayService{

    @Override
    public boolean isPublicHoliday(Date date) {

        return false;
    }
}
