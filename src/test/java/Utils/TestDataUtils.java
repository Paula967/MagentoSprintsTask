package Utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class TestDataUtils {
    public static JsonNode readJsonFile(String filePath) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readTree(new File(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Failed to read JSON file: " + filePath, e);
        }
    }

    public static String getStringValue(JsonNode rootNode, String fieldName) {
        return rootNode.get(fieldName).asText();
    }
}
