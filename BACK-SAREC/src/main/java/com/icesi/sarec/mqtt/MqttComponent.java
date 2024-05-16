package com.icesi.sarec.mqtt;

import com.hivemq.client.mqtt.datatypes.MqttQos;
import com.hivemq.client.mqtt.mqtt5.Mqtt5BlockingClient;
import com.hivemq.client.mqtt.mqtt5.message.publish.Mqtt5Publish;
import com.icesi.sarec.controller.RecordController;
import com.icesi.sarec.dto.RecordDTO;
import com.icesi.sarec.observer.MqttMessageObserver;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.hivemq.client.mqtt.MqttGlobalPublishFilter.ALL;
import static java.nio.charset.StandardCharsets.UTF_8;


@Component
public class MqttComponent {

    @Value("${mqtt.username}")
    private String username;

    @Value("${mqtt.password}")
    private String password;

    private final Mqtt5BlockingClient mqttClient;

    private final List<MqttMessageObserver> observers = new ArrayList<>();

    @Autowired
    public MqttComponent(Mqtt5BlockingClient mqttClient, RecordController recordController) {
        this.mqttClient = mqttClient;
        addObserver(recordController);
    }


    @PostConstruct
    public void init() {
        // Connect to MQTT broker and subscribe to the specified topic
        connectAndSubscribe("sarec");

    }


    public void connectAndSubscribe(String topic) {
        // Connect to MQTT broker (using existing configuration)
        mqttClient.connectWith()
                .simpleAuth()
                .username(username)
                .password(UTF_8.encode(password))
                .applySimpleAuth()
                .send();

        System.out.println("Connected successfully to MQTT broker");

        // Subscribe to the specified topic
        mqttClient.subscribeWith()
                .topicFilter(topic)
                .qos(MqttQos.EXACTLY_ONCE)
                .send();

        System.out.println("Subscribed to topic: " + topic);

        // Set a callback for when a message is received
        mqttClient.toAsync().publishes(ALL, this::handleIncomingMessage);
    }

    public void addObserver(MqttMessageObserver observer) {
        observers.add(observer);
    }

    private void notifyObservers(String topic, String message, long timestamp) {
        UUID toll = UUID.fromString(message.split(",")[0]);
        String vehicle = message.split(",")[1];

        for (MqttMessageObserver observer : observers) {
            RecordDTO recordDTO = RecordDTO.builder()
                    .toll(toll)
                    .vehiclePlate(vehicle)
                    .timestamp(timestamp)
                    .build();
            observer.onMqttMessageReceived(recordDTO);
        }
    }

    private void handleIncomingMessage(Mqtt5Publish publish) {
        long timestamp = System.currentTimeMillis();
        String topic = publish.getTopic().toString();
        String message = UTF_8.decode(publish.getPayload().get()).toString();

        System.out.println("Received message on topic " + topic + ": " + message + " at " + timestamp);

        notifyObservers(topic, message, timestamp);
    }
}
