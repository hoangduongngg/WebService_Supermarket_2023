package microservice.importdetail.repository;

import microservice.importdetail.model.entity.ImportDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Repository
public interface ImportDetailEntityRepository extends JpaRepository<ImportDetailEntity, Long> {
    @Transactional
    long deleteAllBySupplierId(Long supplierId);
    List<ImportDetailEntity> findByProductIdAndCreatedTimeBetween(Long productId, Date timeStart, Date timeEnd);
    @Query()
    List<ImportDetailEntity> findBySupplierIdAndProductIdAndCreatedTimeBetween(Long supplierId, Long productId, Date timeStart, Date timeEnd);
}
