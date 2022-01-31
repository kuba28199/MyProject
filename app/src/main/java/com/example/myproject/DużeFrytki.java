package com.example.myproject;

public class DużeFrytki extends Frytki{
    String opis = "Duże frytki";
    float cena = 7f;

    Jedzenie jedzenie;

    public DużeFrytki(Jedzenie jedzenie){
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
