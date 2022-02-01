package com.example.myproject;

import java.util.ArrayList;

public class Koszyk {
    private static ArrayList<Produkt> koszyk = new ArrayList<Produkt>();

    Koszyk(){
    }

    public static ArrayList<Produkt> PobierzKoszyk(){
        return koszyk;
    }
}
