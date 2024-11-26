package com.prathamesh.rentVideo_Advanced.Services;

import com.prathamesh.rentVideo_Advanced.Entities.Video;
import com.prathamesh.rentVideo_Advanced.Repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VideoService {

    @Autowired
    private VideoRepository videoRepository;

    public List<Video> getAllAvailableVideos() {
        return videoRepository.findByAvailability(true);
    }

    public Video addVideo(Video video) {
        return videoRepository.save(video);
    }
}
