package com.github.SBTraining.controller.user;

import com.github.SBTraining.exceptions.UserNotFoundException;
import com.github.SBTraining.model.Role;
import com.github.SBTraining.model.User;
import com.github.SBTraining.security.jwt.JwtTokenFilter;
import com.github.SBTraining.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.logging.Logger;

/**
 * @author Egor Odintsov
 */


@RestController
public class UserRestController {

    static Logger log = Logger.getLogger(UserRestController.class.getName());

    @Autowired
    private  JwtTokenFilter jwtTokenFilter;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService service;


    /**
     * @param user-user object that will save in data base
     * @return responseEntity object which contains message and http status
     */

    @PostMapping("/user")
    public ResponseEntity create(@RequestBody User user) {
        if(user!=null) {
            service.createUser(user);
            log.info("user created,user:" + user.toString());
            return new ResponseEntity("user created", HttpStatus.OK);
        }
        else {
            log.info("user equals null");
            return new ResponseEntity("user equals null",HttpStatus.NO_CONTENT);
        }
    }

    /**
     * @param id - user id
     * @return user object
     */

    @GetMapping("/user/{id}")
    public User find(@PathVariable("id") long id) {
        User user = service.findUser(id);
        if (user == null) {
            throw new UserNotFoundException("user not found");
        }
        return user;
    }

    /**
     * @param user - user that will update
     * @return responseEntity object which contains message and http status
     */

    @PutMapping("/user")
    public ResponseEntity update(@RequestBody User user) {
        service.update(user);
        return new ResponseEntity("user updated",HttpStatus.OK);
    }

    /**
     *
     * @param id - user id that will deleted
     * @return  responseEntity object which contains message and http status
     */

    @DeleteMapping("/user/{id}")
    public ResponseEntity delete(@PathVariable("id") long id) {
        User user = service.findUser(id);
        if (user == null) {
            throw new UserNotFoundException("user not found");
        }
        service.deleteUser(id);
        log.info("user deleted,user:" + user.toString());
        return new ResponseEntity("user deleted",HttpStatus.OK);
    }

    /**
     * return current authenticated user
     * @return responseEntity object which contains current authenticated user and http status
     */

    @GetMapping("/getCurrentUser")
    public ResponseEntity getCurrentUser() {
        Authentication authentication = jwtTokenFilter.getSecurityContext().getAuthentication();
        if(authentication!=null)
           return new ResponseEntity(service.findUserByLogin(authentication.getName()),HttpStatus.OK);
        else {
            log.severe("user not authorized");
            return new ResponseEntity("user not authorized", HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/add1")
    public void add1() {
        User user = new User();
        user.setLogin("Alee");
        user.setPassword(passwordEncoder.encode("1111"));
        user.setRole(Role.ADMIN);
        service.createUser(user);
    }

}
