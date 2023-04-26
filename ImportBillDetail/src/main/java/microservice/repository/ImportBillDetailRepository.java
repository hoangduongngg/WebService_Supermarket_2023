package microservice.repository;

import microservice.model.ImportBillDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImportBillDetailRepository extends JpaRepository<ImportBillDetail, Long> {
    long deleteAllByImportBillSupplierId(Long supplierId);
}
