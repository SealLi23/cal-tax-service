package com.secretservice.taxservice.model.vehicle;

import com.secretservice.taxservice.enums.VehicleTypeEnum;

public class Car implements Vehicle {
    private String manufacture;
    private String plateNumber;
    private int code;

    @Override
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }    public VehicleTypeEnum getVehicleType() {
        return VehicleTypeEnum.getVehicleType(code);
    }

    @Override
    public String getManufacture() {
        return manufacture;
    }

    @Override
    public String getPlateNumber() {
        return plateNumber;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }
    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

}
