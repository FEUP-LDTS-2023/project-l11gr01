package com.ldts1101.sotss;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.graphics.TextImage;

import java.util.ArrayList;
import java.util.List;


public abstract class Element {

    protected List<Position> positions;
    protected TextImage image;

    Element() {
        this.positions = new ArrayList<>();
    }

    public List<Position> getPositions() {
        return positions;
    }
    public void setPosition(Position position) {
        positions.add(position);
    }


    public void moveUp(){
        for (Position position : positions) {
            position.setY(position.getY() - 1);
        }
    }

    public void moveDown(){
        for (Position position : positions) {
            position.setY(position.getY() + 1);
        }
    }
    public void moveLeft(){
        for (Position position : positions) {
            position.setX(position.getX() - 1);
        }
    }

    public void moveRight(){
        for (Position position : positions) {
            position.setX(position.getX() + 1);
        }
    }

    public void draw(TextGraphics graphics) {
        graphics.drawImage(new TerminalPosition(positions.get(0).getX(), positions.get(0).getY()), image);
    }
}
