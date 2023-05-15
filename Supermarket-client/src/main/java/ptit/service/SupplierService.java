package ptit.service;

import org.springframework.stereotype.Service;
import ptit.model.Supplier;

@Service
public class SupplierService extends AbsService{
    private final String SEARCH_SUPPLIER_API = ServiceURL.SUPPLIER_SERVICE_URL + "?nameContains=";
    public Supplier[] getAll(){
        return rest.getForObject(ServiceURL.SUPPLIER_SERVICE_URL, Supplier[].class);
    }
    public Supplier[] getByNameContains(String keyword){
        return rest.getForObject(SEARCH_SUPPLIER_API + keyword, Supplier[].class);
    }
    public Supplier getById(Long id){
        return rest.getForObject(ServiceURL.SUPPLIER_SERVICE_URL + "/" + id, Supplier.class);
    }
    public boolean save(Supplier supplier){
        return rest.postForObject(ServiceURL.SUPPLIER_SERVICE_URL, supplier, Supplier.class) != null;
    }
}
