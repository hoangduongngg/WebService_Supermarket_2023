package ptit.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class ClientController {
    @GetMapping("/warehouse")
    public String showWarehouseHome(){
        return "warehouse/WarehouseHome";
    }
    @GetMapping("/statistic")
    public String showStatisticView(){
        return "statistic/Statistic";
    }
}
