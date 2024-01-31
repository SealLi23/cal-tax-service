package com.secretservice.taxservice.model.vehicle;

import com.secretservice.taxservice.enums.VehicleTypeEnum;

public interface Vehicle {
    VehicleTypeEnum getVehicleType();

    String getManufacture();

    String getPlateNumber();

    public int getCode();
}


