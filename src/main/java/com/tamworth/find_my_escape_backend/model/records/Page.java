package com.tamworth.find_my_escape_backend.model.records;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Page(int pageid, int ns, String title, Original original, String extract) {
}
