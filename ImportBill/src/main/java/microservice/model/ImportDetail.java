package microservice.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ImportDetail {
    private Long id;
    private float unitPrice;
    private int quantity;
    private Product product;
    private ImportBill importBill;
}
