package edu.eci.dosw.reto4;
/**
 * el comportamiento de las monedas
 * la interfaz de Strategy
 */
public interface ExchangeRateStrategy {

    /**
     * convierte de una moneda a otra usando strategy
     * 
     * @param amount
     * @return
     */
    double convert(double amount);

    /**
     * @return
     */
    Currency getSourceCurrency();

    /**
     * @return
     */
    Currency getTargetCurrency();

    /**
     * @return
     */
    double getRate();
}
