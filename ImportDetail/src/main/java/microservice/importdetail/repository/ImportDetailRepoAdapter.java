package microservice.importdetail.repository;

import microservice.importdetail.model.ImportBill;
import microservice.importdetail.model.ImportDetail;
import microservice.importdetail.model.entity.ImportDetailEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;

@Component
public class ImportDetailRepoAdapter {
    private ImportDetailRepository importDetailRepository;

    @Autowired
    public ImportDetailRepoAdapter(ImportDetailRepository importDetailRepository){
        this.importDetailRepository = importDetailRepository;
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
            cnt += (importDetailRepository.save(entity) != null) ? 1 : 0;
        }
        return cnt;
    }
    public long deleteAllBySupplierId(Long supplierId){
        return importDetailRepository.deleteAllBySupplierId(supplierId);
    }
    public List<ImportDetail> findBySupplierIdAndCreatedTimeBetween(Long supplierId, Date timeStart, Date timeEnd){
        return null;
    }
}
