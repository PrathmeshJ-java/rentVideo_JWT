package com.prathamesh.rentVideo_Advanced.Services;

import com.prathamesh.rentVideo_Advanced.Entities.Rental;
import com.prathamesh.rentVideo_Advanced.Entities.User;
import com.prathamesh.rentVideo_Advanced.Entities.Video;
import com.prathamesh.rentVideo_Advanced.Repositories.RentalRepository;
import com.prathamesh.rentVideo_Advanced.Repositories.UserRepository;
import com.prathamesh.rentVideo_Advanced.Repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class RentalService {

    @Autowired
    private RentalRepository rentalRepository;

    @Autowired
    private VideoRepository videoRepository;

    @Autowired
    private UserRepository userRepository;

    public Rental rentVideo(Long videoId, String userEmail) {
        User user = userRepository.findByEmail(userEmail).orElseThrow();
        if (rentalRepository.findByUserAndReturnDateIsNull(user).size() >= 2) {
            throw new IllegalStateException("User already has 2 active rentals.");
        }

        Video video = videoRepository.findById(videoId).orElseThrow();
        if (!video.getAvailability()) {
            throw new IllegalStateException("Video is not available for rent.");
        }

        video.setAvailability(false);
        Rental rental = new Rental();
        rental.setUser(user);
        rental.setVideo(video);

        videoRepository.save(video);
        return rentalRepository.save(rental);
    }

    public Rental returnVideo(Long videoId, String userEmail) {
        Rental rental = rentalRepository.findByUserAndReturnDateIsNull(userRepository.findByEmail(userEmail).orElseThrow())
                .stream()
                .filter(r -> r.getVideo().getId().equals(videoId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No active rental found."));

        rental.setReturnDate(LocalDateTime.now());
        rental.getVideo().setAvailability(true);

        videoRepository.save(rental.getVideo());
        return rentalRepository.save(rental);
    }
}
