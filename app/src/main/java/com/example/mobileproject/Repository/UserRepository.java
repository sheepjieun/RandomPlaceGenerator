package com.example.mobileproject.Repository;

public interface UserRepository {
    void findUserByField(String field, String value, String getField,UserRepositoryCallback callback);
}
