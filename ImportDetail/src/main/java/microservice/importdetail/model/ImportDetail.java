package microservice.importdetail.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.sql.Date;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ImportDetail {
    private Long id;
    private float unitPrice;
    private int quantity;
    private Product product;
    private ImportBill importBill;
    public ImportDetail(Long id, float unitPrice, int quantity, Long productId, Long importBillId, Date createdTime){
        this.id = id;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        product = new Product(productId);
        importBill = new ImportBill(importBillId);
        importBill.setCreatedTime(createdTime);
    }
}
