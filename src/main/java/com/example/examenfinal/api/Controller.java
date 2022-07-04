package com.example.examenfinal.api;

import com.example.examenfinal.entity.Hospedaje;
import com.example.examenfinal.entity.Hotel;
import com.example.examenfinal.mapper.HospedajeMapper;
import com.example.examenfinal.mapper.HotelMapper;
import com.example.examenfinal.resource.CreateHospedajeREsource;
import com.example.examenfinal.resource.CreateHotelResource;
import com.example.examenfinal.resource.HospedajeResource;
import com.example.examenfinal.resource.HotelResource;
import com.example.examenfinal.service.HospedajeService;
import com.example.examenfinal.service.HotelService;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@RestController
@RequestMapping("/api/v1/hospedaje")
public class Controller {

    @Autowired
    private HospedajeService hospedajeService;


    @Autowired
    private HotelService hotelService;

    @Autowired
    private HotelMapper hotelMapper;

    @Autowired
    private HospedajeMapper hospedajeMapper;

    @Autowired
    private ModelMapper mapping;


    @ApiOperation(value = "Get all Hotels",notes = "Este consulta consiste en obtener hoteles")
    @GetMapping("/hoteles")
    public Page<HotelResource> getAllhoteles(Pageable pageable) {
        return hotelMapper.modelListToPage(hotelService.getAll(), pageable);
    }
    @ApiOperation(value = "Get all Hotels",notes = "Este consulta consiste en obtener hospedajes")
    @GetMapping("/hospedajes")
    public Page<HospedajeResource> getAllhospedajes(Pageable pageable) {
        return hospedajeMapper.modelListToPage(hospedajeService.getAllHospeajes(), pageable);
    }

    @ApiOperation(value = "createhotel",notes = "Este consulta consiste en crear hoteles s necesario que colocar un lugar como parametro")
    @PostMapping("/lugar/{lugar}/hoteles")
    public ResponseEntity<HotelResource> createhotel(@PathVariable String lugar,@RequestBody CreateHotelResource request) {
        Hotel event = mapping.map(request, Hotel.class);
        return ResponseEntity.ok(mapping.map(hotelService.create(event, lugar), HotelResource.class));
    }

    @ApiOperation(value = "createhospedaje",notes = "Este consulta consiste en crear hospdajes e necesario que colocar el id de hotel , ide de solicitud ,fecha de inicio y termmino ne el modo dd-MM-yyyy")
    @PostMapping("/hotel/{hotelid}/solicitud/{solicitudid}/hospedajes/Inicio/{inicio}/termino/{termino}/hospedajes")
    public ResponseEntity<HospedajeResource> createhospedaje(@PathVariable Long hotelid,@PathVariable Long solicitudid,@PathVariable String inicio,@PathVariable String termino) throws ParseException {

        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Date dataFormateada1 = format.parse(inicio);
        Date dataFormateada2 = format.parse(termino);
        return ResponseEntity.ok(mapping.map(hospedajeService.createHospeaje(hotelid,solicitudid,dataFormateada1,dataFormateada2), HospedajeResource.class));
    }










}
