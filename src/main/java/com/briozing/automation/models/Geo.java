package com.briozing.automation.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Geo {

    public String lat;

    public String lng;
}