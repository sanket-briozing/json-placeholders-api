package com.briozing.automation.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AllUsersDTO {

    public Integer id;

    public String name;

    public String username;

    public String email;

    public Address address;

    public String phone;

    public String website;

    public Company company;
}