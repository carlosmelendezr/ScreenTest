package com.carlosintranets.screentest;

/**
 * Created by Carlos M on 07/05/2019.
 */

public class Celda {
    private String nombre;
    private int x;
    private int y;

    public Celda() {
        this.x = -1;
        this.y = -1;

    }

    public Celda(String nombre, int x, int y) {
        this.nombre = nombre;
        this.x = x;
        this.y = y;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}