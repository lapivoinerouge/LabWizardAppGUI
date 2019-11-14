package com.lab.wizardgui.controller;

import com.lab.wizardgui.client.UndoneResultClient;
import com.lab.wizardgui.domain.UndoneResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lab/gui")
public class UndoneResultController {

    @Autowired
    private UndoneResultClient client;

    @GetMapping(value = "/undone")
    public List<UndoneResultDto> getAllUndone() {
        List<UndoneResultDto> undone = client.getAllUndone();
        return undone;
    }

    @GetMapping(value = "/undone/{id}")
    public UndoneResultDto getUndone(@PathVariable Long id) {
        UndoneResultDto undone = client.getUndone(id);
        return undone;
    }

    @PostMapping(value = "/undone")
    public UndoneResultDto createUndone(@RequestBody UndoneResultDto undoneResultDto) {
        return client.createUndone(undoneResultDto);
    }

    @DeleteMapping(value = "/undone/{id}")
    public void deleteUndone(@PathVariable Long id) {
        client.deleteUndone(id);
    }
}
