package microservice.repository;

import microservice.model.ImportBill;
import microservice.model.entity.ImportBillEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ImportBillEntityRepoAdapter {
    private ImportBillRepository importBillRepository;

    @Autowired
    public ImportBillEntityRepoAdapter(ImportBillRepository importBillRepository) {
        this.importBillRepository = importBillRepository;
    }
    public ImportBill save(ImportBill importBill){
        ImportBillEntity savedEntity = importBillRepository.save(
                new ImportBillEntity(
                    null,
                    importBill.getCreatedTime(),
                    importBill.getSupplier().getId(),
                    importBill.getCreator().getId()
                )
        );
        importBill.setId(savedEntity.getId());
        return importBill;
    }
    public long deleteAllBySupplierId(Long supplierId){
        return importBillRepository.deleteAllBySupplierId(supplierId);
    }
}
