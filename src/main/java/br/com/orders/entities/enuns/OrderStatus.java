package br.com.orders.entities.enuns;

public enum OrderStatus {
    PENDING_PAYMENT ("Pending payment"),
    PROCESSING ("Processing"),
    SHIPPED ("Shipped"),
    DELIVERED ("Delivered");

    private String status;

    OrderStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
