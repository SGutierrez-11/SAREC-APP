package com.icesi.sarec.api;

import com.icesi.sarec.dto.RecordDTO;
import com.icesi.sarec.model.Record;
import jakarta.validation.Valid;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/record")
public interface RecordApi {
    @PostMapping("/new")
    Record createRecord(@Valid @RequestBody RecordDTO recordDTO);

    @GetMapping("/get/all-by-user")
    List<Record> getRecordsByUser(@Valid @ParameterObject String userEmail);

}
