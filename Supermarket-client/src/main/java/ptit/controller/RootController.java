package ptit.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ptit.model.Manager;
import ptit.model.User;
import ptit.model.WarehouseWorker;
import ptit.service.UserService;

@Controller
@RequestMapping
@CrossOrigin("*")
public class RootController {
    private final UserService userService;

    public RootController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public String showRootView(Model model, HttpSession session){
        if (session.getAttribute("user") instanceof Manager){
            return "statistic/Statistic";
        }
        if (session.getAttribute("user") instanceof WarehouseWorker){
            return "warehouse/WarehouseHome";
        }
        model.addAttribute("user", new User());
        return "auth/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user, HttpSession session){
        User validatedUser = userService.validate(user);
        if (validatedUser != null){
            session.setAttribute("user", validatedUser);
        }
        return "redirect:";
    }

    @PostMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:";
    }
}
