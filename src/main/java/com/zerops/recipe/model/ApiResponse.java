package com.zerops.recipe.model;

public class ApiResponse {
    private String message;
    private String newEntry;
    private long count;

    public ApiResponse(String message, String newEntry, long count) {
        this.message = message;
        this.newEntry = newEntry;
        this.count = count;
    }

    // Getters and setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNewEntry() {
        return newEntry;
    }

    public void setNewEntry(String newEntry) {
        this.newEntry = newEntry;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
