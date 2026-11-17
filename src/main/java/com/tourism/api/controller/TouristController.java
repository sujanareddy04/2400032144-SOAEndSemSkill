package com.tourism.api.controller;

import com.tourism.api.model.Tourist;
import com.tourism.api.repository.TouristRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@RestController
@RequestMapping("/api/tourists")
@SecurityRequirement(name = "Bearer Authentication")
public class TouristController {
    private final TouristRepository repository;
    public TouristController(TouristRepository repository) { this.repository = repository; }

    @GetMapping
    public List<Tourist> getAllTourists() { return repository.findAll(); }

    @GetMapping("/{id}")
    public Tourist getTourist(@PathVariable Long id) { return find(id); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Tourist createTourist(@Valid @RequestBody Tourist tourist) { tourist.setEmail(tourist.getEmail().trim()); return repository.save(tourist); }

    @PutMapping("/{id}")
    public Tourist updateTourist(@PathVariable Long id, @Valid @RequestBody Tourist input) {
        Tourist existing = find(id);
        existing.setFullName(input.getFullName()); existing.setEmail(input.getEmail());
        existing.setPhone(input.getPhone()); existing.setCountry(input.getCountry());
        existing.setPreferredDestination(input.getPreferredDestination());
        return repository.save(existing);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTourist(@PathVariable Long id) { repository.delete(find(id)); }

    private Tourist find(Long id) {
        return repository.findById(id).orElseThrow(() ->
            new ResponseStatusException(HttpStatus.NOT_FOUND, "Tourist not found: " + id));
    }
}
