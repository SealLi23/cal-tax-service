package com.secretservice.taxservice.utils;

import com.secretservice.taxservice.model.vehicle.Vehicle;
import com.secretservice.taxservice.enums.VehicleTypeEnum;

import java.util.HashSet;
import java.util.Set;

public class VehicleUtils {
    private final static Set<VehicleTypeEnum> tollFreeVehicles = new HashSet<>();
    static {
        tollFreeVehicles.add(VehicleTypeEnum.MOTORCYCLE);
        tollFreeVehicles.add(VehicleTypeEnum.BUS);
        tollFreeVehicles.add(VehicleTypeEnum.EMERGENCY);
        tollFreeVehicles.add(VehicleTypeEnum.DIPLOMAT);
        tollFreeVehicles.add(VehicleTypeEnum.FOREIGN);
        tollFreeVehicles.add(VehicleTypeEnum.Military);
    }
    public static boolean isTollFreeVehicle(Vehicle vehicle) {
        return vehicle == null || vehicle.getVehicleType() == null || tollFreeVehicles.contains(vehicle.getVehicleType());
    }

    public static boolean isTollFreeVehicle(int vehicleCode) {
        VehicleTypeEnum vehicleTypeEnum = VehicleTypeEnum.getVehicleType(vehicleCode);
        return  tollFreeVehicles.contains(vehicleTypeEnum);
    }
    public static VehicleTypeEnum getVehicleType(int vehicleCode) {
        VehicleTypeEnum vehicleTypeEnum = VehicleTypeEnum.getVehicleType(vehicleCode);
        return vehicleTypeEnum;
    }

}
