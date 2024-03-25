package com.example.demo;

import com.example.demo.map.HexMapBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class GameController {
    @FXML
    private StackPane hexMap;


    public void initialize() throws JsonProcessingException {
        /*HexMapBuilder hexMapBuilder = new HexMapBuilder(15);
        hexMapBuilder.buildHexMap(hexMap, 10);*/
        Rectangle rectangle = new Rectangle(50, 50, 200, 100);
        rectangle.setFill(Color.BLUE);
        hexMap.getChildren().add(rectangle);
    }
}