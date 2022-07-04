package com.example.examenfinal.entity;

import lombok.*;
import org.hibernate.annotations.Type;
import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hospedajes")
public class Hospedaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Temporal(TemporalType.DATE)
    private Date registerDate;


    @Temporal(TemporalType.DATE)
    private Date fechainicio;


    @Temporal(TemporalType.DATE)
    private Date fechatermino;

    private Long solicitudId;


    @ManyToOne(targetEntity = Hotel.class)
    @JoinColumn(name = "hotelid")
    private Hotel hotel;

}
