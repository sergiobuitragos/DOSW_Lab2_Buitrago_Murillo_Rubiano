package edu.eci.dosw.reto4;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Uses the conversion strategies provided by ExchangeRateStrategy
 * to convert amounts and carring a transaction record.
 */
public final class CurrencyConverter {
    
    private final ExchangeRateProvider rateProvider;
    private final List<Transaction> history = new ArrayList<>();

    public CurrencyConverter(ExchangeRateProvider rateProvider){
        this.rateProvider = rateProvider;
    }

    /**
     * Convierte un monto de una moneda source a una o mas monedas target.
     * @param amount
     * @param source
     * @param targets
     */
    public List<Transaction> convert(double amount, Currency source, List<Currency> targets){
        List<Transaction> result = new ArrayList<>();
        for(Currency target: targets){
            ExchangeRateStrategy strategy = rateProvider.getStrategy(source, target);
            double convertedAmount = strategy.convert(amount);
            Transaction transaction = new Transaction(amount, source, convertedAmount, target);
            history.add(transaction);
            result.add(transaction);
        }

        return result;
    }

    public List<Transaction> getHistory(){
        return Collections.unmodifiableList(history);
    }

    /**
     * Usa Stream para acumular el total convertido
     */
    public Map<Currency, Double> totalConvertedByCurrency(){
        return history.stream().collect(Collectors.groupingBy(Transaction::targetCurrency,
            Collectors.summingDouble(Transaction::convertedAmount)
        ));
    }
}
