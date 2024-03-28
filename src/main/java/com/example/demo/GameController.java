package com.example.demo;

import com.example.demo.map.HexTile;
import com.example.demo.map.HexTileBuilder;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.ImagePattern;

import java.io.IOException;
import java.util.Objects;


public class GameController {
    @FXML
    private StackPane hexMap;

    public void initialize() throws IOException {

        /*HexMapBuilder hexMapBuilder = new HexMapBuilder(20);
        hexMapBuilder.buildHexMap(hexMap, 8);*/

        // Erstellen des HexTile
        HexTileBuilder hexTileBuilder = new HexTileBuilder(50);
        HexTile hexTile = hexTileBuilder.createHexTile(5,5);

        // Laden des Bildes und Erstellen eines ImagePattern
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("singlePlates/swamp-salmon-key.png")));
        ImagePattern imagePattern = new ImagePattern(image);

        hexTile.setFill(imagePattern);

        hexMap.getChildren().add(hexTile);



    }
}