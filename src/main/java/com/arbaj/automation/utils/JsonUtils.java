package com.arbaj.automation.utils;

import java.io.File;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {
	
	private static final ObjectMapper mapper = new ObjectMapper();

    public static <T> List<T> readJsonArray(
            String filePath,
            Class<T> clazz
    ) {
        try {
            return mapper.readValue(
                new File(filePath),
                mapper.getTypeFactory()
                      .constructCollectionType(List.class, clazz)
            );
        } catch (Exception e) {
            throw new RuntimeException("Failed to read JSON file: " + filePath, e);
        }
    }

}
