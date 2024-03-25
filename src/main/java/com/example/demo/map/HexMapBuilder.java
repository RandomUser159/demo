package com.example.demo.map;

import javafx.scene.layout.StackPane;

public class HexMapBuilder {
    private HexTileBuilder hexTileBuilder;
    private HexMap hexMap;

    public HexMapBuilder(double size){
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

