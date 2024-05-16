package com.icesi.sarec.observer;

import com.icesi.sarec.dto.RecordDTO;

public interface MqttMessageObserver {

    void onMqttMessageReceived(RecordDTO recordDTO);
}
