package edu.eci.dosw.reto4;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CurrencyConverterTest {

    @Test
    void differentCurrencyPairsUseDifferentRates() {
        CurrencyConverter converter = new CurrencyConverter(new ExchangeRateProvider());

        double eurResult = converter.convert(100, Currency.USD, List.of(Currency.EUR)).get(0).convertedAmount();
        double jpyResult = converter.convert(100, Currency.USD, List.of(Currency.JPY)).get(0).convertedAmount();

        assertNotEquals(eurResult, jpyResult,
                "Distintas monedas destino no deberían dar el mismo resultado (esto confirmaría una tasa única, lo cual el enunciado prohíbe).");
    }

    @Test
    void convertsToMultipleDestinationCurrenciesInOneCall() {
        CurrencyConverter converter = new CurrencyConverter(new ExchangeRateProvider());

        List<Transaction> results = converter.convert(
                100, Currency.USD, List.of(Currency.EUR, Currency.JPY, Currency.COP));

        assertEquals(3, results.size());
        assertEquals(Currency.EUR, results.get(0).targetCurrency());
        assertEquals(Currency.JPY, results.get(1).targetCurrency());
        assertEquals(Currency.COP, results.get(2).targetCurrency());
    }

    @Test
    void accumulatesTotalsGroupedByDestinationCurrencyAcrossMultipleTransactions() {
        CurrencyConverter converter = new CurrencyConverter(new ExchangeRateProvider());

        converter.convert(100, Currency.USD, List.of(Currency.EUR));
        converter.convert(50, Currency.USD, List.of(Currency.EUR));

        Map<Currency, Double> totals = converter.totalConvertedByCurrency();

        double expected = (100 * 0.92) + (50 * 0.92);
        assertEquals(expected, totals.get(Currency.EUR), 0.001);
    }

    @Test
    void sameCurrencyConversionReturnsSameAmount() {
        CurrencyConverter converter = new CurrencyConverter(new ExchangeRateProvider());

        double result = converter.convert(100, Currency.USD, List.of(Currency.USD)).get(0).convertedAmount();

        assertEquals(100.0, result, 0.001);
    }

    @Test
    void unsupportedCurrencyPairThrowsException() {
        ExchangeRateProvider provider = new ExchangeRateProvider();

        assertThrows(IllegalArgumentException.class,
                () -> provider.getStrategy(null, Currency.USD));
    }
}