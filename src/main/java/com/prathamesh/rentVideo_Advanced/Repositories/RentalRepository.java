package com.prathamesh.rentVideo_Advanced.Repositories;

import com.prathamesh.rentVideo_Advanced.Entities.Rental;
import com.prathamesh.rentVideo_Advanced.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {

    List<Rental> findByUserAndReturnDateIsNull(User user);
}
