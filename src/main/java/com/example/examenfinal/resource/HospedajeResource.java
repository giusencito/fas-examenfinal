package com.example.examenfinal.resource;


import com.example.examenfinal.entity.Hotel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
public class HospedajeResource {



    private Long id;



    private Date registerDate;



    private Date fechainicio;



    private Date fechatermino;



    private Long solicitudId;



    private HotelResource hotel;




}
