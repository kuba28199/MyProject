package com.example.myproject;

public class Burger extends Jedzenie{
    String opis = "Burger";
    float cena = 12f;

    @Override
    public String Opis() {
        return opis;
    }

    @Override
    public float Cena() {
        return cena;
    }
}
