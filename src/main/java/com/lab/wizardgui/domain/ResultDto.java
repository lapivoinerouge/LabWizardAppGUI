package com.lab.wizardgui.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultDto {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("undoneId")
    private Long undoneId;
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
    @JsonProperty("result")
    private String result;
    @JsonProperty("comment")
    private String comment;
    @JsonProperty("employeeLicence")
    private String employeeLicence;
    @JsonProperty("finishDate")
    private LocalDate finishDate;

    public String getFirstname() {
        return firstname;
    }
}
