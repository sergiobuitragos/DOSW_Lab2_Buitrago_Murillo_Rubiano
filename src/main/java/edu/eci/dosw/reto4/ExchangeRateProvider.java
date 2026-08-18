package edu.eci.dosw.reto4;

import java.util.HashMap;
import java.util.Map;

/**
 * da las tasas de cambio para hacer las conversiones
 */
public class ExchangeRateProvider {

    /*
     * guarda las tasas de cambio
     * clave par de monedas y valor la tasa de cambio
     */
    private final Map<String, Double> rates = new HashMap<>();

    /**
     * cada moneda tiene su tasa 
     */
    public ExchangeRateProvider() {

        addRate(Currency.USD, Currency.EUR, 0.92);
        addRate(Currency.USD, Currency.JPY, 148.50);
        addRate(Currency.USD, Currency.COP, 4000.00);

        addRate(Currency.EUR, Currency.USD, 1.09);
        addRate(Currency.EUR, Currency.JPY, 161.50);
        addRate(Currency.EUR, Currency.COP, 4350.00);

        addRate(Currency.JPY, Currency.USD, 0.0067);
        addRate(Currency.JPY, Currency.EUR, 0.0062);
        addRate(Currency.JPY, Currency.COP, 27.00);

        addRate(Currency.COP, Currency.USD, 0.00025);
        addRate(Currency.COP, Currency.EUR, 0.00023);
        addRate(Currency.COP, Currency.JPY, 0.037);
    }

    /**
     * Agrega una tasa de cambio
     */
    private void addRate(
            Currency source,
            Currency target,
            double rate) {

        String key =
                source.name() + "_" + target.name();

        rates.put(key, rate);
    }

    /**
     * da la estrategia de conversion para unas monedas 
     */
    public ExchangeRateStrategy getStrategy(
            Currency source,
            Currency target) {
        if (source == null || target == null) {
            throw new IllegalArgumentException(
                    "Las monedas no pueden ser null");
        }

        if (source == target) {
            return new FixedExchangeRateStrategy(
                    source,
                    target,
                    1.0);
        }

        String key =
                source.name() + "_" + target.name();

        Double rate = rates.get(key);

        if (rate == null) {
            throw new IllegalArgumentException(
                    "No existe una tasa para "
                            + source + " -> " + target);
        }

        return new FixedExchangeRateStrategy(
                source,
                target,
                rate);
    }
}
