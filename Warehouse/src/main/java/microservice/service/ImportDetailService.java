package microservice.service;

import microservice.controller.chain.DeleteSupplierInterface;
import microservice.controller.chain.ImportProductInterface;
import microservice.model.ImportBill;
import microservice.model.ImportDetail;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Date;

@Service
public class ImportDetailService extends AbsService implements ImportProductInterface, DeleteSupplierInterface {
    private static final String DELETE_IMPORT_DETAILS_BY_SUPPLIER_API
            = ServiceURL.IMPORT_DETAIL_SERVICE_URL + "/by-supplier/delete";
    private static final String SAVE_IMPORT_DETAILS_API
            = ServiceURL.IMPORT_DETAIL_SERVICE_URL + "/by-bill/save";
    @Override
    public boolean delete(Long supplierId) {
        rest.postForObject(
                DELETE_IMPORT_DETAILS_BY_SUPPLIER_API,
                supplierId,
                Integer.class);
        return true;
    }
    @Override
    public boolean save(ImportBill importBill) {
        Integer response = rest.postForObject(
                SAVE_IMPORT_DETAILS_API,
                importBill,
                Integer.class);
        return response == importBill.getDetails().size();
    }
}
