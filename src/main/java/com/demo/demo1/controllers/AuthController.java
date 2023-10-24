package com.demo.demo1.controllers;

import com.demo.demo1.configuration.JwtUtils;
import com.demo.demo1.configuration.UserDetailsImpl;
import com.demo.demo1.dto.LoginRequestDTO;
import com.demo.demo1.dto.UserDTO;
import com.demo.demo1.models.User;
import com.demo.demo1.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController
{
    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    @PostMapping("/sign-in")
    public ResponseEntity authenticateUser(@RequestBody LoginRequestDTO loginRequest) {

        var authentication = authenticationManager
                                            .authenticate(
                                                new UsernamePasswordAuthenticationToken(
                                                    loginRequest.getEmail(),
                                                    loginRequest.getPassword()
                                                )
                                            );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        var userDetails = (UserDetailsImpl) authentication.getPrincipal();

        var jwtCookie = jwtUtils.generateJwtCookie(userDetails);

        return ResponseEntity.ok()
                   .header("Authentication", jwtCookie.toString())
                   .build();
    }

    @PostMapping("/create-user")
    public ResponseEntity add(@RequestBody UserDTO user) {
        User newUser = userService.save(user);

        return new ResponseEntity<>(newUser.toString(), HttpStatus.OK);
    }
}
