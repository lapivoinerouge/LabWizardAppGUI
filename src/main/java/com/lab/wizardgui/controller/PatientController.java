package com.lab.wizardgui.controller;

import com.lab.wizardgui.client.PatientClient;
import com.lab.wizardgui.domain.PatientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lab/gui")
public class PatientController {

    @Autowired
    private PatientClient patientClient;

    @GetMapping(value = "/patients")
    public List<PatientDto> getAllPatients() {
        List<PatientDto> patients = patientClient.getAllPatients();
        return patients;
    }

    @GetMapping(value = "/patients/{id}")
    public PatientDto getPatient(@PathVariable Long id) {
        PatientDto patient = patientClient.getPatient(id);
        return patient;
    }

    @PostMapping(value = "/patients")
    public PatientDto addPatient(@RequestBody PatientDto patientDto) {
        return patientClient.createNewPatient(patientDto);
    }

    @DeleteMapping(value = "/patients/{id}")
    public void deletePatient(@PathVariable Long id) {
        patientClient.deletePatient(id);
    }
}
