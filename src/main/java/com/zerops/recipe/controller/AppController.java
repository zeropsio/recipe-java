package com.zerops.recipe.controller;

import com.zerops.recipe.model.Entry;
import com.zerops.recipe.repository.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class AppController {

    @Autowired
    private EntryRepository entryRepository;

    @GetMapping("/")
    public String home() {
        String data = UUID.randomUUID().toString();
        Entry entry = new Entry(data);
        entryRepository.save(entry);
        long count = entryRepository.count();

        return String.format("This is a simple, basic Java / Spring Boot application running on Zerops.io, " +
                "each request adds an entry to the PostgreSQL database and returns a count. " +
                "See the source repository (https://github.com/zeropsio/recipe-java) for more information. New entry: %s, Count: %d", data, count);
    }

    @GetMapping("/status")
    public String status() {
        return "UP";
    }
}
