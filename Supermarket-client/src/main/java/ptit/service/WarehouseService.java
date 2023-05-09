package ptit.service;

import org.springframework.stereotype.Service;
import ptit.model.ImportBill;
import ptit.model.SupplierStat;

@Service
public class WarehouseService extends AbsService{
    private final String SAVE_IMPORT_BILL_API =
            ServiceURL.WAREHOUSE_SERVICE_URL + "/import";
    private final String DELETE_SUPPLIER_API =
            ServiceURL.WAREHOUSE_SERVICE_URL + "/delete-supplier";

    public void saveImportBill(ImportBill importBill){
        rest.postForObject(SAVE_IMPORT_BILL_API, importBill, Integer.class);
    }
    public void deleteSupplier(Long id){
        rest.postForObject(DELETE_SUPPLIER_API, id, Integer.class);
    }
}
