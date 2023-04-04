package com.studi.iot.configuration.rabbitmq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.studi.iot.pojo.Ampoule;
import com.studi.iot.pojo.Temperature;
import com.studi.iot.service.AmpouleService;
import com.studi.iot.service.TemperatureService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Subscriber {

    private ObjectMapper objectMapper;

    @Autowired
    private TemperatureService temperatureService;

    @Autowired
    private AmpouleService ampouleService;

    @RabbitListener(queues="temperature")
    public void receivedTemperature(String message) {
        Temperature maTemperature = null;
            // "{ 'test':'valeur'}"
        try {
            maTemperature = objectMapper.readValue(message,Temperature.class);
        }catch (JsonProcessingException e){
            System.out.println("Le message n'est pas une temperature !");
        }

        if(maTemperature != null){
            temperatureService.createTemperature(maTemperature);
        }
    }

    @RabbitListener(queues="ampoule")
    public void receivedAmpoule(String message) {
        Ampoule monAmpoule = null;
        try {
            monAmpoule = objectMapper.readValue(message, Ampoule.class);
        }catch (JsonProcessingException e){
            System.out.println("Le message n'est pas une temperature !");
        }

        if(monAmpoule != null){
            ampouleService.createAmpoule(monAmpoule);
        }
    }
}
