package com.example.myproject;

public class Frytki extends Jedzenie{
    Jedzenie jedzenie;

    public Frytki(Jedzenie jedzenie){
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
