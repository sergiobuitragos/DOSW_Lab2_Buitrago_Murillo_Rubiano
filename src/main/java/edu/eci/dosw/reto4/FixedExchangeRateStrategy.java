package edu.eci.dosw.reto4;

/**
 * hace la conversion usando una tasa de cambio para unas monedas
 */
public class FixedExchangeRateStrategy
        implements ExchangeRateStrategy {

    private final Currency sourceCurrency;

    private final Currency targetCurrency;

    private final double rate;

    /**
     * Strategy para conversion
     * @param sourceCurrency
     * @param targetCurrency
     * @param rate
     */
    public FixedExchangeRateStrategy(
            Currency sourceCurrency,
            Currency targetCurrency,
            double rate) {

        this.sourceCurrency = sourceCurrency;
        this.targetCurrency = targetCurrency;
        this.rate = rate;
    }

    /**
     * hace la conversion multiplicando
     *
     * @param amount
     * @return
     */
    @Override
    public double convert(double amount) {
        return amount * rate;
    }

    /**
     * @return
     */
    @Override
    public Currency getSourceCurrency() {
        return sourceCurrency;
    }

    /**
     * @return
     */
    @Override
    public Currency getTargetCurrency() {
        return targetCurrency;
    }

    /**
     * nos da la tasa de cambio
     * @return
     */
    @Override
    public double getRate() {
        return rate;
    }
}
