package entities;

import entities.enums.Color;

public class Shape {

    private Color color;
    
    public double area(){
        return 0.0;
    }

    public Shape(){
        
    }

    public Shape(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    
}
