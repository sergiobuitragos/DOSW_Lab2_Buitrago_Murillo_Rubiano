package edu.eci.dosw.reto4;

import java.util.List;
import java.util.Map;

public final class Reto4 {
    private Reto4(){

    }

    public static void run(){
        System.out.println("Running Challenge 4");

        ExchangeRateProvider rateProvider = new ExchangeRateProvider();
        CurrencyConverter converter = new CurrencyConverter(rateProvider);
        List<Transaction> transactions = converter.convert(100.0, Currency.USD, List.of(
            Currency.EUR, Currency.JPY, Currency.COP
        ));

        transactions.forEach(System.out::println);

        converter.convert(50.0, Currency.EUR, List.of(Currency.USD));

        System.out.println("\n Accumulated totals by destination currency:");
        Map<Currency, Double> totals = converter.totalConvertedByCurrency();
        totals.forEach((currency, total) -> System.out.println(currency + ": " + total));
    }
}
