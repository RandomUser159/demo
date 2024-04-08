package com.example.demo.map;

import javafx.geometry.Point2D;

import java.util.HashMap;
import java.util.Map;

public class HexMap {
    private Map<Point2D, HexTile> tiles = new HashMap<>();

    public void addTile(HexTile tile){
        tiles.put(tile.getPoint(), tile);
    }

    public HexTile getTile(int q, int r){
        return tiles.get(new HexTile(q,r).getPoint());
    }

    public Map<Point2D, HexTile> getTiles() {
        return tiles;
    }

    public void pintTiles(){
        tiles.forEach((key, value) -> System.out.println("pointX=" + key.getX() + " pointY=" + key.getY() + "/n" +
                "q=" + value.getQ() + " r=" + value.getR() + " s=" +value.getS()));
    }


}
