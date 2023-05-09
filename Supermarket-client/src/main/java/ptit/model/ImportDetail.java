package ptit.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ImportDetail {
    private Long id;
    private float unitPrice;
    private int quantity;
    private Product product;
    @JsonBackReference
    private ImportBill importBill;
}
