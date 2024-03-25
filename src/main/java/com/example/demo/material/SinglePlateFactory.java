package com.example.demo.material;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.application.Platform;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class SinglePlateFactory {
    private ArrayList<SinglePlate> singlePlates;
    private SinglePlate singlePlate;
    public SinglePlateFactory() throws JsonProcessingException, JsonMappingException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayList<SinglePlate> singlePlates;
        try {
            this.singlePlates = objectMapper.readValue(new File("src/main/resources/com/example/demo/singlePlateMaterial.json"),new TypeReference<>(){});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
