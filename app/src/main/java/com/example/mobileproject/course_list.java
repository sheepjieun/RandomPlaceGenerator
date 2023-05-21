package com.example.mobileproject;


public class course_list {

    private String course_key;
    private String course_name;


    public course_list(String course_key, String course_name) {
        this.course_key = course_key;
        this.course_name = course_name;
    }

    public String getCourse_key() {
        return course_key;
    }

    public void setCourse_key(String course_key) {
        this.course_key = course_key;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }
}
