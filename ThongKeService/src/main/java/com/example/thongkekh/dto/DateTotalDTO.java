package com.example.thongkekh.dto;

public class DateTotalDTO {
    private Integer month;

    private Long total;

    public DateTotalDTO(Integer month, Long total) {
        this.month = month;
        this.total = total;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

}
