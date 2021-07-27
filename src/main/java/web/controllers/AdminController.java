package web.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.models.Role;
import web.models.User;
import web.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin/")
public class AdminController {

    private final UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("users")
    public String index(Model model) {
        model.addAttribute("users", userService.index());
        return "index";
    }

    @GetMapping("users/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.show(id));
        model.addAttribute("role", userService.findRoleById(id));
        return "show";
    }

    @GetMapping("new")
    public String newPerson(@ModelAttribute("user") User user,
                            Model model) {
        model.addAttribute("roleAdmin", userService.findRoleById(1));
        model.addAttribute("roleUser", userService.findRoleById(2));
        return "new";
    }

    @PostMapping("/users")
    public String create(@ModelAttribute("user") @Valid User user,
                         BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("roleAdmin", userService.findRoleById(1));
            model.addAttribute("roleUser", userService.findRoleById(2));
            return "new";
        }
        userService.save(user);
        return "redirect:/admin/users";
    }

    @GetMapping("users/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.show(id));
        model.addAttribute("roleAdmin", userService.findRoleById(1));
        model.addAttribute("roleUser", userService.findRoleById(2));
        return "edit";
    }

    @PatchMapping("users/{id}")
    public String update(@ModelAttribute("user") @Valid User user,
                         BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("roleAdmin", userService.findRoleById(1));
            model.addAttribute("roleUser", userService.findRoleById(2));
            return "edit";
        }
        userService.update(user);
        return "redirect:/admin/users";
    }

    @DeleteMapping("users/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/admin/users";
    }

}
