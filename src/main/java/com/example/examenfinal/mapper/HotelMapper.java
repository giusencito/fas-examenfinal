package com.example.examenfinal.mapper;

import com.example.examenfinal.entity.Hotel;
import com.example.examenfinal.resource.CreateHotelResource;
import com.example.examenfinal.resource.HotelResource;
import com.example.examenfinal.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class HotelMapper {

    @Autowired
    EnhancedModelMapper mapper;

    public HotelResource toResource(Hotel model) {
        return mapper.map(model, HotelResource.class);
    }

    public Page<HotelResource> modelListToPage(List<Hotel> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, HotelResource.class), pageable, modelList.size());
    }

    public Hotel toModel(CreateHotelResource resource) {
        return mapper.map(resource, Hotel.class);
    }
}
