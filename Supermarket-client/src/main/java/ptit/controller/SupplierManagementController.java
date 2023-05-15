package ptit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ptit.model.Supplier;
import ptit.service.SupplierService;
import ptit.service.WarehouseService;

@Controller
@RequestMapping("/warehouse/management/supplier")
public class SupplierManagementController {
    private final SupplierService supplierService;
    private final WarehouseService warehouseService;

    @Autowired
    public SupplierManagementController(SupplierService supplierService, WarehouseService warehouseService) {
        this.supplierService = supplierService;
        this.warehouseService = warehouseService;
    }

    @GetMapping
    public String showMainView(@RequestParam(name = "searchKey", required = false) String searchKey, Model model) {
        if (searchKey == null){
            model.addAttribute("suppliers", supplierService.getAll());
        }
        else {
            model.addAttribute("searchKey", searchKey);
            model.addAttribute("suppliers", supplierService.getByNameContains(searchKey));
        }
        return "warehouse/management/supplier/SupplierManagement";
    }
    @GetMapping("/new")
    public String showAddView(Model model) {
        model.addAttribute("supplier", new Supplier());
        return "warehouse/management/supplier/SupplierDetail";
    }
    @GetMapping("/edit/{id}")
    public String showEditView(@PathVariable("id") Long id, Model model) {
        model.addAttribute("supplier", supplierService.getById(id));
        return "warehouse/management/supplier/SupplierDetail";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("supplier") Supplier supplier) {
        supplierService.save(supplier);
        return "redirect:/warehouse/management/supplier";
    }
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        warehouseService.deleteSupplier(id);
        return "redirect:/warehouse/management/supplier";
    }
}
