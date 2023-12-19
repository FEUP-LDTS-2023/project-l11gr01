package com.ldts1101.sotss;

public class Position {

    private int x;
    private int y;

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    @Override
    @SuppressWarnings("EqualsHashCode")
    public boolean equals(Object o) {
        if(!(o instanceof Position)) return false;

        return (this == o) ||
                (this.x == ((Position) o).x && this.y == ((Position) o).y);
    }
}