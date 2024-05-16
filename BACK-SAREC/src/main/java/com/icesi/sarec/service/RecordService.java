package com.icesi.sarec.service;


import com.icesi.sarec.dto.RecordDTO;
import com.icesi.sarec.model.*;
import com.icesi.sarec.model.Record;
import com.icesi.sarec.repository.RecordRepository;
import com.icesi.sarec.repository.TollRepository;
import com.icesi.sarec.repository.UserRepository;
import com.icesi.sarec.repository.VehicleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;


@Service
@AllArgsConstructor
public class RecordService {
    private final RecordRepository recordRepository;
    private final TollRepository tollRepository;
    private final VehicleRepository vehicleRepository;


    public Record createRecord(RecordDTO recordDTO) {
        Record record = new Record();
        UUID uuid = UUID.randomUUID();
        Vehicle vehicle = vehicleRepository.getReferenceById(recordDTO.getVehiclePlate());
        SarecUser sarecUser = vehicle.getUser();
        Toll toll = tollRepository.getReferenceById(recordDTO.getToll());
        record.setToll(toll);
        record.setUuid(uuid);
        record.setVehicle(vehicle);
        record.setUser(sarecUser);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        record.setTimestamp(timestamp);
        record.setStatus(Status.PENDING);
        Long price = 0L;

        switch (vehicle.getAxiesAmount()){
            case 1:
                price = toll.getCategory1Price();
                sarecUser.setBalance(sarecUser.getBalance() - price);
                record.setStatus(Status.APPROVED);
                break;
            case 2:
                price = toll.getCategory2Price();
                sarecUser.setBalance(sarecUser.getBalance() - price);
                record.setStatus(Status.APPROVED);
                break;
            case 3:
                price = toll.getCategory3Price();
                sarecUser.setBalance(sarecUser.getBalance() - price);
                record.setStatus(Status.APPROVED);
                break;
            case 4:
                price = toll.getCategory4Price();
                sarecUser.setBalance(sarecUser.getBalance() - price);
                record.setStatus(Status.APPROVED);
                break;
            case 5:
                price = toll.getCategory5Price();
                sarecUser.setBalance(sarecUser.getBalance() - price);
                record.setStatus(Status.APPROVED);
                break;
            case 6:
                price = toll.getCategory6Price();
                sarecUser.setBalance(sarecUser.getBalance() - price);
                record.setStatus(Status.APPROVED);
                break;
            case 7:
                price = toll.getCategory7Price();
                sarecUser.setBalance(sarecUser.getBalance() - price);
                record.setStatus(Status.APPROVED);
                break;
        }

        return recordRepository.save(record);
    }

    public List<Record> getAllByUserEmail(String email) {
        return recordRepository.getAllByUserEmail(email);
    }
}