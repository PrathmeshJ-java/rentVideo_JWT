package com.prathamesh.rentVideo_Advanced.Dtos;

public class RentalRequest {

    private Long videoId;
    private Long userId;

    public Long getVideoId() {
        return videoId;
    }

    public void setVideoId(Long videoId) {
        this.videoId = videoId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public RentalRequest(Long videoId, Long userId) {
        this.videoId = videoId;
        this.userId = userId;
    }
}
