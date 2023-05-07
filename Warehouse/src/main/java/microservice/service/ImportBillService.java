package microservice.service;

import microservice.controller.chain.DeleteSupplierInterface;
import microservice.controller.chain.ImportProductInterface;
import microservice.model.ImportBill;
import microservice.model.ImportDetail;
import org.springframework.stereotype.Service;

@Service
public class ImportBillService extends AbsService implements ImportProductInterface, DeleteSupplierInterface {
    private static final String DELETE_IMPORT_BILL_BY_SUPPLIER_API
            = ServiceURL.IMPORT_DETAIL_SERVICE_URL + "/by-supplier/delete";
    private static final String SAVE_IMPORT_BILL_API
            = ServiceURL.IMPORT_BILL_SERVICE_URL;
    @Override
    public boolean delete(Long supplierId) {
        Integer response = rest.postForObject(DELETE_IMPORT_BILL_BY_SUPPLIER_API, supplierId, Integer.class);
        return response == 1;
    }
    @Override
    public boolean save(ImportBill importBill) {
        ImportBill response = rest.postForObject(SAVE_IMPORT_BILL_API, importBill, ImportBill.class);
        importBill.setId(response.getId());
        for (ImportDetail detail:importBill.getDetails()){
            detail.setImportBill(importBill);
        }
        return true;
    }
}
