package com.example.examenfinal.serviceImpl;


import com.example.examenfinal.entity.Hotel;
import com.example.examenfinal.entity.Lugar;
import com.example.examenfinal.persistence.HotelRepository;
import com.example.examenfinal.service.HotelService;
import com.example.examenfinal.shared.execption.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    private static final String ENTITY = "Hotel";


    @Autowired
    private HotelRepository hotelRepository;


    @Override
    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    @Override
    public Page<Hotel> getAll(Pageable pageable) {
        return hotelRepository.findAll(pageable);
    }

    @Override
    public Hotel getById(Long hotel) {
        return hotelRepository.findById(hotel)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, hotel));
    }

    @Override
    public Hotel create(Hotel hotel, String lugar) {
        hotel.setLugar(Enum.valueOf(Lugar.class,lugar));
        return hotelRepository.save(hotel);
    }
}
