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
import java.util.stream.Collectors;

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

    public List<PatientDto> findPatientsByLastname(String lastname) {

        URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8082/lab/patients")
                .queryParam("fields", "id,firstname,lastname,pesel,email,password")
                .build().encode().toUri();

        PatientDto[] response = restTemplate.getForObject(url, PatientDto[].class);

        List<PatientDto> list = Arrays.stream(response)
                .filter(patientDto -> patientDto.getLastname().contains(lastname))
                .collect(Collectors.toList());

        if (list != null) {
            return list;
        }
        return new ArrayList<>();
    }

//    public PatientDto getPatientByPesel(String pesel) {
//
//        URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8082/lab/patients")
//                .queryParam("fields", "id,firstname,lastname,pesel,email,password")
//                .build().encode().toUri();
//
//        PatientDto[] response = restTemplate.getForObject(url, PatientDto[].class);
//
//        List<PatientDto> list = Arrays.stream(response)
//                .filter(patientDto -> patientDto.getLastname().equals(pesel))
//                .collect(Collectors.toList());
//
//        if (list != null) {
//            return list.get(0);
//        }
//        return null;
//    }

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

    public void editPatient(PatientDto patientDto) {

        URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8082/lab/patients/")
                .build().encode().toUri();

        restTemplate.put(url, patientDto);
    }

    public void deletePatient(Long id) {

        URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8082/lab/patients/" + id)
                .build().encode().toUri();

        restTemplate.delete(url);
    }
}
