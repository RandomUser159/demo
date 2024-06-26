package com.example.demo.map;

import com.example.demo.Tile.DoubleTile;
import com.example.demo.Tile.SingleTile;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;

public class HexTileBuilder {
    // Die Größe eines Hexagons. Radius vom Mittelpunkt zu einem der Ecken.
    private final double size;


    // Konstruktor
    public HexTileBuilder(double size) {
        this.size = size;
    }

    public HexTile createHexTile(int q, int r) {
        HexTile hexagon = new HexTile(q, r);
        double centerX = calculateCenterX(q, r);
        double centerY = calculateCenterY(r);
        hexagon.getStyleClass().add("hex-tile");

        Point2D point2D = new Point2D(centerX, centerY);
        hexagon.setPoint(point2D);

        // Berechnung der Ecken des Hexagons und Hinzufügen zum Polygon
        return getHexTile(hexagon, centerX, centerY);
    }

    public HexTile createHexTile() {
        HexTile hexagon = new HexTile();
        double centerX = calculateCenterX(0, 0);
        double centerY = calculateCenterY(0);
        hexagon.getStyleClass().add("player-tile");

        hexagon.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY){
                hexagon.requestFocus();
                hexagon.setOnKeyPressed(event1 -> {
                    switch(event1.getCode()){
                        case RIGHT:
                            hexagon.setRotate(hexagon.getRotate() + 60);
                            if(hexagon.getPlayerTile().getClass().equals(DoubleTile.class)) {
                                hexagon.getPlayerTile().turnRight();
                            }
                            break;
                        case LEFT:
                            hexagon.setRotate(hexagon.getRotate() - 60);
                            if(hexagon.getPlayerTile().getClass().equals(DoubleTile.class)) {
                                hexagon.getPlayerTile().turnLeft();
                            }
                            break;
                        default:
                            break;
                    }
                    event1.consume();
                });
                event.consume();
            }
        });


        // Berechnung der Ecken des Hexagons und Hinzufügen zum Polygon
        return getHexTile(hexagon, centerX, centerY);
    }

    private HexTile getHexTile(HexTile hexagon, double centerX, double centerY) {
        for(int i = 0; i < 6; i++) {
            double angle = 2 * Math.PI / 6 * (i + 0.5);
            double x = centerX + size * Math.cos(angle);
            double y = centerY + size * Math.sin(angle);
            hexagon.getPoints().addAll(x, y);
        }
        return hexagon;
    }

    // Berechnet das Zentrum des Hexagons in der X-Achse
    private double calculateCenterX(int q, int r) {
        return size * (Math.sqrt(3) * q + Math.sqrt(3)/2 * r);
    }

    // Berechnet das Zentrum des Hexagons in der Y-Achse
    private double calculateCenterY(int r) {
        return size * (3.0/2 * r);
    }

}
