package com.lab.wizardgui.client;

import com.lab.wizardgui.domain.RateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Component
public class RateClient {

    @Autowired
    private RestTemplate restTemplate;

    public List<RateDto> getAllRates() {

        URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8082/lab/rates")
                .queryParam("fields", "id,name,rate,comment")
                .build().encode().toUri();

        RateDto[] response = restTemplate.getForObject(url, RateDto[].class);

        if (response != null) {
            return Arrays.asList(response);
        }
        return new ArrayList<>();
    }

    public double getAverageRate() {

        URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8082/lab/rates")
                .queryParam("fields", "id,name,rate,comment")
                .build().encode().toUri();

        RateDto[] response = restTemplate.getForObject(url, RateDto[].class);

        Double avg = Arrays.stream(response)
                .mapToDouble(rateDto -> rateDto.getRate())
                .average().getAsDouble();

        return Math.round(avg * 100.0) / 100.0;
    }

    public RateDto getRate(Long id) {

        URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8082/lab/rates/" + id)
                .queryParam("fields", "id,name,rate,comment")
                .build().encode().toUri();

        RateDto response = restTemplate.getForObject(url, RateDto.class);

        if (response != null) {
            return response;
        }
        return new RateDto();
    }

    public RateDto createRate(RateDto rateDto) {

        URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8082/lab/rates/")
                .build().encode().toUri();

        return restTemplate.postForObject(url, rateDto, RateDto.class);
    }

    public void deleteRate(Long id) {

        URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8082/lab/rates/" + id)
                .build().encode().toUri();

        restTemplate.delete(url);
    }
}
