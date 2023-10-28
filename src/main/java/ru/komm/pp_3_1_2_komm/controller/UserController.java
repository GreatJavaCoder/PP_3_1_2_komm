package ru.komm.pp_3_1_2_komm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.komm.pp_3_1_2_komm.model.User;
import ru.komm.pp_3_1_2_komm.services.UserService;

@Controller
@RequestMapping("/usr")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) { this.userService = userService; }

    @GetMapping("/allusers")
    public String showUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "usr/allusers";
    }

    @GetMapping("/newuser")
    public String showNewUserForm(Model model) {
        model.addAttribute("user", new User());
        return "usr/newuser";
    }

    @PostMapping("/addnewuser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/usr/allusers";
    }

    @GetMapping("/personalpage")
    public String showPersonalPage(@RequestParam("id") int id, Model model) {
        model.addAttribute("person", userService.getUser(id));
        return "/usr/personalpage";
    }

    @GetMapping("/edituser")
    public String showEditUserForm(Model model, @RequestParam("id") int id) {
        model.addAttribute("user", userService.getUser(id));
        return "/usr/edituser";
    }

    @PostMapping("/personalpage")
    public String saveEditedUser(@ModelAttribute("user") User user, @RequestParam("id") int id) {
        userService.editUser(id, user);
        return "redirect:/usr/allusers";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam("id") int id) {
        userService.deleteUser(id);
        return "redirect:/usr/allusers";
    }
}
