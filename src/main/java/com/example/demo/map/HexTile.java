package com.example.demo.map;

import com.example.demo.material.SinglePlate;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableBooleanValue;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Polygon;

import java.util.Objects;

public class HexTile extends Polygon {
    // Koordinaten des Hexagons
    private int q; // Die X-Koordinate
    private int r; // Die Y-Koordinate
    private int s; // Die Z-Koordinate, die aus q und r berechnet wird, um die Integrität des Koordinatensystems zu gewährleisten
    private Point2D point;
    private double angel = 0;

    //private SinglePlate singlePlate;
    // Konstruktor
    public HexTile(int q, int r) {
        this.q = q;
        this.r = r;
        this.s = -q-r; // s ist immer -q - r, um die Regel q + r + s = 0 zu erfüllen
        if(this.q + this.r + this.s != 0){
            throw  new IllegalArgumentException("q + r + s must be 0");
        }
        this.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
               this.requestFocus();
                this.setOnKeyPressed(event1 -> {
                    switch (event1.getCode()){
                        case RIGHT:
                            this.angel += 60;
                            this.setRotate(angel);
                            break;
                        case LEFT:
                            this.angel -= 60;
                            this.setRotate(angel);
                            break;
                        default:
                            break;
                    }
                    event1.consume();
                });
            }
        });

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

    public void setS(int s) {
        this.s = s;
        if(this.q + this.r + this.s != 0){
            throw  new IllegalArgumentException("q + r + s must be 0");
        }
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

    public void setPoint(Point2D point) {
        this.point = point;
    }

    public Point2D getPoint() {
        return point;
    }

}