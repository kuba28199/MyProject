package com.example.myproject;

import java.util.ArrayList;

public class Koszyk {
    private static ArrayList<Produkt> koszyk = new ArrayList<Produkt>();;

    public Koszyk(){
    }

    public static ArrayList<Produkt> PobierzKoszyk(){
        return koszyk;
    }
    public static void Add(Produkt produkt) {koszyk.add(produkt);}
}
