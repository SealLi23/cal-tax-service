package com.secretservice.taxservice.model.vehicle;

import com.secretservice.taxservice.enums.VehicleType;

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
    }    public VehicleType getVehicleType() {
        return VehicleType.getVehicleType(code);
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
