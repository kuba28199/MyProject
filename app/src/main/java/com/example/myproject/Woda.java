package com.example.myproject;

public class Woda extends Napój{
    String opis = "Woda 0,5l";
    float cena = 4.99f;

    Jedzenie jedzenie;

    public Woda(Jedzenie jedzenie){
        super(jedzenie);
    }

    @Override
    public String Opis() {
        return super.Opis() + "," + opis;
    }

    @Override
    public float Cena() {
        return super.Cena() + cena;
    }
}
