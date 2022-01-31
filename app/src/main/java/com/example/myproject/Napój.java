package com.example.myproject;

public class Napój extends Jedzenie{
    Jedzenie jedzenie;

    public Napój(Jedzenie jedzenie){
        this.jedzenie = jedzenie;
    }

    @Override
    public String Opis() {
        return jedzenie.Opis();
    }

    @Override
    public float Cena() {
        return jedzenie.Cena();
    }
}
