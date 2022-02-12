package com.sn.org.uplevel;

public class Valuta {
    private String name;
    private Float kurs;

    public Valuta() {
    }

    public Valuta(String name, Float kurs) {
        this.name = name;
        this.kurs = kurs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getKurs() {
        return kurs;
    }

    public void setKurs(Float kurs) {
        this.kurs = kurs;
    }

    @Override
    public String toString() {
        return name+":  "+kurs;
    }
}
