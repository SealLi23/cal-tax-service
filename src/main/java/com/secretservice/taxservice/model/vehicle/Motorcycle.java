package com.secretservice.taxservice.model.vehicle;

import com.secretservice.taxservice.enums.VehicleType;

public class Motorcycle implements Vehicle {
    private int code;
    private String manufacture;
    private String plateNumber;

    @Override
    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    @Override
    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public void setCode(int code) {
        this.code = code;
    }    public VehicleType getVehicleType() {
        return VehicleType.getVehicleType(code);
    }

    @Override
    public int getCode() {
        return code;
    }

}
