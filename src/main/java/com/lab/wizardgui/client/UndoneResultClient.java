package com.lab.wizardgui.client;

import com.lab.wizardgui.domain.UndoneResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class UndoneResultClient {

    @Autowired
    private RestTemplate restTemplate;

    public List<UndoneResultDto> getAllUndone() {

        URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8082/lab/undone")
                .queryParam("fields", "id,firstname,lastname,pesel,material,receiveDate")
                .build().encode().toUri();

        UndoneResultDto[] response = restTemplate.getForObject(url, UndoneResultDto[].class);

        if (response != null) {
            return Arrays.asList(response);
        }
        return new ArrayList<>();
    }

    public UndoneResultDto getUndone(Long id) {

        URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8082/lab/undone/" + id)
                .queryParam("fields", "id,firstname,lastname,pesel,material,receiveDate")
                .build().encode().toUri();

        UndoneResultDto response = restTemplate.getForObject(url, UndoneResultDto.class);

        if (response != null) {
            return response;
        }
        return new UndoneResultDto();
    }

    public UndoneResultDto createUndone(UndoneResultDto undoneResultDto) {

        URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8082/lab/undone/")
                .build().encode().toUri();

        return restTemplate.postForObject(url, undoneResultDto, UndoneResultDto.class);
    }

    public void editUndone(UndoneResultDto undoneResultDto) {

        URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8082/lab/undone/")
                .build().encode().toUri();

        restTemplate.put(url, undoneResultDto);
    }

    public void deleteUndone(Long id) {

        URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8082/lab/undone/" + id)
                .build().encode().toUri();

        restTemplate.delete(url);
    }

}
