package microservice.controller;

import microservice.model.ImportBill;
import microservice.repository.ImportBillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "/api/import-bill", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class ImportBillRestController {
    private ImportBillRepository importBillRepository;

    @Autowired
    public ImportBillRestController(ImportBillRepository importBillRepository){
        this.importBillRepository = importBillRepository;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ImportBill save(@RequestBody ImportBill importBill){
        return importBillRepository.save(importBill);
    }

    @PostMapping(value = "/delete/cascade", consumes = MediaType.APPLICATION_JSON_VALUE)
    public int supplierCascadeDelete(@RequestBody Map<String, Object> data) {
        Long supplierId = (Long) data.get("id");
        return (int) importBillRepository.deleteBySupplierId(supplierId);
    }
}
