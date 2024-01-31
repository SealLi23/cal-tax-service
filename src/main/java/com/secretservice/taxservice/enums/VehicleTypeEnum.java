package com.secretservice.taxservice.enums;

public enum VehicleTypeEnum {
    MOTORCYCLE("Motorcycle",0),
    BUS("Bus",1),
    EMERGENCY("Emergency",2),
    DIPLOMAT("Diplomat",3),
    FOREIGN("Foreign",4),
    Military("Military",5),
    Car("Car",6);

    String type;
    int code;
    VehicleTypeEnum(String type, int code) {
        this.code = code;
        this.type = type;
    }

    public static VehicleTypeEnum getVehicleType(int code){
        switch(code){
            case 0:{
                return MOTORCYCLE;
            }
            case 1:{
                return BUS;
            }
            case 2:{
                return EMERGENCY;
            }
            case 3:{
                return DIPLOMAT;
            }
            case 4:{
                return FOREIGN;
            }
            case 5:{
                return Military;
            }
            case 6:{
                return Car;
            }
            default:{
                return null;
            }
        }
    }
    public int code(){
        return code;
    }
}
