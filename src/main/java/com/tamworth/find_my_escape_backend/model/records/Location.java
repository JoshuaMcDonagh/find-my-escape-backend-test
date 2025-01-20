package com.tamworth.find_my_escape_backend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Location(@JsonProperty("title")String name, @JsonProperty("extract")String description, @JsonProperty("source")String imageUrl) { }
