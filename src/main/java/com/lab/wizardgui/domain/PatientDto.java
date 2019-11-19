package com.lab.wizardgui.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PatientDto {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("firstname")
    private String firstname;
    @JsonProperty("lastname")
    private String lastname;
    @JsonProperty("pesel")
    private String pesel;
    @JsonProperty("email")
    private String email;
    @JsonProperty("password")
    private String password;

    public PatientDto(String firstname, String lastname, String pesel, String email, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.pesel = pesel;
        this.email = email;
        this.password = password;
    }

    public PatientDto(String firstname, String lastname, String pesel, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.pesel = pesel;
        this.email = email;
    }
}
