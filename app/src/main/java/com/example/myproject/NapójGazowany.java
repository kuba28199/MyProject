package com.example.myproject;

public class NapójGazowany extends Napój{
    String opis = "Napój gazowany 0,33l";
    float cena = 5.49f;

    Jedzenie jedzenie;

    public NapójGazowany(Jedzenie jedzenie){
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
