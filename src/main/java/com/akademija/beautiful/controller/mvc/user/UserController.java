package com.akademija.beautiful.controller.mvc.user;

import com.akademija.beautiful.entity.user.User;
import com.akademija.beautiful.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * <li>1. DispatcherServlet</li>
 * URL: http://localhost:8081/beatiful
 * <li>2. Handler Mapper</li>
 * <li>3. UserController-> viewUsers</li>
 * <li>4. ViewResolver</li>
 * <li>5. View index.html</li>
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/")
    public String viewUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("korisnici", users);
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    //http://localhost:8081/register
    @GetMapping("/register")
    public String showNewUserForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    //http://localhost:8081/saveUser
    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        try {
            String plainPassword = user.getPassword();
            String hashedPassword = passwordEncoder.encode(plainPassword);
            user.setPassword(hashedPassword);
            user.setRole("USER");
            userService.saveUser(user);
            return "redirect:/";
        } catch (Exception e) {
            return "redirect:/register?error=Bad registration";
        }
    }
}
