package com.icesi.sarec.controller;

import com.icesi.sarec.api.TollApi;
import com.icesi.sarec.dto.TollDTO;
import com.icesi.sarec.model.Toll;
import com.icesi.sarec.service.TollService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class TollController implements TollApi {

    private final TollService tollService;

    @Override
    public Toll createToll(TollDTO tollDTO) {
        return tollService.createToll(tollDTO);
    }

    @Override
    public List<Toll> getAllTolls() {
        return tollService.getAll();
    }
}
