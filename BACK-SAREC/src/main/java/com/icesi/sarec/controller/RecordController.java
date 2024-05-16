package com.icesi.sarec.controller;


import com.icesi.sarec.api.RecordApi;
import com.icesi.sarec.dto.RecordDTO;
import com.icesi.sarec.observer.MqttMessageObserver;
import com.icesi.sarec.service.RecordService;
import com.icesi.sarec.service.SMSService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import com.icesi.sarec.model.Record;

import java.util.List;


@AllArgsConstructor
@RestController
public class RecordController implements RecordApi, MqttMessageObserver {
    private final RecordService recordService;
    private final SMSService smsService;


    @Override
    public Record createRecord(RecordDTO recordDTO) {
        return recordService.createRecord(recordDTO);
    }

    @Override
    public List<Record> getRecordsByUser(String userEmail) {
        return recordService.getAllByUserEmail(userEmail);
    }

    @Override
    public void onMqttMessageReceived(RecordDTO recordDTO) {
        System.out.println("Registro recibido");
        Record record = recordService.createRecord(recordDTO);

        String name = record.getUser().getName();
        String plate = record.getVehicle().getPlate();
        String time = record.getTimestamp().toString();

        String mensaje = "¡Hola " + name + "! Tu registro con ID " + record.getUuid() + " ha sido creado con éxito para el vehículo con placa " + plate + " a las " + time + ". ¡Viaje seguro!";

        smsService.sendSMSMessage(mensaje, record.getUser().getPhoneNumber());
    }

}