package com.example.myproject;

import java.util.ArrayList;

public class KolejkaZamowien {
    private ArrayList<BuilderZamowienie> kolejka;

    KolejkaZamowien() { }
    private static final KolejkaZamowien kolejka_zamowien = new KolejkaZamowien();
    public KolejkaZamowien getInstance() {return kolejka_zamowien;}

    public ArrayList get_kolejka(){return kolejka;}

    public void addOrder(BuilderZamowienie order){kolejka.add(order);}
}
