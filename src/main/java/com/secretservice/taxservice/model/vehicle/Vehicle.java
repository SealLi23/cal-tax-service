package com.secretservice.taxservice.model.vehicle;

import com.secretservice.taxservice.enums.VehicleType;

public interface Vehicle {
    VehicleType getVehicleType();

    String getManufacture();

    String getPlateNumber();

    public int getCode();
}


