package com.example.myproject;

public class MałeFrytki extends Frytki{
    String opis = "Małe frytki";
    float cena = 4f;

    Jedzenie jedzenie;

    public MałeFrytki(Jedzenie jedzenie){
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
