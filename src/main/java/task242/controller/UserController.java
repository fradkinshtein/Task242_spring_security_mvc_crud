package task242.controller;

import java.security.Principal;

import task242.model.User;
import task242.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/admin/list_users")
    public String viewUsersList(Model model, Principal principal) {
        model.addAttribute("allUsers", userService.findAllUsers());
        model.addAttribute("allRoles", userService.findAllRoles());
        model.addAttribute("currentUser", userService.findByUsername(principal.getName()));
        return "users";
    }

    @GetMapping("/")
    public String login() {
        return "index";
    }

    @GetMapping("/user")
    public String showUserPage(Model model, Principal principal) {
        model.addAttribute("currentUser", userService.findByUsername(principal.getName()));
        return "user";
    }

    @GetMapping("/admin/new")
    public String addUserPage(@ModelAttribute("user") User user, Model model) {
        model.addAttribute("allRoles", userService.findAllRoles());
        return "new_user";
    }

    @PostMapping("/adduser")
    public String addUser(@ModelAttribute("user") User user, @RequestParam("role_select") Long[] roles ){
        userService.setRolesToUser(user, roles);
        userService.addUser(user);
        return "redirect:/admin/list_users";
    }

    @GetMapping("admin/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model, Principal principal) {
        model.addAttribute("allRoles", userService.findAllRoles());
        model.addAttribute("userRoles", userService.getRoleById(id));
        model.addAttribute("user", userService.findById(id));
        model.addAttribute("currentUser", userService.findByUsername(principal.getName()));
        return "/user_form";
    }

    @PostMapping("/admin/update/{id}")
    public String updateUser(@ModelAttribute("user") User user, @RequestParam("role_select") Long[] roles) {
        userService.setRolesToUser(user, roles);
        userService.updateUser(user);
        return "redirect:/admin/list_users";
    }

    @GetMapping("admin/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.deleteById(id);
        return "redirect:/admin/list_users";
    }
}