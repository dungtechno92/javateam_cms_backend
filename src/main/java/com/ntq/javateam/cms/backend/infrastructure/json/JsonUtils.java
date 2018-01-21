package com.ntq.javateam.cms.backend.infrastructure.json;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;

public class JsonUtils {
    // Never reconfigure this mapper from outside
    public static final ObjectMapper MAPPER = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
            .configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false)
            .setSerializationInclusion(Include.NON_NULL);

    public static final String serialize(Object value) {
        try {
            return MAPPER.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            throw new JsonException(JsonException.JSON_PARSING_ERROR, e);
        }
    }

    public static final <T> T deserialize(String json, Class<T> type) {
        try {
            return MAPPER.readValue(json, type);
        } catch (IOException e) {
            throw new JsonException(JsonException.JSON_PARSING_ERROR, e);
        }
    }

    public static final <T> T convertValue(Object fromValue, Class<T> toValueType) {
        return MAPPER.convertValue(fromValue, toValueType);
    }
}
