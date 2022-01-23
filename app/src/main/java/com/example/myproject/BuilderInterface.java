package com.example.myproject;

interface BuilderInterface {
    BuilderInterface setImie(String imie);
    BuilderInterface setNazwisko(String nazwisko);
    BuilderInterface setNumer(int numer);
    BuilderZamowienie build();
}