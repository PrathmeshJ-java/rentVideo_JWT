package com.prathamesh.rentVideo_Advanced.Controllers;

import com.prathamesh.rentVideo_Advanced.Dtos.VideoRequest;
import com.prathamesh.rentVideo_Advanced.Dtos.VideoResponse;
import com.prathamesh.rentVideo_Advanced.Entities.Video;
import com.prathamesh.rentVideo_Advanced.Services.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class VideoController {

    @Autowired
    private VideoService videoService;

    @GetMapping
    public ResponseEntity<List<Video>> getAllVideos() {
        return ResponseEntity.ok(videoService.getAllAvailableVideos());
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Video> createVideo(@RequestBody Video video) {
        return ResponseEntity.ok(videoService.addVideo(video));
    }


}
