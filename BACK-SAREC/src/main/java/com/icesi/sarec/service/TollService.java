package com.icesi.sarec.service;

import com.icesi.sarec.dto.TollDTO;
import com.icesi.sarec.mapper.TollMapper;
import com.icesi.sarec.model.Toll;
import com.icesi.sarec.repository.TollRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TollService {

    private final TollMapper tollMapper;
    private final TollRepository tollRepository;

    public Toll createToll(TollDTO tollDTO){
        Toll toll = tollMapper.fromTollDto(tollDTO);
        toll.setUuid(UUID.randomUUID());
        return tollRepository.save(toll);
    }

    public List<Toll> getAll(){
        return tollRepository.findAll();
    }

}
