package com.example.examenfinal.resource;


import com.example.examenfinal.entity.Lugar;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class HotelResource {



    private Long id;


    private String nombre;




    private Lugar lugar;


}
