package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.userService.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller

public class PeopleController {

    private final UserService userService;


    public PeopleController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getAllPeople(Model model) {
        List<User> list = userService.getAllPeople();
        model.addAttribute("allPeople", list);
        return "allPeople";
    }

    @GetMapping("/{id}")
    public String showUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", userService.getById(id));
        return "showUser";
    }

    @GetMapping("/addNewUser")
    public String addNewUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "addUser";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", userService.getById(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String update (@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userService.updateUser(id,user);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String delete (@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

}
