package microservice.service;

import microservice.WarehouseApplication;
import microservice.chain.ImportGoods;
import microservice.model.ImportBill;
import microservice.model.ImportBillDetail;
import org.springframework.stereotype.Service;

@Service
public class ImportBillService extends AbsService implements ImportGoods {
    @Override
    public boolean save(ImportBill importBill) {
        ImportBill response = rest.postForObject(WarehouseApplication.IMPORT_BILL_SERVICE_URL, importBill, ImportBill.class);
        importBill.setId(response.getId());
        for (ImportBillDetail detail:importBill.getDetails()){
            detail.setImportBill(importBill);
        }
        return true;
    }
}
