package com.example.myproject;

public class BuilderZamowienie {
    public String imie;
    public String nazwisko;
    public String numer;

    BuilderZamowienie Zamowienie = new Builder().setImie("Hello").setNazwisko("World").setNumer("1").build();
}