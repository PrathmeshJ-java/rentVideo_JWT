package com.prathamesh.rentVideo_Advanced.Controllers;

import com.prathamesh.rentVideo_Advanced.Entities.Rental;
import com.prathamesh.rentVideo_Advanced.Services.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rentals")
public class RentalController {

    @Autowired
    private RentalService rentalService;

    @PostMapping("/{videoId}/rent")
    public ResponseEntity<Rental> rentVideo(@PathVariable Long videoId, @RequestBody Rental rental) {
        return ResponseEntity.ok(rentalService.rentVideo(videoId, rental.getUser().getEmail()));
    }

    @PostMapping("/{videoId}/return/{useremail}")
    public ResponseEntity<Rental> returnVideo(@PathVariable Long videoId, @RequestBody Rental rental) {
        return ResponseEntity.ok(rentalService.returnVideo(videoId, rental.getUser().getEmail()));
    }
}
