package com.example.myproject;

public interface Observable {
    public void createZamowienie(Observer o);
    public void setZamowienie(Observer o);
    public void getZamowienie(Observer o);
    public void notifyObserver();
}