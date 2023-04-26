package microservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.sql.Date;
import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
public class ImportBill {
    private static final long serialVersionUID = 100000000000002L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdTime;
    @OneToOne
    @JoinColumn(name = "supplier_id", nullable = false)
    private Supplier supplier;
    @OneToMany(mappedBy = "importBill")
    @JsonBackReference
    private List<ImportBillDetail> details;
}
