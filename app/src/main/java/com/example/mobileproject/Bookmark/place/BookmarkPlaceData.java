package com.example.mobileproject.Bookmark.place;

public class BookmarkPlaceData {
    private String placeName;
    private String placeLocation;
    private int placeImageView;
    private String placeKategorie;

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getPlaceLocation() {
        return placeLocation;
    }

    public void setPlaceLocation(String placeLocation) {
        this.placeLocation = placeLocation;
    }

    public int getPlaceImageView() {
        return placeImageView;
    }

    public void setPlaceImageView(int placeImageView) {
        this.placeImageView = placeImageView;
    }

    public String getPlaceKategorie() {
        return placeKategorie;
    }

    public void setPlaceKategorie(String placeKategorie) {
        this.placeKategorie = placeKategorie;
    }

    public BookmarkPlaceData(String placeName, String placeLocation, int placeImageView, String placeKategorie) {
        this.placeName = placeName;
        this.placeLocation = placeLocation;
        this.placeImageView = placeImageView;
        this.placeKategorie = placeKategorie;
    }
}
