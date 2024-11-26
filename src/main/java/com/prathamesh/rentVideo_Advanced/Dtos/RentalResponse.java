package com.prathamesh.rentVideo_Advanced.Dtos;

public class RentalResponse {

    private Long rentalId;
    private Long videoId;
    private String videoTitle;
    private Long userId;
    private String userEmail;

    public Long getRentalId() {
        return rentalId;
    }

    public void setRentalId(Long rentalId) {
        this.rentalId = rentalId;
    }

    public Long getVideoId() {
        return videoId;
    }

    public void setVideoId(Long videoId) {
        this.videoId = videoId;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public RentalResponse(Long rentalId, Long videoId, String videoTitle, Long userId, String userEmail) {
        this.rentalId = rentalId;
        this.videoId = videoId;
        this.videoTitle = videoTitle;
        this.userId = userId;
        this.userEmail = userEmail;
    }
}
