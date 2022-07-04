package com.example.examenfinal.mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("HospedajeServiceServiceMappingConfiguration")
public class MappingConfiguration {


    @Bean
    public HotelMapper hotelMapper(){
        return new HotelMapper();
    }
    @Bean
    public HospedajeMapper hospedajeMapper(){ return new HospedajeMapper(); }


}
