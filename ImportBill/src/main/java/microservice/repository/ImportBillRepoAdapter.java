package microservice.repository;

import microservice.model.ImportBill;
import microservice.model.entity.ImportBillEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ImportBillRepoAdapter {
    private ImportBillRepository importBillRepository;

    @Autowired
    public ImportBillRepoAdapter(ImportBillRepository importBillRepository) {
        this.importBillRepository = importBillRepository;
    }

    public List<ImportBill> getAll(){
        return importBillRepository.findAll()
                .stream().map(entity -> new ImportBill(entity.getId()) )
                .collect(Collectors.toList());
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
