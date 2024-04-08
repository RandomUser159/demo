package com.example.demo.material;

import com.example.demo.PlayerTilesWrapper;
import com.example.demo.Tile.PlayerTile;
import com.example.demo.map.HexTile;
import com.example.demo.map.HexTileBuilder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayerPlateFactory {

    private final List<PlayerTile> tiles = new ArrayList<>();
    private ArrayList<HexTile> hexTiles = new ArrayList<>();

    private final HexTileBuilder hexTileBuilder = new HexTileBuilder(50);
    private static final File jsonFile = new File("src/main/resources/com/example/demo/materialTest.json");

    public PlayerPlateFactory() throws JsonProcessingException, JsonMappingException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            PlayerTilesWrapper tilesWrapper = objectMapper.readValue(jsonFile, PlayerTilesWrapper.class);
            List<PlayerTile> singleTiles = tilesWrapper.getSingleTile();
            List<PlayerTile> doubleTiles = tilesWrapper.getDoubleTile();

            tiles.addAll(tilesWrapper.getSingleTile());
            tiles.addAll(tilesWrapper.getDoubleTile());

            Collections.shuffle(tiles);

            for (int i = 0; i < tiles.size(); i++ ){
                hexTiles.add(hexTileBuilder.createHexTile());
                hexTiles.get(i).setPlayerTile(tiles.get(i));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public ArrayList<HexTile> getHexTiles() {
        return hexTiles;
    }

    public List<PlayerTile> getTiles() {
        return tiles;
    }

}
