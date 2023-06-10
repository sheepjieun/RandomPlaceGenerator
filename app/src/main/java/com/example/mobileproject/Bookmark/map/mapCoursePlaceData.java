package com.example.mobileproject.Bookmark.map;

import androidx.constraintlayout.widget.ConstraintLayout;

public class mapCoursePlaceData {

    private int mapImageView;
    private String mapName;
    private String mapLocation;
    private String mapCategory;
    private ConstraintLayout mapLayout;
    private boolean mapCheck;

    public int getMapImageView() {
        return mapImageView;
    }

    public void setMapImageView(int mapImageView) {
        this.mapImageView = mapImageView;
    }

    public String getMapName() {
        return mapName;
    }

    public void setMapName(String mapName) {
        this.mapName = mapName;
    }

    public String getMapLocation() {
        return mapLocation;
    }

    public void setMapLocation(String mapLocation) {
        this.mapLocation = mapLocation;
    }

    public String getMapCategory() {
        return mapCategory;
    }

    public void setMapCategory(String mapCategory) {
        this.mapCategory = mapCategory;
    }

    public ConstraintLayout getMapLayout() {
        return mapLayout;
    }

    public void setMapLayout(ConstraintLayout mapLayout) {
        this.mapLayout = mapLayout;
    }

    public boolean isMapCheck() {
        return mapCheck;
    }

    public void setMapCheck(boolean mapCheck) {
        this.mapCheck = mapCheck;
    }

    public mapCoursePlaceData(int mapImageView, String mapName, String mapLocation, String mapCategory) {
        this.mapImageView = mapImageView;
        this.mapName = mapName;
        this.mapLocation = mapLocation;
        this.mapCategory = mapCategory;
        this.mapCheck = true;
    }
}
