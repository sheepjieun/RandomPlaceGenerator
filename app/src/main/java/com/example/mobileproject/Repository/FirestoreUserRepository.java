package com.example.mobileproject.Repository;

import android.util.Log;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

//Firestore에 대한 실제 데이터 액세스 코드를 구현
public class FirestoreUserRepository implements UserRepository {
    private FirebaseFirestore firestore;

    public FirestoreUserRepository() {
        firestore = FirebaseFirestore.getInstance();
    }

    //TODO findUserById Id 비교하는 단일 매개변수 메소드 구현
    //TODO field 1개 더 추가. 매개변수 2개로 오버라이딩


    @Override
    public void findUserByField(String field, String value, String getField, UserRepositoryCallback callback) {
        firestore.collection("UserAccount")
                .whereEqualTo(field, value)
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        QuerySnapshot querySnapshot = task.getResult();
                        if (querySnapshot != null && !querySnapshot.isEmpty()) {
                            DocumentSnapshot document = querySnapshot.getDocuments().get(0);
                            String foundField = document.getString(getField);
                            if (foundField != null) {
                                callback.onUserFound(foundField);
                            } else {
                                callback.onUserNotFound(capitalizeFirstLetter(field) + " not found");
                            }
                        } else {
                            callback.onUserNotFound("User not found");
                        }
                    } else {
                        callback.onUserNotFound("Failed to find user");
                    }
                });
    }

    //문자열의 첫 글자를 대문자로 변환
    private String capitalizeFirstLetter(String str) {
        if (str == null || str.isEmpty()) {
            return str; //str이 null이거나 비어있는 경우는 그대로 반환
        }
        char firstChar = str.charAt(0);
        if (Character.isUpperCase(firstChar)) {
            return str; //첫 글자가 이미 대문자인 경우도 그대로 반환
        } else {
            return Character.toUpperCase(firstChar) + str.substring(1); //첫 글자를 대문자로 변환한 후 나머지 문자열과 연결하여 반환
        }
    }
}
