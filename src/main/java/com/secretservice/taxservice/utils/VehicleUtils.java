package com.secretservice.taxservice.utils;

import com.secretservice.taxservice.model.vehicle.Vehicle;
import com.secretservice.taxservice.enums.VehicleType;

import java.util.HashSet;
import java.util.Set;

public class VehicleUtils {
    private final static Set<VehicleType> tollFreeVehicles = new HashSet<>();
    static {
        tollFreeVehicles.add(VehicleType.MOTORCYCLE);
        tollFreeVehicles.add(VehicleType.BUS);
        tollFreeVehicles.add(VehicleType.EMERGENCY);
        tollFreeVehicles.add(VehicleType.DIPLOMAT);
        tollFreeVehicles.add(VehicleType.FOREIGN);
        tollFreeVehicles.add(VehicleType.Military);
    }
    public static boolean isTollFreeVehicle(Vehicle vehicle) {
        return vehicle == null || vehicle.getVehicleType() == null || tollFreeVehicles.contains(vehicle.getVehicleType());
    }

    public static boolean isTollFreeVehicle(int vehicleCode) {
        VehicleType vehicleType = VehicleType.getVehicleType(vehicleCode);
        return  tollFreeVehicles.contains(vehicleType);
    }
    public static VehicleType getVehicleType(int vehicleCode) {
        VehicleType vehicleType = VehicleType.getVehicleType(vehicleCode);
        return  vehicleType;
    }

}
