package com.example.mobileproject.data;
//Firebase Firestore로부터 가져온 데이터를 애플리케이션 내부에서 사용할 수 있는 형태로 바꿈

public class BestCourse {
    //TODO 필드 목록 수정
    private String courseName;

    public BestCourse() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public BestCourse(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
