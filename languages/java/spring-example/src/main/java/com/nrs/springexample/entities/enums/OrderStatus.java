package com.nrs.springexample.entities.enums;

import lombok.Getter;

public enum OrderStatus {
    WAITTING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    @Getter
    private int code;

    private OrderStatus(int code){
        this.code = code;
    }

    public static OrderStatus valueOf(int code){
        for(OrderStatus value : OrderStatus.values()){
            if(value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid OrderStatus code");
    }
}
