package com.secretservice.taxservice.service.bean;

import java.util.Map;
import java.util.Set;

public class HolidayBean {

    private Map<Integer, Map<Integer, Set<Integer>>> generalConfiguration;

    public Map<Integer, Map<Integer, Set<Integer>>> getGeneralConfiguration() {
        return generalConfiguration;
    }

    public void setGeneralConfiguration(Map<Integer, Map<Integer, Set<Integer>>> generalConfiguration) {
        this.generalConfiguration = generalConfiguration;
    }
}