package microservice.importdetail.repository;

import microservice.importdetail.model.*;
import microservice.importdetail.model.entity.ImportDetailEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.*;

@Component
public class ImportDetailRepoAdapter {
    private ImportDetailEntityRepository importDetailEntityRepository;

    @Autowired
    public ImportDetailRepoAdapter(ImportDetailEntityRepository importDetailEntityRepository){
        this.importDetailEntityRepository = importDetailEntityRepository;
    }
    public long saveImportBill(ImportBill importBill){
        int cnt = 0;
        for(ImportDetail detail:importBill.getDetails()){
            ImportDetailEntity entity = new ImportDetailEntity(
                    detail.getId(),
                    detail.getUnitPrice(),
                    detail.getQuantity(),
                    detail.getProduct().getId(),
                    importBill.getId(),
                    importBill.getSupplier().getId(),
                    importBill.getCreatedTime()
            );
            cnt += (importDetailEntityRepository.save(entity) != null) ? 1 : 0;
        }
        return cnt;
    }
    public long deleteAllBySupplierId(Long supplierId){
        return importDetailEntityRepository.deleteAllBySupplierId(supplierId);
    }
    public List<SupplierStat> getSupplierStats(Long productId, Date timeStart, Date timeEnd){
        Map<Long, SupplierStat> supplierCache = new HashMap<>();
        for (ImportDetailEntity entity: importDetailEntityRepository.findByProductIdAndCreatedTimeBetween(productId, timeStart, timeEnd)){
            ImportDetail importDetail = entityToDTO(entity);
            if (!supplierCache.containsKey(entity.getSupplierId())){
                SupplierStat supplierStat = new SupplierStat(entity.getSupplierId());
                supplierCache.put(supplierStat.getId(), supplierStat);
            }
            supplierCache.get(entity.getSupplierId()).getDetails().add(importDetail);
        }
        List<SupplierStat> result = new ArrayList<>(supplierCache.values());
        result.sort(new Comparator<SupplierStat>() {
            @Override
            public int compare(SupplierStat o1, SupplierStat o2) {
                return Integer.compare(o1.totalQuantity(), o2.totalQuantity());
            }
        });
        return result;
    }
    public List<ImportDetail> getSupplierStatDetail(Long supplierId, Long productId, Date timeStart, Date timeEnd){
        List<ImportDetail> result = new ArrayList<>();
        for (ImportDetailEntity entity: importDetailEntityRepository.findBySupplierIdAndProductIdAndCreatedTimeBetween(supplierId, productId, timeStart, timeEnd)){
            result.add(entityToDTO(entity));
        }
        return result;
    }
    private ImportDetail entityToDTO(ImportDetailEntity entity){
        return new ImportDetail(
                entity.getId(),
                entity.getUnitPrice(),
                entity.getQuantity(),
                entity.getProductId(),
                entity.getImportBillId(),
                entity.getCreatedTime()
        );
    }
}
