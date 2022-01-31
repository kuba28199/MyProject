package com.example.myproject;

public class ŚrednieFrytki extends Frytki{
    String opis = "Średnie frytki";
    float cena = 5.5f;

    Jedzenie jedzenie;

    public ŚrednieFrytki(Jedzenie jedzenie){
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
