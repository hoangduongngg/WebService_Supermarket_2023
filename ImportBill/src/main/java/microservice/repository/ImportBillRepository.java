package microservice.repository;

import microservice.model.ImportBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImportBillRepository extends JpaRepository<ImportBill, Long> {
    long deleteBySupplierId(Long supplierId);
}
