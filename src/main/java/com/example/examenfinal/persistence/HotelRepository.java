package com.example.examenfinal.persistence;

import com.example.examenfinal.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HotelRepository extends JpaRepository<Hotel,Long> {
}
