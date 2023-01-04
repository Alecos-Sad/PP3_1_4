package pp3_1_4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pp3_1_4.models.User;
import pp3_1_4.service.RoleService;
import pp3_1_4.service.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping()
    public String showUsers(@ModelAttribute("user") User user, Model model, Principal principal) {
        model.addAttribute("users", userService.findAll());
        model.addAttribute("principal", principal);
        model.addAttribute("roles", roleService.getAllRoles());
        model.addAttribute("admin", userService.findByUsername(principal.getName()));
        return "admin/myAdmin";
    }

    @PostMapping("/save")
    public String createUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/admin";
    }

    @PatchMapping("/update/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userService.update(user);
        return "redirect:/admin";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/admin";
    }
}
