package ru.grakovich.spring_boot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.grakovich.spring_boot.models.User;
import ru.grakovich.spring_boot.service.UserService;


import javax.validation.Valid;

@Controller
@RequestMapping
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("users", userService.allUser());
        return "index";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "newUser";
    }

    @PostMapping
    public String creatUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "newUser";
        }
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/user/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "userUpdate";
    }


    @PostMapping("/{id}")
    public String update(@PathVariable("id") Long id, @RequestParam("name") String name,
                         @RequestParam("lastName") String lastName, @RequestParam("age") Integer age) {
        userService.update(id, name, lastName, age);
        return "redirect:/";
    }

    @PostMapping("/user/{id}")
    public String deleteUser(@PathVariable("id") Long Id) {
        userService.delete(Id);
        return "redirect:/";
    }
}
