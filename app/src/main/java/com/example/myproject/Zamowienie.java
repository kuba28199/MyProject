package com.example.myproject;

import java.util.ArrayList;
import java.lang.String;


//budowanie zamówienia używając buildera
//Zamowienie zamowienie = new Builder().setImie(imie).setNazwisko(nazwisko).setNumer(numer).build();

public class Zamowienie extends BuilderZamowienie{
    private Stan status = new Przyjęte();
    private ArrayList<Produkt> zamowienie;
    private String imie;
    private String nazwisko;
    private String numer;

    public ArrayList<Produkt> getZamowienie(){return zamowienie;}

    public String getIdentifier(){
        if (imie != null){
            return imie;
        }else
            if(nazwisko != null){
                return nazwisko;
            }else
                if(numer != null){
                    return numer;
                }
        return null;
    }

    public void addProduct(Produkt product){zamowienie.add(product);}

    public void zmienStatus(){
        if (status.equals(new Przyjęte())){
            status = new Przygotowywane();
        }else
            if (status.equals(new Przygotowywane())){
                status = new Gotowe();
            }
    }

    public String getStatus(){
        return status.getStatus();
    }
}

class Stan{
    private String status;

    public String getStatus(){return status;}
}

class Przyjęte extends Stan{
    private String status = "Twoje zamówienie zostało przyjęte";

    public String getStatus(){return status;}
}

class Przygotowywane extends Stan{
    private String status = "W trakcie przygotowywania";

    public String getStatus(){return status;}
}

class Gotowe extends Stan{
    private String status = "Gotowe do odbioru";

    public String getStatus(){return status;}
}
