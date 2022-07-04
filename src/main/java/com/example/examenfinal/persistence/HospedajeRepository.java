package com.example.examenfinal.persistence;


import com.example.examenfinal.entity.Hospedaje;
import com.example.examenfinal.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospedajeRepository extends JpaRepository<Hospedaje,Long> {



}
