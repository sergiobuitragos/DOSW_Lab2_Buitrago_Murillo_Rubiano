package edu.eci.dosw.reto3;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Verifies the rules of the purchase summary and vehicle creation logic.
 *
 * These tests validate subtotal calculation, the application of quantity and
 * amount-based discounts, discount composition, and invalid vehicle
 * combinations.
 *
 * Generated with assistance from Claude Sonnet 5.0.
 */
class PurchaseSummaryTest {

    /**
     * Numeric tolerance used for floating-point comparisons.
     */
    private static final double DELTA = 0.01;

    @Test
    void generalPurchaseShouldHaveNoDiscount() {
        // Land economy car (45,000,000) + water economy jet ski (55,000,000) =
        // 100,000,000
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(VehicleFactoryProvider.createVehicle("land", "economy", "car"));
        vehicles.add(VehicleFactoryProvider.createVehicle("water", "economy", "jet ski"));

        PurchaseSummary summary = new PurchaseSummary(vehicles);

        double expectedSubtotal = 100_000_000;
        assertEquals(expectedSubtotal, summary.calculateSubtotal(), DELTA);
        assertFalse(summary.isQuantityDiscountApplicable());
        assertFalse(summary.isAmountDiscountApplicable(expectedSubtotal));
        assertEquals(0, summary.calculateDiscountAmount(), DELTA);
        assertEquals(expectedSubtotal, summary.calculateFinalTotal(), DELTA);
    }

    @Test
    void quantityDiscountOnlyShouldApplyWhenMoreThanSixVehiclesAndLowSubtotal() {
        // 7 land economy bicycles (1,500,000 each) = 10,500,000 -> qualifies by
        // quantity, not by amount
        List<Vehicle> vehicles = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            vehicles.add(VehicleFactoryProvider.createVehicle("land", "economy", "bicycle"));
        }

        PurchaseSummary summary = new PurchaseSummary(vehicles);

        double expectedSubtotal = 10_500_000;
        double expectedTotal = expectedSubtotal * 0.90; // only 10% quantity discount
        double expectedDiscount = expectedSubtotal - expectedTotal;

        assertEquals(expectedSubtotal, summary.calculateSubtotal(), DELTA);
        assertTrue(summary.isQuantityDiscountApplicable());
        assertFalse(summary.isAmountDiscountApplicable(expectedSubtotal));
        assertEquals(expectedDiscount, summary.calculateDiscountAmount(), DELTA);
        assertEquals(expectedTotal, summary.calculateFinalTotal(), DELTA);
    }

    @Test
    void amountDiscountOnlyShouldApplyWhenSubtotalAboveThresholdAndFewVehicles() {
        // 1 air luxury plane = 2,500,000,000 -> qualifies by amount, not by quantity
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(VehicleFactoryProvider.createVehicle("air", "luxury", "plane"));

        PurchaseSummary summary = new PurchaseSummary(vehicles);

        double expectedSubtotal = 2_500_000_000.0;
        double expectedTotal = expectedSubtotal * 0.95; // only 5% amount discount
        double expectedDiscount = expectedSubtotal - expectedTotal;

        assertEquals(expectedSubtotal, summary.calculateSubtotal(), DELTA);
        assertFalse(summary.isQuantityDiscountApplicable());
        assertTrue(summary.isAmountDiscountApplicable(expectedSubtotal));
        assertEquals(expectedDiscount, summary.calculateDiscountAmount(), DELTA);
        assertEquals(expectedTotal, summary.calculateFinalTotal(), DELTA);
    }

    @Test
    void bothDiscountsShouldApplyTogetherWhenBothConditionsAreMet() {
        // 7 air economy planes (500,000,000 each) = 3,500,000,000
        // quantity = 7 (>6) and subtotal >= 500,000,000 -> both discounts apply,
        // compounded together
        List<Vehicle> vehicles = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            vehicles.add(VehicleFactoryProvider.createVehicle("air", "economy", "plane"));
        }

        PurchaseSummary summary = new PurchaseSummary(vehicles);

        double expectedSubtotal = 3_500_000_000.0;
        double expectedTotal = expectedSubtotal * 0.90 * 0.95; // 10% then 5% compounded
        double expectedDiscount = expectedSubtotal - expectedTotal;

        assertEquals(expectedSubtotal, summary.calculateSubtotal(), DELTA);
        assertTrue(summary.isQuantityDiscountApplicable());
        assertTrue(summary.isAmountDiscountApplicable(expectedSubtotal));
        assertEquals(expectedDiscount, summary.calculateDiscountAmount(), DELTA);
        assertEquals(expectedTotal, summary.calculateFinalTotal(), DELTA);
    }

    @Test
    void creatingVehicleWithInvalidCombinationShouldThrowException() {
        assertThrows(IllegalArgumentException.class,
                () -> VehicleFactoryProvider.createVehicle("space", "economy", "ufo"));
    }
}