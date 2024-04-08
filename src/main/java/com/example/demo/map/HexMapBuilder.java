package com.example.demo.map;

import com.example.demo.Tile.PlayerTile;
import com.example.demo.material.StartingTileFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class HexMapBuilder {
    private HexTileBuilder hexTileBuilder;
    private final HexMap hexMap;
    private final StartingTileFactory startingTileFactory = new StartingTileFactory();

    public HexMapBuilder(double size) throws IOException {
        this.hexTileBuilder = new HexTileBuilder(size);
        this.hexMap = new HexMap();
    }

    public void buildHexMap(StackPane container, int mapRadius){
        for(int q = -mapRadius; q <= mapRadius; q++) {
            int r1 = Math.max(-mapRadius, -q - mapRadius);
            int r2 = Math.min(mapRadius, -q + mapRadius);
            for(int r = r1; r <= r2; r++){
                HexTile hexTile = hexTileBuilder.createHexTile(q, r);
                hexMap.addTile(hexTile);
                hexTile.setTranslateX(hexTile.getPoint().getX());
                hexTile.setTranslateY(hexTile.getPoint().getY());
                container.getChildren().add(hexTile);
            }
        }
    }
}

