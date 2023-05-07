package microservice.service;

import microservice.controller.chain.DeleteSupplierInterface;
import microservice.controller.chain.ImportProductInterface;
import microservice.model.ImportBill;
import org.springframework.stereotype.Service;

@Service
public class ImportDetailService extends AbsService implements ImportProductInterface, DeleteSupplierInterface {
    private static final String DELETE_IMPORT_DETAILS_BY_SUPPLIER_API
            = ServiceURL.IMPORT_DETAIL_SERVICE_URL + "/by-supplier/delete";
    private static final String SAVE_IMPORT_DETAILS_API
            = ServiceURL.IMPORT_DETAIL_SERVICE_URL + "/by-bill/save";
    @Override
    public boolean delete(Long supplierId) {
        Integer response = rest.postForObject(
                DELETE_IMPORT_DETAILS_BY_SUPPLIER_API,
                supplierId,
                Integer.class);
        return response == 1;
    }
    @Override
    public boolean save(ImportBill importBill) {
        Integer response = rest.postForObject(
                SAVE_IMPORT_DETAILS_API,
                importBill.getDetails(),
                Integer.class);
        return response == importBill.getDetails().size();
    }
}
