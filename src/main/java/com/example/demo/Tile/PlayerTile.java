package com.example.demo.Tile;

import com.example.demo.TerrainType;
import com.example.demo.TokenType;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import javafx.scene.shape.Polygon;

import java.util.ArrayList;
import java.util.List;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = SingleTile.class, name = "singletile"),
        @JsonSubTypes.Type(value = DoubleTile.class, name = "doubletile")
})

public class PlayerTile {
    private List<TokenType> allowedTokenTypes = new ArrayList<>();
    private List<TerrainType> terrainTypes = new ArrayList<>();
    private String imagePath;

    public PlayerTile(){

    }

    public List<TerrainType> getTerrainTypes() {
        return terrainTypes;
    }

    public void setTerrainTypes(List<TerrainType> terrainTypes) {
        this.terrainTypes = terrainTypes;
    }

    public List<TokenType> getAllowedTokenTypes() {
        return allowedTokenTypes;
    }

    public void setAllowedTokenTypes(List<TokenType> allowedTokenTypes) {
        this.allowedTokenTypes = allowedTokenTypes;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public void turnRight(){
        this.terrainTypes.add(0,this.terrainTypes.remove(this.terrainTypes.size() - 1));
        System.out.println(this.terrainTypes);
    }

    public void turnLeft(){
        this.terrainTypes.add(this.terrainTypes.remove(0));
        System.out.println(this.terrainTypes);
    }

    @Override
    public String toString() {
        return "PlayerTile{" +
                "allowedTokenTypes=" + allowedTokenTypes +
                ", terrainTypes=" + terrainTypes +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }
}
