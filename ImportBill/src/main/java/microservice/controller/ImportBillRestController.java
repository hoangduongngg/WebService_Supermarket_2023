package microservice.controller;

import microservice.model.ImportBill;
import microservice.repository.ImportBillRepoAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/import-bill", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class ImportBillRestController {
    private ImportBillRepoAdapter importBillRepoAdapter;

    @Autowired
    public ImportBillRestController(ImportBillRepoAdapter importBillRepoAdapter){
        this.importBillRepoAdapter = importBillRepoAdapter;
    }
    @GetMapping
    public List<ImportBill> get(){
        return importBillRepoAdapter.getAll();
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ImportBill save(@RequestBody ImportBill importBill){
        return importBillRepoAdapter.save(importBill);
    }
    @PostMapping(value = "/by-supplier/delete", consumes = MediaType.APPLICATION_JSON_VALUE)
    public long deleteAllBySupplierId(@RequestBody Long supplierId) {
        return importBillRepoAdapter.deleteAllBySupplierId(supplierId);
    }
}
