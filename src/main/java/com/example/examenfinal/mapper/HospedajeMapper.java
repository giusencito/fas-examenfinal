package com.example.examenfinal.mapper;
import com.example.examenfinal.entity.Hospedaje;
import com.example.examenfinal.resource.CreateHospedajeREsource;
import com.example.examenfinal.resource.HospedajeResource;
import com.example.examenfinal.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;
public class HospedajeMapper {



    @Autowired
    EnhancedModelMapper mapper;

    public HospedajeResource toResource(Hospedaje model) {
        return mapper.map(model, HospedajeResource.class);
    }

    public Page<HospedajeResource> modelListToPage(List<Hospedaje> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, HospedajeResource.class), pageable, modelList.size());
    }

    public Hospedaje toModel(CreateHospedajeREsource resource) {
        return mapper.map(resource, Hospedaje.class);
    }



}
