package com.example.demo.map;

import com.example.demo.NeighbourArrayList;
import com.example.demo.Tile.PlayerTile;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Polygon;

import java.util.Objects;

public class HexTile extends Polygon {
    private final BooleanProperty selected = new SimpleBooleanProperty(false);
    private final BooleanProperty ableToBeOccupied = new SimpleBooleanProperty(false);
    private NeighbourArrayList<HexTile> neighbours = new NeighbourArrayList<>();
    private int q;
    private int r;
    private int s;
    private Point2D point;
    private PlayerTile playerTile;

    //private SinglePlate singlePlate;
    // Konstruktor
    public HexTile(int q, int r) {
        this.q = q;
        this.r = r;
        this.s = -q-r; // s ist immer -q - r, um die Regel q + r + s = 0 zu erfüllen
        if(this.q + this.r + this.s != 0){
            throw  new IllegalArgumentException("q + r + s must be 0");
        }

    }
    public HexTile(){

    }

    // Getter und Setter
    public int getQ() {
        return q;
    }

    public void setQ(int q) {
        this.q = q;
        this.s = -q - r; // Aktualisiere s, wenn q geändert wird
        if(this.q + this.r + this.s != 0){
            throw  new IllegalArgumentException("q + r + s must be 0");
        }
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
        this.s = -q - r; // Aktualisiere s, wenn r geändert wird
        if(this.q + this.r + this.s != 0){
            throw  new IllegalArgumentException("q + r + s must be 0");
        }
    }

    public int getS() {
        return s;
    }

    public void setS() {
        this.s = -q -r;
        if(this.q + this.r + this.s != 0){
            throw  new IllegalArgumentException("q + r + s must be 0");
        }
    }

    public void setPoint(Point2D point) {
        this.point = point;
    }

    public Point2D getPoint() {
        return point;
    }

    public PlayerTile getPlayerTile() {
        return playerTile;
    }

    public void setPlayerTile(PlayerTile playerTile) {
        this.playerTile = playerTile;
    }





    @Override
    public String toString() {
        return "HexTile{" +
                "q=" + q +
                ", r=" + r +
                ", s=" + s +
                ", point=" + point +
                '}';
    }
}