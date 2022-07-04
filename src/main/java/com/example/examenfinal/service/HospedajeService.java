package com.example.examenfinal.service;

import com.example.examenfinal.entity.Hospedaje;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface HospedajeService {

    List<Hospedaje> getAllHospeajes();
    Page<Hospedaje> getAllHospeajes(Pageable pageable);
    Hospedaje getHospeajeById(Long HospeajeId);
    Hospedaje createHospeaje(Long Hotel, Long solicitudid,Date INICIO,Date termino);
}
