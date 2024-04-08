package com.example.demo.material;

import com.example.demo.Tile.PlayerTile;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StartingTileFactory {
    private final List<List<PlayerTile>> startingTileLists;

    private static final Random random = new Random();

    private static final File jsonFile = new File("src/main/resources/com/example/demo/package.json");

    public StartingTileFactory() throws JsonProcessingException, JsonMappingException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        this.startingTileLists = objectMapper.readValue(jsonFile, new TypeReference<List<List<PlayerTile>>>() {});
        startingTileLists.forEach(System.out::println);
    }

    public List<List<PlayerTile>> getStartingTileLists() {
        return startingTileLists;
    }
    public List<PlayerTile> getStartingTiles(){
        return startingTileLists.get(random.nextInt(this.startingTileLists.size()));
    }
}
