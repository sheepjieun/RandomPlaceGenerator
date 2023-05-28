package com.example.mobileproject.Repository;

public interface UserRepositoryCallback {
    void onUserFound(String foundField);
    void onUserNotFound(String errorMessage);
}
