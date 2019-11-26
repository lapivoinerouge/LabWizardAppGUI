package com.lab.wizardgui.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UndoneResultDto {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("firstname")
    private String firstname;
    @JsonProperty("lastname")
    private String lastname;
    @JsonProperty("pesel")
    private String pesel;
    @JsonProperty("material")
    private String material;
    @JsonProperty("receiveDate")
    private LocalDate receiveDate;
    @JsonProperty("done")
    private boolean done;

    public UndoneResultDto(String firstname, String lastname, String pesel, String material) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.pesel = pesel;
        this.material = material;
        this.receiveDate = LocalDate.now();
        this.done = false;
    }
}
