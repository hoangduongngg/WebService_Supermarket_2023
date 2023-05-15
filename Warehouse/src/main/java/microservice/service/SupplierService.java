package microservice.service;

import microservice.controller.chain.DeleteSupplierInterface;
import org.springframework.stereotype.Service;

@Service
public class SupplierService extends AbsService implements DeleteSupplierInterface {
    private static final String DELETE_SUPPLIER_API
            = ServiceURL.SUPPLIER_SERVICE_URL + "/delete";
    @Override
    public boolean delete(Long supplierId) {
        Integer response = rest.postForObject(DELETE_SUPPLIER_API, supplierId, Integer.class);
        return response != 0;
    }
}
