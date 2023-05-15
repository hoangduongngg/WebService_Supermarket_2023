package microservice.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.sql.Date;

@Entity
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "import_bill")
public class ImportBillEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Date createdTime;
    @Column(nullable = false)
    private Long supplierId;
    @Column(nullable = false)
    private Long creatorId;
}
