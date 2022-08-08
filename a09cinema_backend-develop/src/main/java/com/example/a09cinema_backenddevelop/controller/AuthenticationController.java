package com.example.a09cinema_backenddevelop.controller;

import com.example.a09cinema_backenddevelop.model.entity.Account;
import com.example.a09cinema_backenddevelop.model.entity.Role;
import com.example.a09cinema_backenddevelop.payload.request.SignInForm;
import com.example.a09cinema_backenddevelop.payload.request.SignUpForm;
import com.example.a09cinema_backenddevelop.payload.response.JwtResponse;
import com.example.a09cinema_backenddevelop.payload.response.ResponseMessage;
import com.example.a09cinema_backenddevelop.security.accountprincal.AccountPrinciple;
import com.example.a09cinema_backenddevelop.security.jwt.JwtProvider;
import com.example.a09cinema_backenddevelop.service.AccountService;
import com.example.a09cinema_backenddevelop.service.impl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
    @Autowired
    AccountService accountService;
    @Autowired
    RoleServiceImpl roleService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody SignInForm signInForm) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInForm.getUsername(), signInForm.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtProvider.createToken(authentication);
        AccountPrinciple accountPrinciple = (AccountPrinciple) authentication.getPrincipal();
        return ResponseEntity.ok(
                new JwtResponse(token, accountPrinciple.getFullName(), accountPrinciple.getAuthorities())
        );
    }

//    @PostMapping("/signup")
//    public ResponseEntity<?> register(@Valid @RequestBody SignUpForm signUpForm) {
//        if (accountService.existsByUsername(signUpForm.getUsername())) {
//            return new ResponseEntity<>(new ResponseMessage("Account already exists"), HttpStatus.OK);
//        }
//        if (accountService.existsByEmail(signUpForm.getEmail())) {
//            return new ResponseEntity<>(new ResponseMessage("Email already exists"), HttpStatus.OK);
//        }
//        Account account = new Account(
//                signUpForm.getName(),
//                signUpForm.getUsername(),
//                signUpForm.getEmail(),
//                passwordEncoder.encode(signUpForm.getPassword())
//        );
//
//        Set<String> strRoles = signUpForm.getRoles();
//        Set<Role> roles = new HashSet<>();
//        strRoles.forEach(role -> {
//            switch (role) {
//                case "ADMIN":
//                    try {
//                        Role adminRole = roleService.findByName("ADMIN");
//                        roles.add(adminRole);
//                    } catch (Exception e) {
//                    }
//                    break;
//                case "member":
//                    try {
//                        Role memberRole = roleService.findByName("MEMBER");
//                        roles.add(memberRole);
//                    } catch (Exception e) {
//                    }
//                    break;
//            }
//        });
//        account.setRoles(roles);
//        accountService.save(account);
//        return new ResponseEntity<>(new ResponseMessage("create success!!!"), HttpStatus.OK);
//    }
}
