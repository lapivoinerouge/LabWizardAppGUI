package com.lab.wizardgui.controller;

import com.lab.wizardgui.client.RateClient;
import com.lab.wizardgui.domain.RateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lab/gui")
public class RateController {

    @Autowired
    private RateClient rateClient;

    @GetMapping(value = "/rates")
    public List<RateDto> getAllRates() {
        List<RateDto> rates = rateClient.getAllRates();
        return rates;
    }

    @GetMapping(value = "/rates/{id}")
    public RateDto getRates(@PathVariable Long id) {
        RateDto rate = rateClient.getRate(id);
        return rate;
    }

    @PostMapping(value = "/rates")
    public RateDto createRate(@RequestBody RateDto rateDto) {
        return rateClient.createRate(rateDto);
    }

    @DeleteMapping(value = "/rates/{id}")
    public void deleteRate(@PathVariable Long id) {
        rateClient.deleteRate(id);
    }

}
