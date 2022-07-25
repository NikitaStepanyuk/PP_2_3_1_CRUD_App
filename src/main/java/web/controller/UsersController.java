package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/")
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String showAllEmployee(Model model) {
        List<User> allUsers = userService.readAllUsers();
        model.addAttribute("allUser", allUsers);
        return "all-users";
    }

    @GetMapping("create")
    public String createUserForm(User user) {
        return "user-create";
    }

    @PostMapping("create")
    public String createUser(User user) {
        userService.createUser(user);
        return "redirect:/";
    }

    @DeleteMapping("delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

    @GetMapping("{id}")
    public String updateUserForm(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.readUser(id));
        return "user-update";
    }

    @PatchMapping("update")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/";
    }

}