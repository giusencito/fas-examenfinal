package com.example.examenfinal.serviceImpl;


import com.example.examenfinal.entity.Hospedaje;
import com.example.examenfinal.persistence.HospedajeRepository;
import com.example.examenfinal.persistence.HotelRepository;
import com.example.examenfinal.service.HospedajeService;
import com.example.examenfinal.shared.execption.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class HospedajeServiceImpl implements HospedajeService {


    private static final String ENTITY = "Hospedaje";
    private static final String ENTITY2 = "Hotel";
    @Autowired
    private HospedajeRepository hospedajeRepository;
    @Autowired
    private HotelRepository hotelRepository;



    @Override
    public List<Hospedaje> getAllHospeajes() {
        return hospedajeRepository.findAll();
    }

    @Override
    public Page<Hospedaje> getAllHospeajes(Pageable pageable) {
        return hospedajeRepository.findAll(pageable);
    }

    @Override
    public Hospedaje getHospeajeById(Long HospeajeId) {
        return hospedajeRepository.findById(HospeajeId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, HospeajeId));
    }

    @Override
    public Hospedaje createHospeaje(Long Hotel, Long solicitudid,Date INICIO,Date termino) {
        return hotelRepository.findById(Hotel)
                .map(hotels -> {
                    Hospedaje hospedaje= new Hospedaje();
                    Date date = new Date();
                    hospedaje.setRegisterDate(date);
                    hospedaje.setHotel(hotels);
                    hospedaje.setSolicitudId(solicitudid);
                    hospedaje.setFechainicio(INICIO);
                    hospedaje.setFechatermino(termino);
                    return hospedajeRepository.save(hospedaje);
                })
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY2, Hotel));
    }
}
