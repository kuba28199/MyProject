package com.example.myproject;

public class Builder implements BuilderInterface {
    Zamowienie Zamowienie = new Zamowienie();

    @Override
    public BuilderInterface setImie(String imie) {
        Zamowienie.imie = imie;
        return this;
    }

    @Override
    public BuilderInterface setNazwisko(String nazwisko) {
        Zamowienie.nazwisko = nazwisko;
        return this;
    }

    @Override
    public BuilderInterface setNumer(String numer) {
        Zamowienie.numer = numer;
        return this;
    }

    @Override
    public Zamowienie build() {
        return Zamowienie;
    }
}