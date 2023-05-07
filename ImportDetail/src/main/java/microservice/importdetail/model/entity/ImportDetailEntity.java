package microservice.importdetail.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.sql.Date;

@Entity
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "import-detail")
public class ImportDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private float unitPrice;
    @Column(nullable = false)
    private int quantity;
    @Column(nullable = false)
    private Long productId;
    @Column(nullable = false)
    private Long importBillId;
    @Column(nullable = false)
    private Long supplierId;
    @Column(nullable = false)
    private Date createdTime;
}
