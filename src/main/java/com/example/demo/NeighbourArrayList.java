package com.example.demo;

import com.example.demo.map.HexTile;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

public class NeighbourArrayList<T extends HexTile>{
    private final ObservableList<T> neighbourList;
    private final static int capacity = 6;

    public NeighbourArrayList(){
        this.neighbourList = FXCollections.observableArrayList();
    }

    public void addListener(ListChangeListener<? super T> listener) {
        neighbourList.addListener(listener);
    }

    public void removeListener(ListChangeListener<? super T> listener) {
        neighbourList.removeListener(listener);
    }

    public ObservableList<T> getUnderlyingList() {
        return neighbourList;
    }

    public boolean add(T e) {
        if (neighbourList.size() < capacity) {
            return neighbourList.add(e);
        } else {
            throw new IllegalStateException("invalid capacity: max = 6");
        }
    }
}