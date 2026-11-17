package com.tourism.api.controller;

import com.tourism.api.security.JwtService;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final JwtService jwtService;
    public AuthController(JwtService jwtService) { this.jwtService = jwtService; }

    // Demo-only token issuer. Replace with real user authentication before production.
    @PostMapping("/token")
    public Map<String, String> token(@RequestBody Map<String, String> body) {
        String username = body.getOrDefault("username", "dashboard-user");
        return Map.of("token", jwtService.generateToken(username), "tokenType", "Bearer");
    }
}
