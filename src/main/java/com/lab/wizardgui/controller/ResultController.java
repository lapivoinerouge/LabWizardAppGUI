package com.lab.wizardgui.controller;

import com.lab.wizardgui.client.ResultClient;
import com.lab.wizardgui.domain.ResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lab/gui/")
public class ResultController {

    @Autowired
    private ResultClient resultClient;

    @GetMapping(value = "/results")
    public List<ResultDto> getResults() {
        List<ResultDto> results = resultClient.getAllResults();
        return results;
    }

    @GetMapping(value = "/results/p/{pesel}")
    public List<ResultDto> getResultsByPesel(@PathVariable String pesel) {
        List<ResultDto> results = resultClient.getResultsByPesel(pesel);
        return results;
    }

    @GetMapping(value = "/results/{id}")
    public ResultDto getResult(@PathVariable Long id) {
        ResultDto result = resultClient.getResult(id);
        return result;
    }

    @PostMapping(value = "/results")
    public ResultDto addResult(@RequestBody ResultDto resultDto) {
        return resultClient.createResult(resultDto);
    }

    @DeleteMapping(value = "/results/{id}")
    public void deleteResult(@PathVariable Long id) {
        resultClient.deleteResult(id);
    }
}
