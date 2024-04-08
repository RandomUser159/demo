package com.example.demo;

import com.example.demo.Tile.PlayerTile;

import java.util.List;

public class PlayerTilesWrapper {
    private List<PlayerTile> singleTile;
    private List<PlayerTile> doubleTile;

    public List<PlayerTile> getDoubleTile() {
        return doubleTile;
    }

    public void setDoubleTile(List<PlayerTile> doubleTile) {
        this.doubleTile = doubleTile;
    }

    public List<PlayerTile> getSingleTile() {
        return singleTile;
    }

    public void setSingleTile(List<PlayerTile> singleTile) {
        this.singleTile = singleTile;
    }
}
