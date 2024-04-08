package com.example.demo;

import com.example.demo.map.HexMapBuilder;

import com.example.demo.map.HexTile;
import com.example.demo.material.PlayerPlateFactory;
import com.example.demo.material.StartingTileFactory;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.ImagePattern;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;


public class GameController {
    @FXML
    private StackPane hexMap;
    @FXML
    private GridPane tileTokenGrid;
    private final PlayerPlateFactory playerPlateFactory = new PlayerPlateFactory();
    private final ArrayList<HexTile> hexTiles = this.playerPlateFactory.getHexTiles();
    public GameController() throws IOException {
    }

    public void initialize() throws IOException {
        loadStaringMap();
        loadStartingHand();
    }

    private void loadStartingHand(){
        for(int i = 0; i < tileTokenGrid.getColumnCount(); i++){
            HexTile hexTile = hexTiles.get(i);
            Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(hexTile.getPlayerTile().getImagePath())));
            ImagePattern imagePattern = new ImagePattern(image);
            hexTile.setFill(imagePattern);
            tileTokenGrid.add(hexTile,i,0);
        }
    }

    private void loadStaringMap() throws IOException {
        HexMapBuilder hexMapBuilder = new HexMapBuilder(20);
        hexMapBuilder.buildHexMap(hexMap, 8);
    }

}