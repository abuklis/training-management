package by.bsu.trainingmanagement.controller;

import by.bsu.trainingmanagement.entity.User;
import by.bsu.trainingmanagement.service.IUserService;
import by.bsu.trainingmanagement.service.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by anyab on 09.12.2017.
 */
@RestController
@RequestMapping(value = "/api")
@CrossOrigin(value = "http://localhost:4200")
public class UserController {
    private final IUserService service;

    @Autowired
    public UserController(IUserService service) {
        this.service = service;
    }

    @PostMapping(value = "/registration")
    public void register(@RequestBody UserDTO userDTO){
        service.registerUser(userDTO);
    }

    @GetMapping(value = "/users")
    public List<User> viewAllUsers(){
        return service.viewAllUsers();
    }

    @GetMapping(value = "/user")
    public User findUser(@RequestParam(value = "email") String email){
        return service.findUser(email);
    }

    @GetMapping(value = "/users/{id}")
    public User viewUserInfo(@PathVariable("id") int userId){
        return service.viewUserInfo(userId);
    }

}
