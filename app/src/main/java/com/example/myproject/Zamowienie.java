package com.example.myproject;

import java.util.ArrayList;
import java.lang.String;

public class Zamowienie {
    private Stan status;
    private ArrayList<Produkt> zamowienie;
    private String id;

    public String getId(){return id;}
    public ArrayList<Produkt> getZamowienie(){return zamowienie;}

    public void setId(String id){this.id=id;}
    public void setId(int id){this.id= String.valueOf(id);}

    public void addProduct(Produkt product){zamowienie.add(product);}

    public void zmienStatus(Stan nowy_status){status = nowy_status;}
}

class Stan{
    private String status;
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
