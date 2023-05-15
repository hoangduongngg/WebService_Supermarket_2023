package com.example.thongkekh.dto;

public class CustomerStatitic {
    private Integer customerid;

    private String customerName;
    private Long total;

    public Integer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Integer customerid) {
        this.customerid = customerid;
    }

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

    public CustomerStatitic(Integer customerid, String customerName, Long total) {
        this.customerid = customerid;
        this.customerName = customerName;
        this.total = total;
    }
}
