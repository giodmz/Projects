package com.example.demo.entities.enums;

public enum OrderStatus {

    // especificando o numero no banco de dados por questões de manutenção
    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    private int code;

    // construtor de enum é private
    private OrderStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }


    // recebe um code e retorna o code equivalente ao valor do OrderStatus
    public static OrderStatus valueOf(int code) {
        // percorre todos os valores do OrderStatus
        for (OrderStatus value : OrderStatus.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid OrderStatus code");
    }

}
