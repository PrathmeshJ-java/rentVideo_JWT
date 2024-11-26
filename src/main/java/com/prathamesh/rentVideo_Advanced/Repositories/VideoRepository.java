package com.prathamesh.rentVideo_Advanced.Repositories;

import com.prathamesh.rentVideo_Advanced.Entities.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {

    List<Video> findByAvailability(Boolean availability);
}
