package com.lab.wizardgui.client;

import com.lab.wizardgui.domain.ResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ResultClient {

    @Autowired
    private RestTemplate restTemplate;

    public List<ResultDto> getAllResults() {

        URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8082/lab/results")
                .queryParam("fields", "id,undoneId,firstname,lastname,pesel,material,receiveDate,result,comment,employeeLicence,finishDate")
                .build().encode().toUri();

        ResultDto[] response = restTemplate.getForObject(url, ResultDto[].class);

        if (response != null) {
            return Arrays.asList(response);
        }
        return new ArrayList<>();
    }

    public List<ResultDto> getResultsByPesel(String pesel) {

        URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8082/lab/results/p/" + pesel)
                .queryParam("fields", "id,undoneId,firstname,lastname,pesel,material,receiveDate,result,comment,employeeLicence,finishDate")
                .build().encode().toUri();

        ResultDto[] response = restTemplate.getForObject(url, ResultDto[].class);

        if (response != null) {
            return Arrays.asList(response);
        }
        return new ArrayList<>();
    }

    public ResultDto getResult(Long id) {

        URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8082/lab/results/" + id)
                .queryParam("fields", "id,undoneId,firstname,lastname,pesel,material,receiveDate,result,comment,employeeLicence,finishDate")
                .build().encode().toUri();

        ResultDto response = restTemplate.getForObject(url, ResultDto.class);

        if (response != null) {
            return response;
        }
        return new ResultDto();
    }

    public ResultDto createResult(ResultDto resultDto) {

        URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8082/lab/results/")
                .build().encode().toUri();

        return restTemplate.postForObject(url, resultDto, ResultDto.class);
    }

    public void deleteResult(Long id) {

        URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8082/lab/results/" + id)
                .build().encode().toUri();

        restTemplate.delete(url);
    }

}
