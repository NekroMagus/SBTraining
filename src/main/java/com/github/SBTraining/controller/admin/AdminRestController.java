package com.github.SBTraining.controller.admin;


import com.github.SBTraining.model.User;
import com.github.SBTraining.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.logging.Logger;


/**
 * @author Egor Odintsov
 */

@RestController
public class AdminRestController {

    static Logger log = Logger.getLogger(AdminRestController.class.getName());

    @Autowired
    private UserService userService;

    /**
     * Method which returns all Users
     * @return responseEntity object which contains list of all users and http status
     */

    @GetMapping("/admin/getAllUsers")
    public ResponseEntity getAllUsers() {
        List<User> listUsers = userService.getAllUsers();
        if(!listUsers.isEmpty()) {
            return new ResponseEntity(listUsers, HttpStatus.OK);
        }
        else {
            log.severe("list of users is empty");
            return new ResponseEntity("list of users is empty",HttpStatus.OK);
        }
    }

    /**
     * Method which delete all Users
     * @return responseEntity object which contains message and http status
     */

    @DeleteMapping("/admin/deleteAllUsers")
    public ResponseEntity deleteAllUsers() {
        userService.deleteAllUsers();
        log.info("All users deleted");
        return new ResponseEntity("All users deleted" , HttpStatus.OK);
    }

}
