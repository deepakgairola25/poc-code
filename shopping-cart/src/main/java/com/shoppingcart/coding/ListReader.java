package com.shoppingcart.coding;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shoppingcart.coding.entity.Item;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * 
 * @author Deepak Gairola
 *
 */
public class ListReader {
    private ObjectMapper objectMapper = new ObjectMapper();

	public List<Item> read(String fileName) {
        try {
            String items = new String(Files.readAllBytes(Paths.get(fileName)), StandardCharsets.UTF_8);
            return objectMapper.readValue(items, new TypeReference<List<Item>>() {});
        } catch (IOException e) {
           throw new MalformedListException(e);
        }
    }
}
