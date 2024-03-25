package com.example.demo.material;

import javafx.scene.image.Image;

public class SinglePlate {
    private String area;

    private String animal;

    private String image;

    public SinglePlate(){}

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public String getAnimal() {
        return animal;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getArea() {
        return area;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    @Override
    public String toString() {
        return "SinglePlate{" +
                "area='" + area + '\'' +
                ", animal='" + animal + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}