package com.github.SBTraining.controller.authorization;


import com.github.SBTraining.dto.JwtUserReqDto;
import com.github.SBTraining.dto.TokenDto;
import com.github.SBTraining.dto.UserDto;
import com.github.SBTraining.model.User;
import com.github.SBTraining.security.jwt.JwtProvider;
import com.github.SBTraining.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Egor Odintsov
 */

@RestController
public class AuthorizationRestController {

//    static Logger log = Logger.getLogger(AuthorizationRestController.class.getName());

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private UserService userService;

    /**
     * register user
     *
     * @param user - userDto object which will register
     * @return token
     */

    @PostMapping("/registration")
    public ResponseEntity registration(@RequestBody UserDto user) {
        if (user != null) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userService.createUser(new User(user));
//            log.info("user added , user:" + user.toString());
            return null;
        } else {
//            log.severe("user equals null");
            return new ResponseEntity("user equals null", HttpStatus.OK);
        }
    }

    /**
     * authenticate user
     *
     * @param user - userDto object which will authenticate
     * @return responseEntity which contains message and http status
     */

    @PostMapping("/login")
    public ResponseEntity auth(@RequestBody UserDto user) {
        if (user != null) {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getLogin(), user.getPassword()));
//            log.info("user authenticated , user:" + user.toString());
            return new ResponseEntity("user authenticated", HttpStatus.OK);
        } else {
//            log.severe("user equals null");
            return new ResponseEntity("user equals null", HttpStatus.OK);
        }
    }

    /**
     * method create token
     * //     * @param login - login of user which will use  to create token
     *
     * @return responseEntity object , which contains token and http status
     */

    @PostMapping("/createToken")
    public TokenDto createToken(@RequestBody JwtUserReqDto user) throws Exception {
        authenticate(user.getLogin(), user.getPassword());
        final UserDetails userDetails = userDetailsService.loadUserByUsername(user.getLogin());
        final String token = jwtProvider.generateToken(userDetails);
        return new TokenDto(token);
    }


    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

}