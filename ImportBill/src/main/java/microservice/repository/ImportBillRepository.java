package microservice.repository;

import microservice.model.entity.ImportBillEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface ImportBillRepository extends JpaRepository<ImportBillEntity, Long> {
    @Transactional
    long deleteAllBySupplierId(Long supplierId);
}
