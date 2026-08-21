package edu.eci.dosw.reto4;

public record Transaction (double originalAmount, Currency currencySource, double convertedAmount, Currency targetCurrency){
    //Con un record tenemos inmutable los atributos y no necesitamos getters ni setters, ademas de que nos da un toString, hashCode y equals por defecto
    @Override
    public String toString(){
        return originalAmount + " " + currencySource + " = " + convertedAmount + " " + targetCurrency;
    }
}

