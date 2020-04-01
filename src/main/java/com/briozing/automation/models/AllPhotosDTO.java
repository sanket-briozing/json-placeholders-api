package com.briozing.automation.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AllPhotosDTO {

    public Integer albumId;

    public Integer id;

    public String title;

    public String url;

    public String thumbnailUrl;
}