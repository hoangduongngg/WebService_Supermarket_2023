package microservice.controller;

import microservice.model.Supplier;
import microservice.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/supplier", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class SupplierRestController {
    private SupplierRepository supplierRepository;

    @Autowired
    public SupplierRestController(SupplierRepository supplierRepository){
        this.supplierRepository = supplierRepository;
    }
    @GetMapping
    public List<Supplier> getByNameContains(@RequestParam(name = "nameContains", required = false) String keyword){
        return keyword == null ? supplierRepository.findAll() : supplierRepository.findByNameContains(keyword);
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Supplier save(@RequestBody Supplier supplier) {
        return supplierRepository.save(supplier);
    }
    @GetMapping("/{id}")
    public Supplier getById(@PathVariable("id") Long id){
        return supplierRepository.findById(id).get();
    }

    @PostMapping(value = "/delete", consumes = MediaType.APPLICATION_JSON_VALUE)
    public int delete(@RequestBody Long id) {
        supplierRepository.deleteById(id);
        return supplierRepository.existsById(id)?1:0;
    }
}
