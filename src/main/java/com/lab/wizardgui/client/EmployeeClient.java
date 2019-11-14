package com.lab.wizardgui.client;

import com.lab.wizardgui.domain.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class EmployeeClient {

    @Autowired
    private RestTemplate restTemplate;

    public List<EmployeeDto> getAllEmployees() {

        URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8082/lab/employees")
                .queryParam("fields", "id,firstname,lastname,licence,login,password,role")
                .build().encode().toUri();

        EmployeeDto[] response = restTemplate.getForObject(url, EmployeeDto[].class);

        if (response != null) {
            return Arrays.asList(response);
        }
        return new ArrayList<>();
    }

    public EmployeeDto getEmployee(Long id) {

        URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8082/lab/employees/" + id)
                .queryParam("fields", "id,firstname,lastname,licence,login,password,role")
                .build().encode().toUri();

        EmployeeDto response = restTemplate.getForObject(url, EmployeeDto.class);

        if (response != null) {
            return response;
        }
        return new EmployeeDto();
    }

    public EmployeeDto createNewEmployee(EmployeeDto employeeDto) {

        URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8082/lab/employees/")
                .build().encode().toUri();

        return restTemplate.postForObject(url, employeeDto, EmployeeDto.class);
    }

    public void deleteEmployee(Long id) {

        URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8082/lab/employees/" + id)
                .build().encode().toUri();

        restTemplate.delete(url);
    }


}
