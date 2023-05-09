package ptit.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ptit.model.Manager;
import ptit.model.User;
import ptit.model.WarehouseWorker;

@Controller
@RequestMapping
public class ClientController {
    @GetMapping("/warehouse")
    public String showWarehouseHome(HttpSession session){
        User user = (User) session.getAttribute("user");
        if (user == null || user instanceof Manager){
            WarehouseWorker warehouseWorker = new WarehouseWorker();
            warehouseWorker.setId(1L);
            warehouseWorker.setName("Tran Quang Hung");
            session.setAttribute("user", warehouseWorker);
        }
        return "warehouse/WarehouseHome";
    }
    @GetMapping("/statistic")
    public String showManagerView(HttpSession session){
        User user = (User) session.getAttribute("user");
        if (user == null || user instanceof WarehouseWorker){
            Manager manager = new Manager();
            manager.setId(2L);
            manager.setName("Tran Quang Hung");
            session.setAttribute("user", manager);
        }
        return "statistic/Statistic";
    }
}
