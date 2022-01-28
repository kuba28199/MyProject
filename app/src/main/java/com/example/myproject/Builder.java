package com.example.myproject;

public class Builder implements BuilderInterface {
    BuilderZamowienie Zamowienie = new BuilderZamowienie();

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
    public BuilderInterface setNumer(int numer) {
        Zamowienie.numer = numer;
        return this;
    }

    @Override
    public BuilderZamowienie build() {
        return Zamowienie;
    }
}