package com.example.orderservice.dto;

public class CustomerStatitic {

    private String customerName;
    private Long total;



    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public CustomerStatitic( String customerName, Long total) {
        this.customerName = customerName;
        this.total = total;
    }
}
