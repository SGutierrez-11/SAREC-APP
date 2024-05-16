package com.icesi.sarec.api;

import com.icesi.sarec.dto.TollDTO;
import com.icesi.sarec.model.Toll;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/toll")
public interface TollApi {

    @PostMapping("/new")
    Toll createToll(@Valid @RequestBody TollDTO tollDTO);

    @GetMapping("/get/all")
    List<Toll> getAllTolls();

}
