package com.example.mobileproject.Repository;

public interface FindFiledCallback {
    void onUserFound(String foundField);
    void onUserNotFound(String errorMessage);
}
