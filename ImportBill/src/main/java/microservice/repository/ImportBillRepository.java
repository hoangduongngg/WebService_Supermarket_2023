package microservice.repository;

import microservice.model.entity.ImportBillEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ImportBillRepository extends JpaRepository<ImportBillEntity, Long> {
    long deleteAllBySupplierId(Long supplierId);
}
