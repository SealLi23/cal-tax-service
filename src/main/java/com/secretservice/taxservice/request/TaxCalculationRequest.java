package com.secretservice.taxservice.request;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

public class TaxCalculationRequest {
    private int vehicleTypeCode;

    /*
    TODO: Add a city code field to apply the relevant calculation rule
     */
//    private int cityCode

    public int getVehicleTypeCode() {
        return vehicleTypeCode;
    }

    public void setVehicleTypeCode(int vehicleTypeCode) {
        this.vehicleTypeCode = vehicleTypeCode;
    }

    public List<Date> getTimestamps() {
        return timestamps;
    }

    public void setTimestamps(List<Date> timestamps) {
        this.timestamps = timestamps;
    }

    @JsonFormat
    private List<Date> timestamps;


}
