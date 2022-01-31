package com.example.myproject;

import java.util.ArrayList;

public class ObservableZamowienie implements Observable {
    Zamowienie zamowienie = new Zamowienie();

    public ObservableZamowienie() {
        zamowienie.Produkty = new ArrayList<>();
    }

    @Override
    public void createZamowienie(Observer o) {
        zamowienie.Produkty.add(o);
        notifyObserver();
    }

    @Override
    public void setZamowienie(Observer o) {

    }

    @Override
    public void getZamowienie(Observer o) {

    }

    @Override
    public void notifyObserver() {
        //for (Observer o : zamowienie.Produkty)
          //  o.update();
    }
}