package ptit.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ImportBillDetail {
    private static final long serialVersionUID = 100000000000003L;
    private Long id;
    private float unitPrice;
    private int quantity;
    private Product product;
    @JsonIgnore
    private ImportBill importBill;
}
