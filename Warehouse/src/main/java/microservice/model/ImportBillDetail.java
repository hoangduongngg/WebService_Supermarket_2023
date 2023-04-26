package microservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
public class ImportBillDetail {
    private static final long serialVersionUID = 100000000000003L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private float unitPrice;
    @Column(nullable = false)
    private int quantity;
    @OneToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "import_bill_id", nullable = false)
    private ImportBill importBill;
}
