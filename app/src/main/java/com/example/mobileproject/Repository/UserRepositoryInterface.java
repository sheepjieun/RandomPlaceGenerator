package com.example.mobileproject.Repository;

public interface UserRepositoryInterface {
    void findUserByField(String field, String value, String getField,UserRepositoryCallback callback);
}
