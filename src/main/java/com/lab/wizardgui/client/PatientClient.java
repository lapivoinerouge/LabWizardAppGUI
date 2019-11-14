package com.lab.wizardgui.client;

import com.lab.wizardgui.domain.PatientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class PatientClient {

    @Autowired
    private RestTemplate restTemplate;

    public List<PatientDto> getAllPatients() {

        URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8082/lab/patients")
                .queryParam("fields", "id,firstname,lastname,pesel,email,password")
                .build().encode().toUri();

        PatientDto[] response = restTemplate.getForObject(url, PatientDto[].class);

        if (response != null) {
            return Arrays.asList(response);
        }
        return new ArrayList<>();
    }

    public PatientDto getPatient(Long id) {

        URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8082/lab/patients/" + id)
                .queryParam("fields", "id,firstname,lastname,pesel,email,password")
                .build().encode().toUri();

        PatientDto response = restTemplate.getForObject(url, PatientDto.class);

        if (response != null) {
            return response;
        }
        return new PatientDto();
    }

    public PatientDto createNewPatient(PatientDto patientDto) {

        URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8082/lab/patients/")
                .build().encode().toUri();

        return restTemplate.postForObject(url, patientDto, PatientDto.class);
    }

    public void deletePatient(Long id) {

        URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8082/lab/patients/" + id)
                .build().encode().toUri();

        restTemplate.delete(url);
    }
}
