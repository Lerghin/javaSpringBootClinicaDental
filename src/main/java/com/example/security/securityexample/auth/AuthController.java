package com.example.security.securityexample.auth;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
   @PostMapping (value= "login")
    public ResponseEntity <AuthResponse> login(@RequestBody LoginRequest request ){
       return ResponseEntity.ok(authService.login(request));
   }
    @PostMapping (value= "register/user")
    public ResponseEntity <AuthResponse> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authService.register(request));
    }
    @PostMapping (value= "register/admin")
    public ResponseEntity <AuthResponse> registerAdmin(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authService.registerAdmin(request));
    }


    SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
    @PostMapping("/logout")
    public String performLogout(Authentication authentication, HttpServletRequest request, HttpServletResponse response) {
        // .. perform logout
        this.logoutHandler.logout(request, response, authentication);
        return "Succesfullly logout";
    }




}
