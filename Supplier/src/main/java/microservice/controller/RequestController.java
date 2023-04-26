package microservice.controller;

import microservice.model.Supplier;
import microservice.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class RequestController {
    private SupplierRepository supplierRepository;

    @Autowired
    public RequestController(SupplierRepository supplierRepository){
        this.supplierRepository = supplierRepository;
    }

    @GetMapping
    public List<Supplier> getAllSupplier(){
        return supplierRepository.findAll();
    }

    @GetMapping("search")
    public List<Supplier> searchSupplier(@RequestParam("keyword") String keyword){
        return supplierRepository.findByNameContains(keyword);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Supplier newSupplier(@RequestBody Supplier supplier) {
        System.out.println(supplier.getId());
        System.out.println(supplier.getName());
        System.out.println(supplier.getDescription());
        System.out.println(supplier.getPhoneNumber());
        return supplierRepository.save(supplier);
    }
}
