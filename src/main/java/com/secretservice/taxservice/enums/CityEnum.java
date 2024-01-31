package com.secretservice.taxservice.enums;

public enum CityEnum {
    GOTHENBURG("Gothenburg", 0);
    String name;
    int code;
    CityEnum(String name, int code) {
        this.name = name;
        this.code = code;
    }
}
