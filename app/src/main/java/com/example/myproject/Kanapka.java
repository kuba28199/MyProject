package com.example.myproject;

public class Kanapka extends Jedzenie{
    String opis = "Kanapka";
    float cena = 8f;

    @Override
    public String Opis() {
        return opis;
    }

    @Override
    public float Cena() {
        return cena;
    }
}
