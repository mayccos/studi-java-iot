package com.studi.iot.ws;

import com.studi.iot.pojo.Temperature;
import com.studi.iot.service.TemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // produit et consomme du JSON
@RequestMapping(value = "/temperature")
public class TemperatureWs {

    @Autowired
    private TemperatureService temperatureService;

    //Obtention de toutes les temperatures
    @GetMapping
    public List<Temperature> getAllTemperatures(){
        return temperatureService.getAllTemperatures();
    }


}
