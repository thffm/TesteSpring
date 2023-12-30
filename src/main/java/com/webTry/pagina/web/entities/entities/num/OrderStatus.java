package com.webTry.pagina.web.entities.entities.num;

public enum OrderStatus {
    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    private  int code;

    private OrderStatus(int code){
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static OrderStatus valueOF(int code){
        for (OrderStatus value: OrderStatus.values()){
            if(value.getCode() == code){
                return value;
            }
        }
        throw  new IllegalArgumentException("Invalid OrderStatus Code");
    }
}
