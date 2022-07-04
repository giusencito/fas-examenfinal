package com.example.examenfinal.service;

import com.example.examenfinal.entity.Hotel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface HotelService {
    List<Hotel> getAll();
    Page<Hotel> getAll(Pageable pageable);
    Hotel getById(Long hotel);
    Hotel create(Hotel hotel,String lugar);
}
