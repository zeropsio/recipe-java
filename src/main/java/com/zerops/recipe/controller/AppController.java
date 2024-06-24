package com.zerops.recipe.controller;

import com.zerops.recipe.model.Entry;
import com.zerops.recipe.model.ApiResponse;
import com.zerops.recipe.repository.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

@RestController
public class AppController {

    @Autowired
    private EntryRepository entryRepository;

    @GetMapping("/")
    public ResponseEntity<ApiResponse> home() {
        String data = UUID.randomUUID().toString();
        Entry entry = new Entry(data);
        entryRepository.save(entry);
        long count = entryRepository.count();

        String message = "This is a simple, basic Java / Spring Boot application running on Zerops.io, " +
                "each request adds an entry to the PostgreSQL database and returns a count. " +
                "See the source repository (https://github.com/zeropsio/recipe-java) for more information.";

        ApiResponse response = new ApiResponse(message, data, count);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/status")
    public ResponseEntity<String> status() {
        return ResponseEntity.ok("UP");
    }
}
