package microservice.importdetail.repository;

import microservice.importdetail.model.entity.ImportDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Repository
public interface ImportDetailRepository extends JpaRepository<ImportDetailEntity, Long> {
    @Transactional
    long deleteAllBySupplierId(Long supplierId);
    List<ImportDetailEntity> findByProductIdAndCreatedTimeBetween(Long productId, Date timeStart, Date timeEnd);
    List<ImportDetailEntity> findBySupplierIdAndCreatedTimeBetween(Long supplierId, Date timeStart, Date timeEnd);
}
