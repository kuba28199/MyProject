package com.example.myproject;

public class Sok extends Napój{
    String opis = "Sok 0,33l";
    float cena = 4.99f;

    Jedzenie jedzenie;

    public Sok(Jedzenie jedzenie){
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
