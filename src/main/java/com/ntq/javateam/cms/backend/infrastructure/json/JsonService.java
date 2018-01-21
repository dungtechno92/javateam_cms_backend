package com.ntq.javateam.cms.backend.infrastructure.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class JsonService {
    @Autowired
    ObjectMapper objectMapper;

    public String serialize(Object value) {
        try {
            return objectMapper.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            throw new JsonException(JsonException.JSON_PARSING_ERROR, e);
        }
    }

    public <T> T deserialize(String json, Class<T> type) {
        try {
            return objectMapper.readValue(json, type);
        } catch (IOException e) {
            throw new JsonException(JsonException.JSON_PARSING_ERROR, e);
        }
    }
}
