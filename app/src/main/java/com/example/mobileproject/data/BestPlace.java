package com.example.mobileproject.data;
//Firebase Firestore로부터 가져온 데이터를 애플리케이션 내부에서 사용할 수 있는 형태로 바꿈

public class BestPlace {
    //TODO 필드 목록 수정
    private String name;
    private String url;
    private String description;

    public BestPlace() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public BestPlace(String name, String url, String description) {
        this.name = name;
        this.url = url;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getDescription() {
        return description;
    }
}
